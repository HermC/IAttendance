package edu.nju.ise.utils;

import java.text.DecimalFormat;

/**
 * 处理复杂数字操作
 *
 * @author Hermit
 * @version 1.0 2018/02/14
 * */
public class NumUtils {

    /**
     * 处理保留小数问题
     *
     * @param num 小数位数
     *
     * @return 标准化小数位数字符串
     * */
    public static String toFix(double num) {
        if(num == 0){
            return "0.00";
        }
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(num);
    }

}
