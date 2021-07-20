package com.daniel.corejava.five;

/**
 * 5.1.9 抽象类<br/>
 * 在Java程序设计语言中，抽象方法是一个重要的概念。<br/>
 * 包含一个或多个抽象方法的类本身必须被声明为抽象的。<br/>
 * 抽了抽象方法之外，抽象类还可以包含具体数据和具体方法。<br/>
 * 类即使不含抽象方法，也可以将类声明为抽象类。<br/>
 * 抽象类不能被实例化。但是可以创建一个具体子类对象。参考{@link FiveDemo}-5.1.9<br/>
 * <strong>拓展抽象类</strong>可以有两种选择：<br/>
 * 一种是抽象类中定义部分抽象类方法或不定义抽象类方法,这样就必须将子类也标记为抽象类。<br/>
 * 另一种是定义全部的抽象方法，这样一来子类就不是抽象的了。<br/>
 *
 * @author daniel
 * @version 2021.07.20
 */
public abstract class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 无参构造方法
     */
    public Person() {
    }

    /**
     * 全参构造方法
     *
     * @param name 姓名
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * 姓名访问器方法
     *
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名更改器犯法
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 5.1.9 抽象方法
     * 抽象方法充当着占位的角色，他们的具体实现在子类中。
     *
     * @return 描述
     */
    public abstract String getDescription();
}
