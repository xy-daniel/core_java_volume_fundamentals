package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

import java.util.Objects;

/**
 * 管理层子类Manager继承自超类{@link Employee}
 * 在子类中可以增加域、增加方法、或覆盖超类的犯法，然而绝对不能删除继承的任何域和犯法
 *
 * @author daniel
 * @version 2021.07.19
 */
public class Manager extends Employee {
    private double bonus;

    /**
     * 设置涨薪变化百分比
     *
     * @param bonus 百分比
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
        super.setSalary(super.getSalary() * (1 + bonus / 100));
    }

    /**
     * 加上奖金重写工资方法
     *
     * @return 最后工资
     */
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    /**
     * 无参构造方法
     */
    public Manager() {
    }

    /**
     * 只包含姓名的构造器
     * @param name 姓名
     */
    public Manager(String name) {
        super(name);
    }

    /**
     * 全参构造方法
     *
     * @param name   姓名
     * @param salary 薪资
     * @param year   入职年
     * @param month  入职月
     * @param day    入职日
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    /**
     * 5.2.1 重写equals方法
     *
     * @param otherObject {@link Manager}
     * @return {@link Boolean}
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        Manager managerObject = (Manager) otherObject;
        return bonus == managerObject.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
