package com.daniel.corejava.seven;

/**
 * 7.4 使用断言
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/6
 */
@SuppressWarnings("ConstantConditions")
public class AssertDemo {

    public static void main(String[] args) {
        //7.4.1 断言的概念
        //断言的概念：假设确信某个属性符合要求,并且代码执行依赖于这个属性.
        double params = 10.0;
        double sqrt = Math.sqrt(params);
        //如上：我们确信这里的参数是一个非负数值,但是还是希望进行检查
        //当然你可以使用异常来进行检查,如下：
        if(params < 0)
            throw new IllegalArgumentException("参数不合法");
        //但是这些代码将永久的保存在安装包中
        //而断言允许在测试期间向代码中插入一些检查语句,当代码发布时,这些插入的检测语句会被自动移除.
        //形式：assert 条件; assert 条件:表达式
        //两种形式都会在检查出非法值抛出AssertionException异常,第二种的表达式将会传入AssertionError的构造器,并转换成一个消息字符串
        //注：表达式的唯一目的就是产生一个消息字符串.

        //而对于上面的参数我们仅仅需要如下代码来断言params是一个非负数值:
        assert params >= 0;
        //或者传入表达式
        assert params >= 0 : params;
        sqrt = Math.sqrt(params);

        //7.4.2 启用和禁用断言
        //在默认情况下,断言被禁用,可以在运行程序时用-enableassertions或-ea选项启用
        //java -ea MyApp
        //在启用或禁用断言时不必重新编译程序,因为启用或禁用断言时类加载器的功能.
        //当断言被禁用时,类加载器将跳过断言代码.
        //也可以在某个类或整个包中使用断言,如下:
        //java -ea:MyClass -ea:com.myPackage MyApp
        //有些类不是由类加载器加载,而是由虚拟机加载,可以使用上述语句有选择的启用或禁用那些类中的断言
        //在程序中也可以控制类加载器的断言状态,如下:
        ClassLoader classLoader = AssertDemo.class.getClassLoader();
        //为所有通过类加载器加载的类设置是否启用断言
        classLoader.setDefaultAssertionStatus(true);
        //为指定类设置是否启用断言
        classLoader.setClassAssertionStatus("AssertDemo", true);
        //为指定的包及其子包设置是否启用断言
        classLoader.setPackageAssertionStatus("com.daniel.corejava.seven", true);
        //移除所有类和包设置的断言状态
        classLoader.clearAssertionStatus();

        //7.4.3 使用断言完成参数检查
        //java处理系统错误的机制：
        //1.抛出一个异常
        //2.日志
        //3.使用断言
        //何时使用断言：
        //1.断言失败是致命的,不可恢复的错误.
        //2.断言检测只用于开发和测试阶段

        //可以这么认为只有当一个参数或者值我们确认一个判断的时候才能使用断言
        //比如确信一个值一定不能是null我们可以使用断言
        //计算机科学家将这种约定称之为前置条件

        //7.4.4 为文档假设使用断言
        //很多程序员使用注释说明假设条件,如下：
        if(params % 3 == 0) {
            System.out.println("0");
        } else if(params % 3 == 1) {
            System.out.println("1");
        } else { //params % 3 == 2
            System.out.println("2");
        }
        //这儿我们就可以使用断言
        assert params >= 0;
        if(params % 3 == 0) {
            System.out.println("0");
        } else if(params % 3 == 1) {
            System.out.println("1");
        } else {
            assert params % 3 == 2;
            System.out.println("2");
        }

    }
}
