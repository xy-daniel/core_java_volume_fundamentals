package com.daniel.corejava.five;

/**
 * 5.1.9 抽象类{@link Person}的子类,实现其所有的抽象方法
 *
 * @author daniel
 * @version 2021.07.20
 */
public class Student extends Person {

    /**
     * 无参构造方法
     */
    public Student() {
    }

    /**
     * 全参构造方法
     *
     * @param name 姓名
     */
    public Student(String name) {
        super(name);
    }

    /**
     * 重写{@link Person#getDescription()}方法
     *
     * @return 描述结果
     */
    @Override
    public String getDescription() {
        return super.getName() + "是一个学生.";
    }
}
