package com.daniel.corejava.seven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * 第7章 异常、断言和日志
 * @author daniel
 * @version v1.0
 * @date 2021/8/6
 */
public class SevenDemo {

    public static void main(String[] args) {
        System.out.println("7.1 处理错误");
        System.out.println("需要关注的错误：");
        System.out.println("1、用户输入错误");
        System.out.println("2、设备错误");
        System.out.println("3、物理限制");
        System.out.println("4、代码错误");

        System.out.println("7.1.1 异常分类 extends Throwable");
        System.out.println("非受查异常：");
        System.out.println("Throwable -> Error");
        System.out.println("Throwable -> Exception");
        System.out.println("Exception -> RuntimeException");
        System.out.println("1、错误的类型转换");
        System.out.println("2、数组访问越界");
        System.out.println("3、访问null指针");
        System.out.println("4、......");
        System.out.println("Exception -> IOException");
        System.out.println("1、视图在文件尾部读取数据");
        System.out.println("2、视图打开一个不存在的文件");
        System.out.println("3、视图根据给定的字符串查找Class对象，而这个字符串表示的类并不存在");
        System.out.println("4、......");

        System.out.println("7.1.2 声明受查异常");
        System.out.println("throws ***Exception");
        System.out.println("需要声明异常的情况:");
        System.out.println("1、调用一个抛出受查异常的方法");
        System.out.println("2、程序运行过程中发现错误,并且利用throw语句抛出一个受查异常");
        System.out.println("3、程序出现错误");
        System.out.println("4、java虚拟机和运行时库出现的内部错误");
        System.out.println("总之,一个方法必须声明所有可能抛出的受查异常,而非受查异常要么不可控制要么就应该避免发生.");

        System.out.println("7.1.3 如何抛出异常");
        System.out.println("1、找到一个合适的异常类");
        System.out.println("2、创建这个类的一个对象");
        System.out.println("3、将对象抛出");

        System.out.println("7.1.4 创建异常类--参考MyException");

        System.out.println("7.2 捕获异常");
        System.out.println("7.2.1 捕获异常 7.2.2 捕获多个异常");
        try {
            double zeroResult = 1/0;
        }
        //处理多个异常
        catch (ArithmeticException e) {
            System.out.println("不能除以0");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName());
            e.printStackTrace();
        }
        System.out.println("同时处理多个异常");
        System.out.println("catch (IOException | Exception e) {");
        System.out.println("    System.out.println(e.getMessage());");
        System.out.println("    System.out.println(e.getClass().getName());");
        System.out.println("    e.printStackTrace();");
        System.out.println("}");
        System.out.println("7.2.3 再次抛出异常与异常链");
        System.out.println("在catch子句中可以抛出一个异常,目的是改变异常的类型.");
        System.out.println("catch (Exception e) {");
        System.out.println("    e.printStackTrace();");
        System.out.println("    throw new RuntimeException();");
        System.out.println("}");
        System.out.println("可以通过e.initCause()设置原始异常.");
        System.out.println("可以通过e.getCause()获取到原始异常.");

        System.out.println("7.2.4 finally子句");
        System.out.println("不管是否有异常被捕获,finally子句中的代码都被执行.");

        System.out.println("7.2.5 带资源的try catch语句");
        try (
                Scanner in = new Scanner(new FileInputStream("D:/test.txt"), "UTF-8");
                PrintWriter out = new PrintWriter("out.txt")
        ){
            while (in.hasNext())
                out.println(in.next().toUpperCase(Locale.ROOT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("无论这个代码块如何结束,in-out都会被关闭.");

        System.out.println("7.2.6 分析堆栈轨迹元素");
        System.out.println("通过e.printStackTrace()打印堆栈轨迹.");
        System.out.println("可以使用e.getStackTrace()得到StackTraceElement对象的一个数组,并对这个对象数组进行分析.");
        Throwable t = new Throwable();
        StackTraceElement[] traceElements = t.getStackTrace();
        for (StackTraceElement traceElement : traceElements) {
            //获取文件名
            System.out.println(traceElement.getFileName());;
            //获取代码行号
            System.out.println(traceElement.getLineNumber());;
            //获取类名
            System.out.println(traceElement.getClassName());
            //获取方法名
            System.out.println(traceElement.getMethodName());
            //是否是本地方法
            System.out.println(traceElement.isNativeMethod());
            //格式化字符串,包含所有可以获得的信息
            System.out.println(traceElement.toString());;
        }
        System.out.println("静态的Thread.getAllStackTrace()可以产生所有线程的堆栈轨迹.");
//        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
//        for (Thread thread:map.keySet()) {
//            StackTraceElement[] stackTraceElements = map.get(thread);
//            //使用上述代码(for)
//        }
        testStackTrace(3);

        System.out.println("7.3 使用异常机制的技巧");
        System.out.println("1、异常处理不能代替简单的测试");
        System.out.println("2、不要过分的细化异常");
        System.out.println("3、合理利用异常层次结构");
        System.out.println("4、不要压制异常");
        System.out.println("5、在检测错误时,苛刻要比放任更好");
        System.out.println("6、不要羞于传递异常");

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public static int testStackTrace(int n) {
        Throwable throwable = new Throwable();
        StackTraceElement[] frames = throwable.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1)
            r = 1;
        else
            r = n * testStackTrace(n - 1);
        System.out.println("return " + r);
        return r;
    }

}
