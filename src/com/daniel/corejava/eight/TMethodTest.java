package com.daniel.corejava.eight;

import com.daniel.corejava.six.ArrayAlg;

/**
 * 8.2 泛型方法测试
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/8
 * @see ArrayAlg#getMiddle(Object[])
 */
public class TMethodTest {

    public static void main(String[] args) {
        String middle = ArrayAlg.getMiddle("daniel", "tom", "jack");
        System.out.println(middle);

        //3、偶尔也会出现错误,信息如下:Incompatible types: Number & Comparable<? extends Number & Comparable<?>> is not convertible to Double
//        Double middle1 = ArrayAlg.getMiddle(3.14, 1729, 0);
        Double aDouble = ArrayAlg.getMiddle(3.14, 1729.0, 0.0);
        System.out.println(aDouble);
        //解释这句代码有两种方法,而且这两种方法都是合法的(编译器会自动打包参数为1个Double和2个Integer对象,然后寻找这些类的共同超类型)
        //如错误提示事实上找到了这样的两个超类Number和Comparable接口,其本身也是一个泛型类型
        //因此我们只能将参数全部写为double类型的值

    }

}
