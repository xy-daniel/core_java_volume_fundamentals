package com.daniel.corejava.eight;

/**
 * 8.2 定义简单泛型类<br/>
 * 泛型类：具有一个或多个类型变量的类<br/>
 * 注：在Java库中,使用E表示集合的元素类型,K和V分别表示表的关键字与值得类型,T表示任意类型<br/>
 * 可以这么说 泛型类可以看作普通类的工厂
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/7
 */
public class PairTwo<T> implements Cloneable {
    private T first;
    private T second;

    public PairTwo() {
        this.first = null;
        this.second = null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public PairTwo(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
