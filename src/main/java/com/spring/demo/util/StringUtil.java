package com.spring.demo.util;


import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 工具类
 * Created by shujdwin on 2016/12/07.
 */
public class StringUtil {

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * 驼峰转下划线,效率比上面高
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine(String)})
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * object转String
     * @param object
     * @return
     */
    public static String getString(Object object) {
        return getString(object, "");
    }

    public static String getString(Object object, String defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return object.toString();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Integer
     * @param object
     * @return
     */
    public static int getInt(Object object) {
        return getInt(object, -1);
    }

    public static int getInt(Object object, Integer defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Boolean
     * @param object
     * @return
     */
    public static boolean getBoolean(Object object) {
        return getBoolean(object, false);
    }

    public static boolean getBoolean(Object object, Boolean defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    /**
     * 生成8位UUID
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 判断数组中是否包含某个特定的值
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    /**
     　　* @Description: 日期格式是否正确
     　　* @param datestr
     * @param dateformat
    　　* @return boolean
    　　* @author pijinlin
    　　* @date 2018/6/28 18:28
    　　*/
    public static boolean isRightDateStr(String datestr,String dateformat){

        boolean flag = true;
        DateFormat dateFormat = new SimpleDateFormat(dateformat);
        try {
            Date date = (Date) dateFormat.parse(datestr);
        } catch (ParseException e) {
            flag = false;
        }

        return flag;
    }
    /**
     　　* @Description: 数据是否是数字
     　　* @param  str
     　　* @return
     　　* @author pijinlin
     　　* @date 2018/6/29 17:25
     　　*/
    public static boolean isNumber(String str){
        boolean flag;
        Pattern pattern = Pattern.compile("^(?:[1-9][0-9]*(?:\\.[0-9]+)?|0(?:\\.[0-9]+)?)$");
        flag = pattern.matcher(str).matches();

        return flag;
    }
    /**
     　　* @Description: 判断字符串是否是整数
     　　* @param
     　　* @return
     　　* @author pijinlin
     　　* @date 2018/9/17 14:08
     　　*/
    public static boolean isInteger(String str) {
        boolean flag = false;
        BigDecimal num = new BigDecimal(str);
        BigDecimal intNum = num.setScale(0,BigDecimal.ROUND_HALF_UP);
        if (0 == intNum.compareTo(num)){
            flag = true;
        }
        return flag;
    }
    /**
     　　* @Description: 字符串转化整数
     　　* @param
     　　* @return
     　　* @author pijinlin
     　　* @date 2018/9/17 14:08
     　　*/
    public static int getInteger(String str) {

        BigDecimal num = new BigDecimal(str);
        BigDecimal intNum = num.setScale(0,BigDecimal.ROUND_HALF_UP);
        int number = getInt(intNum);

        return number;
    }

   /**
　　* @Description: 去除数据中的换行空格符
　　* @param
　　* @return
　　* @author pijinlin
　　* @date 2018/9/17 14:08
　　*/
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String getUTF8StringFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            try {
                return new String(tmp,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        try {
            return new String(utfBytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
   /**
　　* @Description: String转Bigdecimal
　　* @param
　　* @return
　　* @author pijinlin
　　* @date 2018/10/23 9:13
　　*/
    public static BigDecimal switchToNum(String str){
        if (StringUtils.isBlank(str)){
            return null;
        }

        return new BigDecimal(str);
    }

    public static void main(String[]args) {
        System.out.println(Long.toHexString(9832433233L));
    }
}
