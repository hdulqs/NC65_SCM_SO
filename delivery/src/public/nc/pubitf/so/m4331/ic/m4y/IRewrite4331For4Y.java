package nc.pubitf.so.m4331.ic.m4y;

import nc.vo.pub.BusinessException;

/**
 * <p>
 * <b>������Ҫ������¹��ܣ�</b>
 * <ul>
 * <li>������Ϊ�������ⵥ�ṩ�Ļ�д��
 * </ul>
 * <p>
 * 
 * @version ���汾�� 6.0
 * @since ��һ�汾�� 5.6
 * @author ף����
 * @time 2010-3-23 ����06:38:24
 */
public interface IRewrite4331For4Y {
  /**
   * ����������������д�������ϵ��ۼƳ��������ֶΡ�
   * <p>
   * <b>����˵��</b>
   * 
   * @param paras
   * @throws BusinessException
   *           <p>
   * @author ף����
   * @time 2010-3-23 ����06:38:40
   */
  void rewrite4331OutNumFor4Y(RewritePara4331For4Y[] paras)
      throws BusinessException;
}