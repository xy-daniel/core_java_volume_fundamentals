package com.daniel.corejava.four;

import java.time.LocalDate;
import java.util.Random;
//导入静态类的特定方法或域
import static java.lang.System.out;

/**
 * 测试用employee类
 * 重载构造器
 * 用this调用另一个构造器
 * 无参数构造器
 * 对象初始化块
 * 静态初始化块
 * 实例域初始化
 * @date 2021.07.18
 * @author daniel
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee = new Employee();
        //init param = null
        System.out.println(employee.getName());
        //使用构造器初始化对象 1~4
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("ding", 100, 2021, 1, 1);
        staff[1] = new Employee("dai", 101, 2021, 1, 1);
        staff[2] = new Employee("guang", 102, 2021, 1, 1);
        for (Employee e:staff) {
            e.raiseSalary(5);
        }
        for (Employee e:staff) {
            out.println(e.toString());
        }
    }
}

class Employee {
//    private static int nextId = 1;
    /**
     * 域注释
     * 默认值为0初始化为1,假设此静态值特别复杂使用静态代码块进行初始化
     */
    private static int nextId;
    static {
        nextId = new Random().nextInt(10000);
    }

    private int id;
    private String name;
    //显式域初始化
    private double salary = 10000.0;
    //LocalDate没有更改器方法  相反Date有一个更改器方法setTime可以破坏hireDay的私有性
    private LocalDate hireDay;

    //普通代码块只有在构造对象时才会使用
    {
        this.id = nextId;
        nextId++;
    }

    /**
     * 构造器--重载构造器
     * @param name 姓名
     * @param salary 工资
     * @param year 入职年
     * @param month 入职月
     * @param day 入职日
     */
    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    /**
     * 没有创建构造器的方法时自动创建
     * 但是只要有其他构造器若想使用必须显式的编写
     */
    public Employee() {
    }

    /**
     * Employee、this为此方法的隐式参数（方法调用的目标或接收者）
     * @param byPercent 显式参数
     */
    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "id=" + id +",name='" + name + ", salary=" + salary + ", hireDay=" + hireDay;
    }

    /**
     * 典型的访问器方法
     * @return 职员姓名
     */
    public String getName() {
        return name;
    }
}
