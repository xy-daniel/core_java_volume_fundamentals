package com.daniel.corejava.five;

import com.daniel.corejava.three.Size;

import java.util.Arrays;

/**
 * 5.6 枚举类<br/>
 * 所有的枚举类型都是{@link Enum}的子类,如：{@link com.daniel.corejava.three.Size}<br/>
 * 他们继承了这个类许多的方法,其中最有用的一个是{@link Enum#toString()},能够返回枚举常量名.<br/>
 * {@link Enum#toString()}的逆方法是静态方法{@link Enum#valueOf(Class, String)}
 *
 * @author daniel
 * @version 2021.07.22
 * @see com.daniel.corejava.three.Size
 */
public class EnumDemo {

    public static void main(String[] args) {
        //toString()
        System.out.println(Size.SMALL.toString());//SMALL
        //valueOf(Class, String)
        Size size = Enum.valueOf(Size.class, "SMALL"); //size = Size.SMALL
        System.out.println(size);//SMALL
        //values()
        Size[] values = Size.values();
        System.out.println(Arrays.toString(values));//[SMALL, MEDIUM, LARGE, EXTRA_LARGE]
        //ordinal()
        System.out.println(Size.MEDIUM.ordinal());//1
    }

}
