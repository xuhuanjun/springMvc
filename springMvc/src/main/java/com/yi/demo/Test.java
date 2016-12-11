package com.yi.demo;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间关系，本程序未经过太多测试，可能有bug，或者根本性的错误。
 * 而且只做了一组国家，但不限国家数.
 * <p>
 * Created by point on 2016/12/9.
 */
public class Test {
    /**
     * 缓存炸弹数.
     */
    private static Map<Country, Integer> countMap = new ConcurrentHashMap<Country, Integer>();

    public static void main(String[] args) throws IOException {
        /**
         * 读取国家列表文件，本程序只实现一组国家列表，不限国家个数.
         * 文件内容格式如下:
         * 1,10
         * 4,8
         * 3,7
         * 6,9
         *
         */
        final List<String> countryList = Files.readLines(new File("c:/test/country.txt"), Charset.defaultCharset());
        long startMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        for (String countryStr : countryList) {
            final Country country = new Country();
            final String[] countryXY = countryStr.split(",");
            country.setX(new Integer(countryXY[0]).intValue());
            country.setY(new Integer(countryXY[1]).intValue());
            recordBombCount(country);
        }
        //计算总炸单数
        System.out.println(countTotalBomb());
        long endMili = System.currentTimeMillis();//结束时间
        System.out.println("总耗时为：" + (endMili - startMili) + "毫秒");

    }

    /**
     * 记录需要的炸弹数.<br>
     * <li>每个交集取交集部分，作为key.</li>
     * <li>不存在交集直接记录，作为key.</li>
     *
     * @param country 国家实体.
     */
    private static void recordBombCount(final Country country) {
        if (countMap.isEmpty()) {
            countMap.put(country, 1);//初始一個国家
            return;
        }
        boolean existInterSection = false;//是否有与此国家相交的国家，默认无.
        for (Map.Entry<Country, Integer> entry : countMap.entrySet()) {
            final Country recordCountry = entry.getKey();
            final Integer recordBombCount = entry.getValue();
            //如果新的国家范围与已经登记的国家有交集则炸弹数不变且取交集部分领土，作为新的记录的key.
            if ((recordCountry.getX() <= country.getX() && country.getX() <= recordCountry.getY()) || (recordCountry.getX() <= country.getY() && country.getY() <= recordCountry.getY())) {
                final Country newCountry = new Country();
                newCountry.setX(recordCountry.getX() <= country.getX() ? country.getX() : recordCountry.getX());//x取大.
                newCountry.setY(recordCountry.getY() <= country.getY() ? recordCountry.getY() : country.getY());//y取小.
                countMap.remove(recordCountry);
                countMap.put(newCountry, recordBombCount);
                existInterSection = true;
            }
        }
        if (!existInterSection) {
            countMap.put(country, 1);//不存在交集，直接记录.
        }
    }

    /**
     * 汇总记录总的炸弹数.
     *
     * @return 总需炸弹数.
     */
    private static int countTotalBomb() {
        int totalBombCount = 0;//总共需要的炸弹数.
        for (Integer bombCount : countMap.values()) {
            totalBombCount += bombCount.intValue();
        }
        return totalBombCount;
    }


    /**
     * 国家,坐标[x,y].
     */
    public static class Country {
        /**
         * x坐标.
         */
        private int x;
        /**
         * y坐标.
         */
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
