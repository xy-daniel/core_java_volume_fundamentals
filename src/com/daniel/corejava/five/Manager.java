package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

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
}
