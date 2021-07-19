package com.daniel.four;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This is the first sample program in Core Java Chapter 4 (object and class)
 * 面向对象程序设计、如何创建标准Java类库中的类对象
 * 如何编写自己的类
 * 如何创建转准Java类库中的类和对象
 * 如何编写自己的类
 *
 * @author daniel
 * @version 1.0 20210712
 */
public class FourSample {

    public static void main(String[] args) {
        four1();
    }

    /**
     * 面向对象程序设计(OOP)概述
     */
    public static void four1() {
        //对象的三个主要特征：对象的行为、对象的状态、对象的标识
        //类中间最常见的关系：依赖“uses-a”、聚合"has-a"、继承"is-a"
    }

    /**
     * 使用预定义类
     */
    public static void four2() {
        Date date = new Date();
        System.out.println(date);
        //Objects must be created by using constructors. For example, `Date deadline` cannot be used
        //it can be as follows:
        Date deadline = new Date();
        System.out.println(deadline);
        //so date and deadline object will use*(一定要注意是引用) a object
        deadline = date;
        System.out.println(deadline);

        //构造一个给定日期的对象
        LocalDate localDate = LocalDate.of(1999, 1, 1);
        //得到当前日期的年月日
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        //并未改变原来的对象 而是生成一个新的对象
        LocalDate plusDays = localDate.plusDays(1000);
        System.out.println(plusDays.getYear());
        System.out.println(plusDays.getMonthValue());
        System.out.println(plusDays.getDayOfMonth());
        System.out.println(plusDays.getDayOfWeek().getValue());
        LocalDate minusDays = localDate.minusDays(500);
        System.out.println(minusDays.getYear());
        System.out.println(minusDays.getMonthValue());
        System.out.println(minusDays.getDayOfMonth());
        System.out.println(minusDays.getDayOfWeek().getValue());

        GregorianCalendar gregorianCalendar = new GregorianCalendar(1999, Calendar.DECEMBER, 31);
        //更改器方法
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1000);
        //访问器方法
        System.out.println(gregorianCalendar.get(Calendar.YEAR));
        System.out.println(gregorianCalendar.get(Calendar.MONTH) + 1);
        System.out.println(gregorianCalendar.get(Calendar.DAY_OF_MONTH));

        //构造一个表示当前日期的对象
        LocalDate now = LocalDate.now();
    }
}
