package nc.ui.so.m38.arrange.editor.eidthandler;

import nc.ui.pub.bill.BillListPanel;
import nc.ui.pubapp.billref.push.PushBillEvent;
import nc.ui.so.m38.arrange.pub.M38ArrangeModelCalculator;
import nc.ui.so.pub.keyvalue.ListKeyValue;
import nc.vo.so.m30.entity.SaleOrderBVO;
import nc.vo.so.m30.rule.PieceCalRule;
import nc.vo.so.m30.rule.WeightVolumeCalRule;
import nc.vo.so.pub.enumeration.ListTemplateType;
import nc.vo.so.pub.keyvalue.IKeyValue;

public class NumEditHandler {

  public void afterEdit(BillListPanel listPanel, PushBillEvent e) {

    int row = e.getEditEvent().getRow();
    int[] rows = new int[] {
      row
    };
    IKeyValue keyValue = new ListKeyValue(listPanel, row, ListTemplateType.SUB);

    // ��������
    M38ArrangeModelCalculator calculator =
        new M38ArrangeModelCalculator(listPanel);
    calculator.calculate(rows, SaleOrderBVO.NNUM);

    // ���㵥λ�������������
    WeightVolumeCalRule wvcalrule = new WeightVolumeCalRule(keyValue);
    wvcalrule.calculateWeightVolume(row);

    PieceCalRule piececalrule = new PieceCalRule(keyValue);
    piececalrule.calcPiece(row);

  }

}