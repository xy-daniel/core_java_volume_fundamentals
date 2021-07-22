package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

import javax.annotation.processing.SupportedOptions;
import java.util.ArrayList;

/**
 * 5.3.2 假设的没有类型参数的数据库遗留类
 *
 * @author daniel
 * @version 2021.07.21
 */
public class EmployeeDB {

    /**
     * 测试更新的方法
     *
     * @param list 测试数组列表
     */
    public void update(ArrayList list) {
        System.out.println(list);
    }

    /**
     * 测试查询方法
     *
     * @param query 测试查询条件
     * @return 根据查询条件生成的Employee对象数组列表
     * @see Employee
     */
    public ArrayList find(String query) {
        ArrayList objects = new ArrayList<>();
        objects.add(new Employee(query, 100, 2000, 10, 10));
        return objects;
    }
}
