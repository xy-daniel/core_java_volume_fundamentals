package com.daniel.corejava.six;

import com.daniel.corejava.four.Employee;

import javax.swing.*;
import java.util.ArrayList;

/**
 * 6.4 内部类
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/3
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        //6.4.1 使用内部类访问对象状态
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();
        //显示一个包含一条消息和OK按钮的对话框。
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

        //6.4.2 内部类的特殊语法规则
        //1.使用外围类引用：OuterClass.this
        //2.更加明确的编写内部对象的构造器：outerObject.new InnerClass(构造参数)
        //3.在外围作用域之外引用内部类：OuterClass.InnerClass
        //注：内部类中声明的所有静态域都必须是final,内部类不能有静态方法

        //6.4.3 内部类是否有用、必要、安全

        //6.4.4 局部内部类 -- 参考TalkingClock

        //6.4.5 由外部方法访问变量
        //另一个优点：他们不仅能够访问包含他们的外部类，还可以访问局部变量，不过那些变量事实上必须为final
        clock.startHaveParams(1000, true);
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

        //6.4.6 匿名内部类
        //场景：只创建这个类的一个对象
        clock.startMethod(1000, true);
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);
        Employee employee = new Employee("daniel", 100, 2000, 10, 10){
            @Override
            public double getSalary() {
                return 10000;
            }
        };
        System.out.println(employee.getSalary());
        //双括号初始化：适用于只用一次
        ArrayList<String> strings = new ArrayList<String>() {
            //对象构造块
            {
                add("daniel");
            }
            //对象构造块
            {
                add("tom");
            }
        };
        System.out.println(strings);
        //静态方法没有this，因此this.getClass()没有作用,必须使用new Object(){}.getCLass().getEnclosingClass()

        //6.4.7 静态内部类
        //场景：有时候，使用内部类是为了把一个类隐藏在另外一个类的内部，并不需要内部类应用外围类对象.
        Pair minmax = ArrayAlg.minmax(new double[]{1.0, 2.0, 3.3, 0.5});
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
        //转换为静态内部类进行测试
        ArrayAlg.InnerPair innerMinmax = ArrayAlg.innerMinmax(new double[]{1.0, 2.0, 3.3, 0.5});
        System.out.println("innerMin = " + innerMinmax.getFirst());
        System.out.println("innerMax = " + innerMinmax.getSecond());
        //可以这么说,静态内部类出了没有外围类的对象之外和其他内部类可以说是一样的
        //并且在静态方法中构造静态内部类的对象这个内部类也必须是静态的内部类
        //注：：1、在内部类不需要引用外围类对象的时候应该使用静态内部类，或者使用嵌套类表示静态内部类
        //     2、与常规内部类不同，静态内部类可以有静态域和方法
        //     3、声明在接口中的内部类自动成为static和public类
    }
}
