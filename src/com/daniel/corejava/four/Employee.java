package com.daniel.corejava.four;

import com.daniel.corejava.five.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 * 5.1 抽象类{@link Person}的子类,实现其所有的抽象方法,并且不再使用name域。
 *
 * @author daniel
 * @version 2021.07.19
 */
public class Employee extends Person implements Comparable<Employee>,Cloneable {
    //静态域初始化
//    private static int nextId = 1;
    /**
     * 域注释
     * 默认值为0初始化为1,假设此静态值特别复杂使用静态代码块进行初始化
     */
    private static int nextId;

    //静态代码块在程序初始化运行的时候就已经执行
    static {
        nextId = new Random().nextInt(10000);
    }

    private final int id;
    /**
     * 5.1 name已经提取到其超类,定位：{@link Person#getName()}
     */
    //    private String name;
    //显式域初始化
    private double salary = 10000.0;

    /**
     * {@link LocalDate}没有更改器方法,相反{@link java.util.Date}有一个更改器方法{@link java.util.Date#setTime(long)}可以破坏hireDay的私有性<br/>
     * <br/>
     * 5.1.10 入职日期修改为受保护状态<code>protected</code>  2021.07.20<br/>
     * 其子类如{@link com.daniel.corejava.five.Manager}、
     * {@link com.daniel.corejava.five.Executive}可以直接访问此域。<br/>
     * 谨慎使用,可以通过此类派生出新类，并访问其中的受保护域。
     * 在这种情况下，如果需要对这个类的实现进行修改，就必须通知所有使用这个类的人员。
     * 这违背了OOP提倡的数据封装原则。
     * 访问修饰符：<br/>
     * <code>private</code>   ----- 仅对本类可见<br/>
     * <code>public</code>    ----- 对所有类可见<br/>
     * <code>protected</code> ----- 对本包和所有子类可见<br/>
     * <code>default</code>   ----- 对本包可见
     */
    protected LocalDate hireDay;

    //普通代码块只有在构造对象时才会使用
    {
        this.id = nextId;
        nextId++;
    }

    /**
     * 没有创建构造器的方法时自动创建
     * 但是只要有其他构造器若想使用必须显式的编写
     */
    public Employee() {
    }

    /**
     * 只使用姓名的构造器
     *
     * @param name 姓名
     */
    public Employee(String name) {
        super(name);
    }

    /**
     * 构造器--重载构造器
     *
     * @param name   姓名
     * @param salary 工资
     * @param year   入职年
     * @param month  入职月
     * @param day    入职日
     */
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    /**
     * Employee、this为此方法的隐式参数（方法调用的目标或接收者）
     *
     * @param byPercent 显式参数
     */
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    /**
     * 重写{@link String#toString()}
     *
     * @return 对象重组字符串
     */
    @Override
    public String toString() {
        return getClass().getName() + "[id=" + id + ",name='" + super.getName() + ", salary=" + salary + ", hireDay=" + hireDay + "]";
    }

    /**
     * 典型的访问器方法
     * 被final修饰不允许被Manager和Executive重写 2021.07.20
     *
     * @return 职员姓名
     */
    public final String getName() {
        return super.getName();
    }

    /**
     * 薪资域更改器
     *
     * @param salary 薪资
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 薪资域访问器
     *
     * @return 薪资
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 重写{@link Person#getDescription()}
     *
     * @return 职员描述字符串
     */
    @Override
    public String getDescription() {
        return super.getName() + "是一个职工.";
    }

    /**
     * 5.2.1 重写equals方法
     *
     * @param otherObj {@link Employee}
     * @return {@link Boolean}
     */
    @Override
    public boolean equals(Object otherObj) {
        //快速检测对象是否相同
        if (this == otherObj) return true;
        //检测对象是否为空
        if (otherObj == null) return false;
        //检测是否是同一个类
        if (getClass() != otherObj.getClass()) return false;
        Employee otherEmployee = (Employee) otherObj;
        return super.getName().equals(otherEmployee.getName())
                && salary == otherEmployee.salary
                && Objects.equals(hireDay, otherEmployee.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, hireDay);
    }

    /**
     * 6.1 接口
     * @param other 需要比较的实体
     * @return 隐式参数小于显示参数将返回一个负值...
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }

    /**
     * 自定义比较方法
     * @param one 被比较参数
     * @param other 比较参数
     * @return 比较薪资之后的值
     */
    public static int compare(Employee one, Employee other) {
        return one.compareTo(other);
    }

    /**
     * 默认的浅克隆方法并没有克隆子对象,但是我们使用的LocalDate对象是不可改变的,所以无需使用深复制
     *
     * @return 克隆之后的对象
     */
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
