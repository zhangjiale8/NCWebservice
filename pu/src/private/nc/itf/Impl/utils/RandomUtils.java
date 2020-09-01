package nc.itf.Impl.utils;

import java.util.Random;

public class RandomUtils {
    /**
     * 获取随机字符
     * 0-9，A-Z
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random rd = new Random(); // 创建随机对象
        String uuid = "";            //保存随机数
        int rdGet; // 取得随机数
        do {
            if (rd.nextInt() % 2 == 1) {
                rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
            } else{
                rdGet = Math.abs(rd.nextInt()) % 26 + 65; // 产生65到90的随机数(a-z的键位值)
            }
            char num1 = (char) rdGet;           //int转换char
            String dd = Character.toString(num1);
            uuid += dd;
        } while (uuid.length() < length);// 设定长度，此处假定长度小于8

        return uuid;
    }
}
