package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

import java.util.ArrayList;

/**
 * 5.3 泛型数组列表<br/>
 *
 * @author daniel
 * @version 2021.07.21
 */
public class GenericDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //直接创建数组,数组的全部空间有可能被用尽.
        int actualSize = 10;
        Employee[] staff = new Employee[actualSize];
        //Java允许在运行时确定数组的大小
        //使用ArrayList添加删除元素,并具有自动调节数组容量的功能.它是一个采用类型参数的泛型类。
        //为了指定数组列表保存时的元素对象类型，需要如下使用：
//        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        //Java SE7之后可以省略后面的泛型指示,称之为菱形语法,如下：
        ArrayList<Employee> employeeArrayList = new ArrayList<>(100);
        employeeArrayList.add(new Employee("daniel", 14500, 2019, 8, 26));
        employeeArrayList.add(new Employee("daniel", 14500, 2019, 8, 26));
        employeeArrayList.add(new Employee("daniel", 14500, 2019, 8, 26));
        //返回当前数组列表当前元素数量
        System.out.println(employeeArrayList.size());
        //确保数组在不重新分配存储空间的情况下就能够保存给定数量的元素
        employeeArrayList.ensureCapacity(300);
        //将数组列表削减到当前尺寸
        employeeArrayList.trimToSize();

        //访问并替换数组列表中已存在的元素
        System.out.println(employeeArrayList.size());//[com.daniel.corejava.four.Employee[id=7487,name='daniel, salary=14500.0, hireDay=2019-08-26], com.daniel.corejava.four.Employee[id=7488,name='daniel, salary=14500.0, hireDay=2019-08-26], com.daniel.corejava.four.Employee[id=7489,name='daniel, salary=14500.0, hireDay=2019-08-26]]
        employeeArrayList.set(0, new Employee("daniel", 14500, 2019, 8, 26));
        System.out.println(employeeArrayList.size());//[com.daniel.corejava.four.Employee[id=7490,name='daniel, salary=14500.0, hireDay=2019-08-26], com.daniel.corejava.four.Employee[id=7488,name='daniel, salary=14500.0, hireDay=2019-08-26], com.daniel.corejava.four.Employee[id=7489,name='daniel, salary=14500.0, hireDay=2019-08-26]]
        //获取列表中已存在的元素
        System.out.println(employeeArrayList.get(0));
        //从数组中间插入一个元素
        int n = employeeArrayList.size() / 2;//1
        employeeArrayList.add(n, new Employee("daniel", 14500, 2019, 8, 26));
        System.out.println(employeeArrayList.size());//4
        //从数组中间移除一个元素
        employeeArrayList.remove(n);
        System.out.println(employeeArrayList.size());//3
        //注：对数组实施插入和删除元素的操作其效率比较低,如果数组存储的存储的元素数比较多，有需要经常在中间位置插入、删除元素，
        //就应该考虑使用链表了.
        for (Employee employee : employeeArrayList) {
            System.out.println(employee);
        }

        //5.3.2 类型化与原始数组列表的兼容性
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.update(employeeArrayList);
        ArrayList<Employee> arrayList = employeeDB.find("tom");//Unchecked assignment: 'java.util.ArrayList' to 'java.util.ArrayList<com.daniel.corejava.four.Employee>'
        arrayList = (ArrayList<Employee>) employeeDB.find("tom");//Unchecked cast: 'java.util.ArrayList' to 'java.util.ArrayList<com.daniel.corejava.four.Employee>'
        System.out.println(arrayList);
    }
}
