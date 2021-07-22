package com.daniel.corejava.five;

/**
 * 5.5 参数数量可变的方法<br/>
 *
 * @author daniel
 * @version 2021.07.22
 * @see java.io.PrintStream#printf(String, Object...)
 */
public class ParamsCanChangedDemo {

    public static void main(String[] args) {
        int aInt = 1;
        System.out.printf("%d\n", aInt);
        System.out.printf("%d %s\n", aInt, "daniel");
        System.out.println(max(0.1, 0.2, 1, 5, 35, 0, 1.5));
    }

    /**
     * 自动以参数数量可变的方法
     *
     * @param values 可变数量参数
     * @return 最大值
     */
    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;//0xfff0000000000000L
        for (double value : values) {
            if (value > largest) largest = value;
        }
        return largest;
    }
}
