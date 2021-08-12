package com.daniel.corejava.eight;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/**
 * 8.5.3 泛型擦除后 extends PairTwo<LocalDate><br/>
 * 带来的问题:
 * 1、
 * 2、
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/9
 */
public class DataInterval extends PairTwo {

    @Override
    public Object getFirst() {
        return super.getFirst();
    }

    /**
     * 泛型擦除前的
     * @param second 参数
     */
//    public void setSecond(LocalDate second) {
//        if (second.compareTo((ChronoLocalDate) getFirst()) >= 0) {
//            super.setSecond(second);
//        }
//    }

    /**
     * 泛型擦除后
     *
     * @param second 参数
     */
    public void setSecond(LocalDate second) {
        System.out.println("-----");
        System.out.println(getFirst());
        System.out.println(second.compareTo((LocalDate) getFirst()));
        System.out.println("-----");
        if (second.compareTo((LocalDate) getFirst()) >= 0) {
            super.setSecond(second);
        }
    }

    /**
     * 但是令人疑惑的是存在另一个从Pair继承的setSecond方法<br/>
     * 参数类型变成了{@link Object},这显然与之前是不同的方法,也不应该不一样.<br/>
     * 参考Demo51.52:<br/>
     * 我们希望setSecond的调用具有多态性,并调用最合适的那个方法<br/>
     * 由于PairTwo<LocalDate>对象引用{@link DataInterval}对象,所以应该调用此方法<br/>
     * 但是,由于现在已经进行了类型擦除与多态发生了冲突
     * 因此要解决这个问题,就需要编译器在${@link DataInterval}类中生成一个桥方法
     * @param second
     */
    @Override
    public void setSecond(Object second) {
        setSecond((LocalDate) second);
    }

    /**
     * 类型擦除钱的get方法
     * @return {@link LocalDate}
     */
    public LocalDate getSecond() {
        return (LocalDate) super.getSecond();
    }

    /**
     * 类型擦除后的get方法<br/>
     * 不允许同时存在两个get方法,因为这不属于重载<br/>
     * 但是,在虚拟机中使用参数类型和返回类型确定一个方法<br/>
     * 因此编译器可能产生两个金返回类型不同的方法字节码，虚拟机能够给正确的处理这一情况<br/>
     *
     * @return {@link Object}
     */
//    public Object getSecond() {
//        return super.getSecond();
//    }

    //...其他方法
}
