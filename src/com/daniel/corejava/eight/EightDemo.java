package com.daniel.corejava.eight;

import com.daniel.corejava.four.Employee;
import com.daniel.corejava.six.ArrayAlg;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 第8章 泛型程序设计
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/7
 */
public class EightDemo {

    public static void main(String[] args) {
        //8.5 泛型代码和虚拟机
        //注：虚拟机没有泛型类型对象----所有对象都属于普通类

        //8.5.1 类型擦除
        //无论何时定义一个泛型类型,都自动提供了一个原始类型.
        //原始类型的名字就是删去类型参数后泛型类型号
        //擦除类型变量,并替换为原始类型,如PairTwo的原始类型为T更换为Object.
        //如果有限定,原始类型用第一个限定的类型变量来替换.

        //8.5.2 翻译泛型表达式
        //当程序调用泛型方法时,如果擦除返回类型,编译器插入强制类型转换.
        //如下：
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("daniel",100,2000,10,11);
        employees[1] = new Employee("tom",101,2000,10,11);
        employees[2] = new Employee("jack",102,2000,10,11);
        PairTwo<Employee> buddies = ArrayAlg.minmax(employees);
        Employee first = (Employee) buddies.getFirst();
        System.out.println(first);
        //已经擦除getFirst()的返回类型,将返回Object类型.
        //也就是说泛型表达式获取值经过了两个步骤：
        //1、方法调用
        //2、强制类型转换

        //8.5.3 翻译泛型方法
        //类型擦除也会出现在泛型方法中,通常认为如下一个泛型方法：
        //public static <T extends Comparable> T min(T[] a)
        //是一个完整的方法族,类型擦除以后就是一个方法,如下:
        //public static Comparable min(Comparable[] a)
        //类型擦除带来的问题(参照DataInterval)：
        DataInterval interval = new DataInterval();
        PairTwo<LocalDate> pair = interval;
        pair.setSecond(LocalDate.now());
        System.out.println(pair.getSecond());
        //通过跟踪上述语句的执行,了解桥方法的工作过程:
        //1、变量pair已经声明为类型PairTwo<LocalDate>,并且这个类型只有一个简单的方法叫setSecond,即setSecond(Object)
        //2、虚拟机用pair引用的对象调用这个方法.
        //3、这个对象是DataInterval类型的,因此会调用DateInterval.setSecond(Object)方法(这个方法就是桥方法)
        //4、而这个桥方法调用DataInterval.setSecond(LocalDate),当然桥方法可能变得十分奇怪
    }

}
