package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;
import sun.security.util.Length;

import java.awt.*;

/**
 * 5.2 Object:所有类的超类<br/>
 * {@link Object}类是Java中所有类的始祖，在Java中每个类都由它扩展而来的。
 *
 * @author daniel
 * @version 2021.07.20
 */
public class ObjectDemo {

    public static void main(String[] args) {
        //可以使用Object类型的变量引用任何类型的对象
        Object obj = new Employee("daniel");
        //当然，Object类型的变量只能用于作为各种值的通用持有者，要想对其中的内容进行具体的操作，需要清除对象的原始类型，并进行相应的转换。
        Employee employee = (Employee) obj;
        equalsMethod();
        hashCodeMethod();
        toStringMethod();
    }

    /**
     * 5.2.1 equals方法<br/>
     * 用于检测一个对象是否等于另外一个对象。<br/>
     * Java语言规范要求equals方法具有以下特性：<br/>
     * 1.自反性<br/>
     * 2.对称性<br/>
     * 3.传递性<br/>
     * 4.一致性<br/>
     * 5.对于任意非空引用x,x.equals(null)应该返回false<br/>
     */
    private static void equalsMethod() {
        //相等继承存在下面两个问题：
        //1、如果子类能够拥有自己的相等概念，则对称性需求将强制采用getClass进行检测。
        //2、如果由超类决定相等的概念，那么就可以使用instanceof进行检测，这样可以在不同子类的对象之间进行相等的比较。

        //编写一个完美的equals方法的建议：
        //1.显示参数命名为otherObject,稍后需要将它转换成另一个叫做other的变量。
        //2.检测this与otherObject是否引用同一个对象。
        //3.检测otherObject是否为null,如果为null,返回false。
        //4.比较this与otherObject是否属于同一个类。
        //  如果equals的语义在每个子类中有所改变，就使用getClass检测。
        //  如果所有的子类都拥有统一的语义，就使用instanceof检测。(建议将方法使用final修饰)。
        //5.将otherObject转换为相应的类类型变量。
        //6.对所有需要比较的域进行比较。
        //  使用==比较基本类型域。
        //  使用equals比较对象域。
        //  如果在子类中重新定义equals,就要在其中包含super.equals(other)
        //提示：对于数组类型的域，可以使用静态的Arrays.equals方法检测相应的数组元素是否相等.

    }

    /**
     * 5.2.3 hashCode方法<br/>
     * <strong>散列码</strong>是由对象导出的一个整形值.<br/>
     */
    private static void hashCodeMethod() {
        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode()); //2524 2066940133
        String t = new String("OK");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());//2524 48612937
        //总结：
        //字符串的散列码是由内容导出的,因此s与t拥有相同的散列码.
        //而StringBuilder中没有定义hashCode方法,它是由Object类默认hashCode方法导出的对象存储地址。
        //注意：
        //如果重新定义equals方法,就必须重新定义hashCode方法,以便用户将对象插入到散列表中.
    }

    /**
     * 5.2.4 toString方法<br/>
     * 用于返回表示对象值得字符串.
     */
    private static void toStringMethod() {
        //java.awt.Point[x=10,y=20]
        //绝大多数的toString方法都遵循这样的格式：类的名字,随后是一对方括号括起来的域值
        System.out.println(new Point(10, 20));
        //com.daniel.corejava.four.Employee[id=1979,name='daniel, salary=14500.0, hireDay=2019-08-26]
        System.out.println(new Employee("daniel", 14500.0, 2019, 8, 26));
        //com.daniel.corejava.five.Manager[id=5263,name='daniel, salary=15225.0, hireDay=2019-08-26][bonus=5.0]
        Manager manager = new Manager("daniel", 14500.0, 2019, 8, 26);
        manager.setBonus(5);
        System.out.println(manager);
        //注意：数组继承了Object类的toString方法,生成字符串"[I@1a46e30",可以使用Arrays.toString代替.
        //使用Class.getSupperClass()可以以Class对象的形式返回这个类的超类信息:java.lang.Object
        System.out.println(manager.getClass().getSuperclass().getSuperclass().getSuperclass().getName());
    }
}
