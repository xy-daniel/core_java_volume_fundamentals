package com.daniel.corejava.three;

/**
 * 5.6 枚举类<br/>
 * 如果需要的话可以在枚举类型中添加一些构造器、方法和域。<br/>
 * 当然，构造器只是在构造枚举常量的时候被调用.
 *
 * @author daniel
 * @version 2021.07.22
 * @since 2021.06.15
 */
public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    /**
     * 允许存在的域
     */
    private String abbreviation;

    /**
     * 允许存在的无参构造器
     */
    Size() {
    }

    /**
     * 允许存在的全参构造器
     *
     * @param abbreviation 域值
     */
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * 允许存在的访问器方法
     *
     * @return 域值
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 允许存在的更改器方法
     *
     * @param abbreviation 域值
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
