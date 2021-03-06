package nc.bs.so.m33.biz.m4c.bp.square.ar;

import java.util.HashMap;
import java.util.Map;

import nc.bs.so.m33.biz.m4c.rule.toar.GetNewARorgVidFor4CRule;
import nc.bs.so.m33.biz.m4c.rule.toar.ToARCheckFor4CRule;
import nc.bs.so.m33.maintain.m4c.InsertSquareOutDetailBP;
import nc.bs.so.m33.maintain.m4c.rule.detail.RewriteARRushIncomeFor4CRule;
import nc.bs.so.m33.plugin.BPPlugInPoint;
import nc.impl.pubapp.pattern.database.DBTool;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.itf.scmpub.reference.arap.ArapServicesForSOUtil;
import nc.vo.arap.verify.AdjuestVO;
import nc.vo.pubapp.pattern.pub.MathTool;
import nc.vo.so.m33.m4c.entity.SquareOutDetailVO;
import nc.vo.so.m33.m4c.entity.SquareOutVO;
import nc.vo.so.m33.m4c.entity.SquareOutVOUtils;
import nc.vo.so.m33.m4c.entity.SquareOutViewVO;

/**
 * 基于签收开票退回的出库单传回冲应收bp
 * 
 * @since 6.0
 * @version 2011-7-1 下午12:40:04
 * @author zhangcheng
 */
public class SquareARRushIncomeFor4CSBP {

  public void square(SquareOutVO[] sqvos) {
    if (sqvos == null || sqvos.length == 0) {
      return;
    }

    AroundProcesser<SquareOutVO> processer =
        new AroundProcesser<SquareOutVO>(
            BPPlugInPoint.SquareARRushIncomeFor4CSBP);

    // 增加执行前业务规则
    this.addBeforeRule(processer);

    processer.before(sqvos);

    // 保存回冲明细vo
    SquareOutDetailVO[] dvos = this.saveSquareOutDetail(sqvos);

    // 传回冲应收
    this.toEstVerify(dvos, sqvos);

    AroundProcesser<SquareOutDetailVO> aprocesser =
        new AroundProcesser<SquareOutDetailVO>(
            BPPlugInPoint.SquareARRushIncomeFor4CSDetailSBP);
    this.addAfterRule(aprocesser);
    aprocesser.after(dvos);
  }

  private void addAfterRule(AroundProcesser<SquareOutDetailVO> processer) {
    // 回写累计回冲结算数量
    IRule<SquareOutDetailVO> rule = new RewriteARRushIncomeFor4CRule();
    processer.addAfterRule(rule);
  }

  private void addBeforeRule(AroundProcesser<SquareOutVO> processer) {
    // 应收结算前获取应收组织最新组织版本
    IRule<SquareOutVO> rule = new GetNewARorgVidFor4CRule();
    processer.addBeforeRule(rule);

    rule = new ToARCheckFor4CRule();
    processer.addBeforeRule(rule);
  }

  private SquareOutDetailVO[] saveSquareOutDetail(SquareOutVO[] sqvos) {
    // 将传回冲收入结算单VO转化为传回冲收入结算明细VO
    SquareOutDetailVO[] bills =
        SquareOutVOUtils.getInstance().changeSQVOtoSQDVOForARRUSH(sqvos);

    DBTool dao = new DBTool();
    String[] pks = dao.getOIDs(bills.length);
    int i = 0;
    for (SquareOutDetailVO dvo : bills) {
      dvo.setCsalesquaredid(pks[i]);
      dvo.setProcesseid(pks[i]);
      i++;
    }
    // 回冲应收明细保存BP
    new InsertSquareOutDetailBP().insert(sqvos, bills);

    return bills;
  }

  private void toEstVerify(SquareOutDetailVO[] dvos, SquareOutVO[] sqvos) {
    SquareOutViewVO[] sviewvos =
        SquareOutVOUtils.getInstance().changeToSaleSquareViewVO(sqvos);
    Map<String, SquareOutViewVO> mapsview =
        new HashMap<String, SquareOutViewVO>();
    for (SquareOutViewVO vo : sviewvos) {
      mapsview.put(vo.getItem().getCsalesquarebid(), vo);
    }

    // 查询上游出库单暂估应收记录
    /*    String[] outBids =
            AggVOUtil.getDistinctItemFieldArray(sqvos, SquareOutBVO.CSRCBID,
                String.class);
        Map<String, SquareOutDetailVO> outmap =
            new Square434CQueryImpl().queryETIncomeDvosBy4CBID(outBids);*/

    // 准备回冲应收接口参数
    AdjuestVO[] vos = new AdjuestVO[dvos.length];
    int i = 0;
    for (SquareOutDetailVO dvo : dvos) {
      vos[i] = new AdjuestVO();
      SquareOutViewVO view = mapsview.get(dvo.getCsalesquarebid());

      // 将上游出库结算单id赋给回冲应收单
      // SquareOutDetailVO etoutdvo = outmap.get(view.getItem().getCsrcbid());
      // (之前暂存在传入SquareARRushIncomeFor4CSBP的SquareOutVO[]中)
      vos[i].setEst_top_itemid(view.getItem().getProcesseid());

      // 回冲结算明细id传给回冲应收单
      vos[i].setTop_itemid(dvo.getCsalesquaredid());

      // 回冲批次号，回冲应收单使用
      // TODO 其实有了回冲结算明细id传给回冲应收单，回冲批次号也没有用了，取消时直接用回冲结算明细id
      vos[i].setClbh(dvo.getProcesseid());

      // 回冲数量(应收应付要求数量符号和暂估数量一样,而销售结算存储符号与暂估数量相反,所以取反)
      vos[i].setQuantity(MathTool.oppose(view.getItem().getNthisnum()));
      i++;
    }

    // 回冲应收传财务
    ArapServicesForSOUtil.estVerify(vos);
  }

}
