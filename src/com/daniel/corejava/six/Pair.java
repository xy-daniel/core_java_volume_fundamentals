package com.daniel.corejava.six;

/**
 * 6.4.7 用于存储最大值和最小值
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/4
 */
public class Pair {
    private double first;
    private double second;

    public Pair() {
    }

    public Pair(double first, double second) {
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
