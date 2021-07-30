package com.daniel.corejava.five;

/**
 * 5.8 继承的设计与技巧
 *
 * @author daniel
 * @version 2021.07.30
 */
public class ExtendsDemo {

    public static void main(String[] args) {
        System.out.println("建议：");
        System.out.println("1.将公共操作和域放在超类");
        System.out.println("2.不要使用受保护的域");
        System.out.println("原因：第一，子类集合是无限制的，任何一个人都能够由某个类派生一个子类，并编写代码以直接访问protected的实例域，从而破坏了封装性.第二，在Java程序设计语言中，在同一个包中的所有类都可以访问protected域，而不管它是否为这个类的子类.");
        System.out.println("3.使用继承实现\"is-a\"关系");
        System.out.println("4.除非所有继承的方法都有意义，否则不要使用继承");
        System.out.println("5.在覆盖方法时不要改变预期的行为");
        System.out.println("6.使用多态而非类型信息");
        System.out.println("7.不要过多的使用反射");
    }
}
