package com.daniel.corejava.five;

/**
 * 5.4 对象包装器与自动装箱<br/>
 *
 * @author daniel
 * @version 2021.07.21
 */
public class WrapperDemo {

    @SuppressWarnings({"UnnecessaryBoxing", "UnnecessaryUnboxing"})
    public static void main(String[] args) {
        //对象包装器类：Number(Integer,Long,Float,Double,Short,Byte),Character,Void,Boolean,
        //对象包装器类是不可变的，一旦构造了包装器，就不允许更改包装在其中的值，且不能定义他们的子类

        int aInt = 3;
        Integer aInteger = 3;
        //自动装箱
        aInteger = Integer.valueOf(aInt); //Unnecessary boxing 'Integer.valueOf(aInt)'
        //自动拆箱
        aInt = aInteger.intValue();//Unnecessary unboxing 'aInteger.intValue()'
        //说明：
        //1.包装器类引用可以为null,自动装箱时可能会抛出空指针异常.
        //2.如果在一个条件表达式中混合使用Integer和Double类型,Integer值就会拆箱,提升为Double,再装箱为Double.
        //3.装箱和拆箱是编译器认可的,而不是虚拟机.

        //适合放置在包装类中的静态方法,如下：
        int x = Integer.parseInt("1");
    }

}
