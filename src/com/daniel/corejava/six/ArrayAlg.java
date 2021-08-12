package com.daniel.corejava.six;

import com.daniel.corejava.eight.PairTwo;
import com.daniel.corejava.four.Employee;

/**
 * 6.4.7 同时计算最大值和最小值
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/4
 */
public class ArrayAlg {

    /**
     * 没有引用其他任何对象,可以定义为静态内部类
     */
    public static class InnerPair {
        private double first;
        private double second;

        public InnerPair() {
        }

        public InnerPair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public void setFirst(double first) {
            this.first = first;
        }

        public double getSecond() {
            return second;
        }

        public void setSecond(double second) {
            this.second = second;
        }
    }

    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double value : values) {
            if (min > value)
                min = value;
            if (max < value)
                max = value;
        }
        return new Pair(min, max);
    }

    public static InnerPair innerMinmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double value : values) {
            if (min > value)
                min = value;
            if (max < value)
                max = value;
        }
        return new InnerPair(min, max);
    }

    /**
     * 带泛型的字符串数组比较器(比较大小)
     * @param a 字符串数组
     * @return 最大值和最小值
     */
    public static PairTwo<String> minmax(String[] a) {
        if (a == null || a.length == 0)
            return null;
        String min = a[0];
        String max = a[0];
        for (String s : a) {
            if (min.compareTo(s) > 0) {
                min = s;
            }
            if (max.compareTo(s) < 0) {
                max = s;
            }
        }
        return new PairTwo<>(min, max);
    }

    /**
     * 8.3 一个带有类型参数的简单方法
     * 1、这个方法是在普通类中定义的,而不是在泛型类中定义的,当然也是可以定义在泛型类中
     * 2、当调用一个泛型方法时,在方法名前的尖括号中放入具体的类型(当然在这种情况下可以省略泛型,编译器有足够的信息进行推断)
     *
     *
     *
     * @param a 参数
     * @param <T> 泛型
     * @return 中值
     */
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    /**
     * 8.4 类型变量的限定
     * @param a 参数
     * @param <T> 泛型类
     * @return 最小值
     */
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length ==0)
            return null;
        T smallest = a[0];
        for (T t : a) {
            //这一行代码存在问题,既然smallest是一个泛型变量T,这意味着它可以是任何一个类型队形
            //方案：将T限制为实现了Comparable接口的类或者继承：<T extends Comparable & Serializable>
            //目前我们忽略其复杂性以及编译器产生的警告
            if (smallest.compareTo(t) > 0)
                smallest = t;
        }
        return smallest;
    }

    /**
     * 任意实现Comparable接口的类对象的参数计算最大值最小值并放置到PairTwo返回
     * @param a 实现了Comparable接口的参数数组
     * @param <T> 泛型参数
     * @return 最大值和最小值并放置到PairTwo中返回
     */
    public static <T extends Comparable> PairTwo<T> minmax(T[] a) {
        if (a == null || a.length == 0)
            return null;
        T min = a[0];
        T max = a[0];
        for (T t : a) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return new PairTwo<>(min, max);
    }
}
