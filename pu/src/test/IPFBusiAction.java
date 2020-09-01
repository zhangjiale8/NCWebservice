import java.util.HashMap;

import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.workflownote.WorkflownoteVO;
import nc.vo.uap.pf.PFBatchExceptionInfo;

public interface IPFBusiAction {

        /**
         * ����ƽ̨���еĵ��ݶ�������
         * <li>����ִ��ǰ�Ĺ���������(�����ɾ��)
         * <li>���ж���Լ�����
         * <li>ִ�ж����ű�
         * <li>�жϷ���ֵ �Ƿ�ֱ�ӷ���
         * <li>�ж϶����Ƿ�Ϊ���һ������,ִ�ж�������
         * <li>����ִ�к�Ĺ���������,����������
         *
         * @param actionName �������룬����"SAVE"/"APPROVE"
         * @param billType ��������PK
         * @param currentDate ��ǰ����
         * @param worknoteVO ������VO
         * @param billvo ���ݾۺ�VO
         * @param userObj �û�����
         * @param eParam ��������
         * @return ����������ֵ
         * @throws BusinessException
         */
        public Object processAction(String actionName, String billType, WorkflownoteVO worknoteVO,
                        AggregatedValueObject billvo, Object userObj, HashMap eParam) throws BusinessException;

        /**
         * ����������������
         * <li>����һ�鵥��VO����,���ж���ִ��ǰ�Ĺ���������(�����ɾ��)�Ͷ���Լ�����
         * <li>ִ�ж����ű�
         * <li>���������ĵ���VO����,�ж϶����Ƿ�Ϊ���һ������,ִ�ж�������; ͬʱ���ж���ִ�к�Ĺ���������,��������������
         *  
         * @param actionName �������룬����"SAVE","APPROVE"
         * @param billType ��������PK
         * @param currentDate ��������
         * @param billvos ���ݾۺ�VO����
         * @param userObjAry �û���������
         * @param worknoteVO ������VO
         * @param retError
         * @return ������������ֵ
         * @throws BusinessException
         */
        public Object[] processBatch(String actionName, String billType, AggregatedValueObject[] billvos,
                        Object[] userObjAry, WorkflownoteVO worknoteVO, HashMap eParam, PFBatchExceptionInfo exceptionInfo) throws BusinessException;
       
        /**
         * ������������һ����
         * <li>����һ�鵥��VO����,���ж���ִ��ǰ�Ĺ���������(�����ɾ��)�Ͷ���Լ�����
         * <li>ִ�ж����ű�
         * <li>���������ĵ���VO����,�ж϶����Ƿ�Ϊ���һ������,ִ�ж�������; ͬʱ���ж���ִ�к�Ĺ���������,��������������
         *  
         * @param actionName �������룬����"SAVE","APPROVE"
         * @param billType ��������PK
         * @param currentDate ��������
         * @param billvos ���ݾۺ�VO����
         * @param userObjAry �û���������
         * @param worknoteVO ������VO
         * @param retError
         * @return ������������ֵ
         * @throws BusinessException
         */
        public Object[] processBatch(String actionName, String billType, AggregatedValueObject[] billvos,
                        Object[] userObjAry, WorkflownoteVO worknoteVO, HashMap eParam) throws BusinessException;

}