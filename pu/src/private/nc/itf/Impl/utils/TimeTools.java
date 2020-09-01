package nc.itf.Impl.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeTools {

    public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String Y_M_D_H_M= "yyyy-MM-dd HH:mm";
    public static final String Y_M_D_H= "yyyy-MM-dd HH";
    public static final String Y_M_D= "yyyy-MM-dd";
    public static final String Y= "yyyy";
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    /**
     * ʱ��ת�ַ���
     * @param date
     * @param reg
     * @return
     */
    public static String DateStr(Date date, String reg) {
        if(StringUtils.isNotEmpty(reg) && null != date){
            if(Y_M_D_H_M_S.equals(reg)){
                return new SimpleDateFormat(Y_M_D_H_M_S).format(date);
            }else if(Y_M_D_H_M.equals(reg)){
                return new SimpleDateFormat(Y_M_D_H_M).format(date);
            }else if(Y_M_D_H.equals(reg)){
                return new SimpleDateFormat(Y_M_D_H).format(date);
            }else if(Y_M_D.equals(reg)){
                return new SimpleDateFormat(Y_M_D).format(date);
            }

        }
        return null;
    }

    /**
     * �ַ���תʱ��
     * @param dateStr
     * @param reg
     * @return
     */
    public static Date DateFormate(String dateStr, String reg) {
        if(StringUtils.isNotEmpty(reg) && StringUtils.isNotEmpty(reg)){
            try {
                if(Y_M_D_H_M_S.equals(reg)){
                    return new SimpleDateFormat(Y_M_D_H_M_S).parse(dateStr);
                }else if(Y_M_D_H_M.equals(reg)){
                    return new SimpleDateFormat(Y_M_D_H_M).parse(dateStr);
                }else if(Y_M_D_H.equals(reg)){
                    return new SimpleDateFormat(Y_M_D_H).parse(dateStr);
                }else if(Y_M_D.equals(reg)){
                    return new SimpleDateFormat(Y_M_D).parse(dateStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * ����ʱ��ָ�
     * @param start
     * @param end
     * @return
     */
    public static JSONArray TimeDivision(String start, String end) {
        if(StringUtils.isNotEmpty(start) && StringUtils.isNotEmpty(end)){
            start = DateStr(DateFormate(start,Y_M_D_H_M_S), Y_M_D_H_M_S);
            end = DateStr(DateFormate(end,Y_M_D_H_M_S), Y_M_D_H_M_S);
            JSONArray jsonArr = new JSONArray();
            if(ExtendDay(start,end)){
                do{
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("start", start);
                    long stTemp = DateFormate(start,Y_M_D).getTime();
                    Calendar calendar = Calendar.getInstance();//��ȡ����ʵ��
                    calendar.setTime(new Date(stTemp));
                    calendar.add(Calendar.DAY_OF_MONTH, 1);  //����Ϊ��һ��
                    start= DateStr(calendar.getTime(), Y_M_D_H_M_S);
                    jsonObj.put("end", start);
                    jsonArr.add(jsonObj);
                }while(ExtendDay(start,end));
                if(!start.equals(end)){
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("start", start);
                    jsonObj.put("end", end);
                    jsonArr.add(jsonObj);
                }
            }else{
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("start", start);
                jsonObj.put("end", end);
                jsonArr.add(jsonObj);
            }
            return jsonArr;
        }
        return null;
    }

    /**
     * ʱ���Ƿ����
     * ����ʱ��Ϊ�ڶ�����㲻�����
     * @param start
     * @param end
     * @return
     */
    public static boolean ExtendDay(String start, String end) {
        try {
            long stTimeStamp = DateFormate(start,Y_M_D).getTime();
            long edTimeStamp = DateFormate(end,Y_M_D).getTime();
            if(edTimeStamp > stTimeStamp){
                Calendar calendar = Calendar.getInstance();//��ȡ����ʵ��
                calendar.setTime(new Date(stTimeStamp));
                calendar.add(Calendar.DAY_OF_MONTH, 1);  //����Ϊ��һ��
                String tomorrow= DateStr(calendar.getTime(), Y_M_D_H_M_S);
                if(!tomorrow.equals(end)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * ��ȡ��һ��
     * @param time
     * @return
     */
    public static String getTomorrow(String time) {
        String result = "";
        if(StringUtils.isNotEmpty(time)){
            long timeStamp = DateFormate(time,Y_M_D_H_M_S).getTime();
            Calendar calendar = Calendar.getInstance();//��ȡ����ʵ��
            calendar.setTime(new Date(timeStamp));
            calendar.add(Calendar.DAY_OF_MONTH, 1);  //����Ϊ��һ��
            result = DateStr(calendar.getTime(), Y_M_D_H_M_S);
        }
        return result;
    }

    /**
     * ��ȡǰһ��
     * @param time
     * @return
     */
    public static String getYesterday(String time) {
        String result = "";
        if(StringUtils.isNotEmpty(time)){
            long timeStamp = DateFormate(time,Y_M_D_H_M_S).getTime();
            Calendar calendar = Calendar.getInstance();//��ȡ����ʵ��
            calendar.setTime(new Date(timeStamp));
            calendar.add(Calendar.DAY_OF_MONTH, -1);  //����Ϊ��һ��
            result = DateStr(calendar.getTime(), Y_M_D_H_M_S);
        }
        return result;
    }

    public static void main(String[] args) {
        Date start = DateFormate("2018-07-26 08:00:00",TimeTools.Y_M_D_H_M_S);
        Date end = DateFormate("2018-07-26 08:00:00",TimeTools.Y_M_D_H_M_S);
        boolean flag = TimeTools.compareTime(start,end);
        Date firstday = TimeTools.getCurrentMonthFirst(new Date());
        Date lastday = TimeTools.getCurrentMonthLast(new Date());
        System.out.println(DateStr(firstday,TimeTools.Y_M_D_H_M_S));
        System.out.println(DateStr(lastday,TimeTools.Y_M_D_H_M_S));

    }
    /**
     * ��ȡĳ��ʱ�䵱ǰ�����һ��
     * @param date
     * @return
     */
    public static Date getCurrentMonthLast(Date date) {
        if(null != date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.DAY_OF_MONTH, 0);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 999);
            return cal.getTime();
        }
        return null;
    }
    /**
     * ��ȡĳ��ʱ�䵱ǰ�µ�һ��
     * @param date
     * @return
     */
    public static Date getCurrentMonthFirst(Date date) {
        if(null != date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 0);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
        }
        return null;
    }

    /**
     * ʱ��Ƚ�
     * @param start
     * @param end
     * @return
     */
    public static boolean compareTime(Date start, Date end) {
        if(null != start && null != end) {
            if(start.getTime() < end.getTime()) {
                return true;
            }
        }
        return false;
    }

    /**
     * ��ȡ���ʱ���о���ĳ��ʱ�������ʱ�䣨ֻ���������������ݶȲ�Ϊ�յ������
     *ʱ����ȡ����ֵ
     * @param dateArrParam
     * @param param
     * @return
     */
    public static Date getMinDistanceTime(Date[] dateArrParam, Date param) {
        if(null != dateArrParam && dateArrParam.length > 0 && null != param) {
            // ��ʼ�����ʱ�䣬Ĭ��Ϊ��һ��
            long minDiff = Math.abs(param.getTime() - dateArrParam[0].getTime());
            int min = 0;
            for (int i = 0; i < dateArrParam.length; i++) {
                long diff = Math.abs(param.getTime() - dateArrParam[i].getTime());
                if (diff < minDiff) {
                    min = i;
                    minDiff = diff;
                }
            }
            return dateArrParam[min];
        }
        return null;
    }

    /**
     * ��ȡ��ǰ��
     * @return
     */
    public static String getCurrentYeart() {

        return new SimpleDateFormat(Y).format(new Date());
    }

}
