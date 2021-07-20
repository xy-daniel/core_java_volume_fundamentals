package com.daniel.corejava.four;

//导入静态类的特定方法或域

import static java.lang.System.out;

/**
 * {@link Employee}测试类：<br/>
 * 重载构造器<br/>
 * 用this调用另一个构造器<br/>
 * 无参数构造器<br/>
 * 对象初始化块<br/>
 * 静态初始化块<br/>
 * 实例域初始化<br/>
 *
 * @author daniel
 * @date 2021.07.18
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
        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        for (Employee e : staff) {
            out.println(e.toString());
        }
    }
}
