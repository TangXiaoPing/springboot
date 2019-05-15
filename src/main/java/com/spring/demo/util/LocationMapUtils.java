package com.spring.demo.util;

import java.math.BigDecimal;

/**
 * 地图和距离相关的工具类
 * 参考 https://blog.csdn.net/sanyuesan0000/article/details/51683464
 */
public class LocationMapUtils {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离
     * @param lat1 第一个点的纬度，例如29.490295
     * @param lng1 第一个点的经度，例如106.486654
     * @param lat2 第二个点的纬度
     * @param lng2 第二个点的经度
     * @return /km 千米
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        BigDecimal result = new BigDecimal(s);
        double f1 = result.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

}
