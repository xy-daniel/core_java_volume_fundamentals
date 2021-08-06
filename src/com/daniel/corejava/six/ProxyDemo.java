package com.daniel.corejava.six;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 6.5 代理
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/4
 * @see java.lang.reflect.InvocationHandler#invoke(Object, Method, Object[])
 * @see java.lang.reflect.Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
 */
public class ProxyDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        //利用代理可以在运行时创建一个实现了一组给定接口的新类
        //这种功能只有在编译时无法确定需要实现哪个接口时才有必要使用

        //6.5.1 何时使用代理
        //代理类可以在运行时创建爱你全新的类.这样的代理类能够实现指定的接口。尤其是，它具有一下方法：
        //1.指定接口锁需要的全部方法
        //2.Object类中的全部方法
        //然而不能再运行时定义这些方法的新代码,而是需要提供一个调用处理器：实现InvocationHandler接口的,这个接口只有一个方法invoke
        //无论何时调用代理对象的方法,调用处理器的invoke方法都会被调用，并向其传递Method对象和原始的调用参数

        //6.5.2 创建代理对象
        //方式：使用Proxy类的newProxyInstance
        //参数：
        //1.一个类加载器
        //2.一个Class对象数组
        //3.一个调用处理器
        //如何定义一个处理器？能够用结果代理对象做些什么？能够解决什么问题？
        //1.路由对远程服务器的方法调用
        //2.在程序运行期间，将用户接口事件与动作关联起来
        //3.为调试,跟踪方法调用
        Object[] elements = new Object[100];

        for (int i = 0; i < elements.length; i++) {
            //自动装箱为Integer
            Integer value = i;
            //获取调用处理器
            InvocationHandler handler = new TraceHandler(value);
            //创建代理对象：(类加载器, 对象必须实现的接口, 调用处理器)
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            //将原来的对象更新为代理对象
            elements[i] = proxy;
        }

        //创建一个随机数
        int key = new Random().nextInt(elements.length) + 1;
        System.out.println("key = " + key);

        //根据key查找这个值
        //binarySearch：二分搜索法，所以查询之前需要用sort()方法将数组排序，如果数组没有排序则结果是不确定的，；另外如果
        //数组中含有多个指定值得元素，则无法保证找到的是哪一个
        //方法注释：如果key在数组中返回搜索值得索引，否则返回-1或插入点

        //使用代理对象进行输出、比较等方法时都会调用处理器先进行处理
        int result = Arrays.binarySearch(elements, key);
        System.out.println("result = " + result);

        //打印这个值
        if (result > 0) {
            System.out.println(elements[result]);
        }
        // 6.5.3 代理类的特性
        //1.代理类是在运行过程中创建的
        //2.所有的代理类都扩展域Proxy类,一个代理类只有一个实例域--调用处理器。
        //3.所有的代理类都覆盖了Object类中的方法toString、equals、hashCode.
        //4.没有定义代理类的名字
        //5.对于特定的类加载器和预设的一组接口来说，只能有一个代理类.也就是说如果使用同一个类加载器和接口数组调用两次newProxyInstance
        //方法的话讲得到同一个类的两个对象,也可以是用getProxyClass方法取得这个类：
        Class<?> proxyClass = Proxy.getProxyClass(null, Comparable.class);
        //6.代理类一定是public和final

    }

}
