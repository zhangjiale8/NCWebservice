package nc.itf.Impl.utils;

import java.util.Random;

public class RandomUtils {
    /**
     * ��ȡ����ַ�
     * 0-9��A-Z
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random rd = new Random(); // �����������
        String uuid = "";            //���������
        int rdGet; // ȡ�������
        do {
            if (rd.nextInt() % 2 == 1) {
                rdGet = Math.abs(rd.nextInt()) % 10 + 48; // ����48��57�������(0-9�ļ�λֵ)
            } else{
                rdGet = Math.abs(rd.nextInt()) % 26 + 65; // ����65��90�������(a-z�ļ�λֵ)
            }
            char num1 = (char) rdGet;           //intת��char
            String dd = Character.toString(num1);
            uuid += dd;
        } while (uuid.length() < length);// �趨���ȣ��˴��ٶ�����С��8

        return uuid;
    }
}
