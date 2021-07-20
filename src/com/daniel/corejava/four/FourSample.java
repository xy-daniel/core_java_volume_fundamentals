package com.daniel.corejava.four;

import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//静态导入
import static java.lang.System.*;

/**
 * This is the first sample program in Core Java Chapter 4 (object and class)<br/>
 * 面向对象程序设计、如何创建标准Java类库中的类对象<br/>
 * 如何编写自己的类<br/>
 * 如何创建转准Java类库中的类和对象<br/>
 * 如何编写自己的类<br/>
 *
 * @author daniel
 * @version 1.0 20210712
 */
public class FourSample {

    public static void main(String[] args) {
        String four1 = four1("a");
        out.println(four1);
        four2();
    }

    /**
     * 面向对象程序设计(OOP)概述
     *
     * @param param 参数
     * @return 返回一个字符串
     * @throws RuntimeException 可能产生的异常
     * @see com.daniel.corejava.four.FourSample#four2()
     * @since 20210719
     * @deprecated this class deprecated, please use <code>four2()</code> instead
     */
    public static String four1(String param) throws RuntimeException {
        // 对象的三个主要特征：对象的行为、对象的状态、对象的标识
        // 类中间最常见的关系：依赖“uses-a”、聚合"has-a"、继承"is-a"
        // private修饰的域只能被定义他们的类使用
        // 没有指定public或private的类、方法、变量可以被同一个包的所有方法访问
        // Window类中的warningString域没有被任何修饰符修饰 因此可以被awt包中的所有方法访问并修改，
        // 但是实际上只有Window这一个类使用这个域

        //注意：
        //1、一定要保证数据私有
        //2、一定要对数据初始化
        //3、不要在类中使用过多的基本类型  street,city,state,zip -> Address
        //4、不是所有的域都需要独立的域访问器和域更改器 hireDay只需要提供域访问器
        //5、将职责过多的类进行分解 明显可分解
        //6、类名和方法名要能够体现它们的职责 getName setName
        //7、有限使用不可变的类 Date - LocalDate
        return "";
    }

    /**
     * 使用预定义类
     */
    public static void four2() {
        Date date = new Date();
        out.println(date);
        //Objects must be created by using constructors. For example, `Date deadline` cannot be used
        //it can be as follows:
        Date deadline = new Date();
        out.println(deadline);
        //so date and deadline object will use*(一定要注意是引用) a object
        deadline = date;
        out.println(deadline);

        //构造一个给定日期的对象
        LocalDate localDate = LocalDate.of(1999, 1, 1);
        //得到当前日期的年月日
        out.println(localDate.getYear());
        out.println(localDate.getMonthValue());
        out.println(localDate.getDayOfMonth());
        //并未改变原来的对象 而是生成一个新的对象
        LocalDate plusDays = localDate.plusDays(1000);
        out.println(plusDays.getYear());
        out.println(plusDays.getMonthValue());
        out.println(plusDays.getDayOfMonth());
        out.println(plusDays.getDayOfWeek().getValue());
        LocalDate minusDays = localDate.minusDays(500);
        out.println(minusDays.getYear());
        out.println(minusDays.getMonthValue());
        out.println(minusDays.getDayOfMonth());
        out.println(minusDays.getDayOfWeek().getValue());

        GregorianCalendar gregorianCalendar = new GregorianCalendar(1999, Calendar.DECEMBER, 31);
        //更改器方法
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1000);
        //访问器方法
        out.println(gregorianCalendar.get(Calendar.YEAR));
        out.println(gregorianCalendar.get(Calendar.MONTH) + 1);
        out.println(gregorianCalendar.get(Calendar.DAY_OF_MONTH));

        //构造一个表示当前日期的对象
        LocalDate now = LocalDate.now();
    }


}
