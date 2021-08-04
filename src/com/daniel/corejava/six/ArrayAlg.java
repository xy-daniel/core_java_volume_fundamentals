package com.daniel.corejava.six;

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

}
