package com.daniel.three;

//直接使用Math类方法

import static java.lang.Math.*;

/**
 * This is the first sample program in Core Java Chapter 3
 *
 * @author daniel
 * @version 1.0 20210609
 */
@SuppressWarnings("ALL")
public class FirstSample {

    /**
     * 常量,必须使用final定义
     */
    private static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) {
        //is this too cute?
        System.out.println("We will not use 'Hello World'");

        /*
            byte    1   -128-127
            short   2   -32768-32767
            int     4   -2147483648-2147483647
            long    8   -9223372036854775808-9223372036854775807    l、L
         */

        /*
            float   4   +-3.40282347E+38F   f、F
            double  8   +-1.79769313486231570E+308
         */

//        Infinity
        System.out.println(Double.POSITIVE_INFINITY);
//        -Infinity
        System.out.println(Double.NEGATIVE_INFINITY);
//        Not a Number
        System.out.println(Double.NaN);

        String doubleStr = "123";
//        check whether doubleStr is "not a number"
        if (Double.isNaN(Double.parseDouble(doubleStr))) {
            System.out.println(doubleStr + " not a number.");
        } else {
            System.out.println(doubleStr + " is a number.");
        }

        /*
            char 65 == 'A' != "A"   \u0000-\Uffe
            boolean false/true
         */
        //判断字符是否属于Java
        System.out.println(Character.isJavaIdentifierStart('A'));
        System.out.println(Character.isJavaIdentifierPart('$'));

        double paperWidth = 8.5212345615645615641651564156415641859641532156161561651586462156416586416546584165;
        double paperHeight = 11;
        System.out.println(
                "Paper size in centimeters:" + paperWidth * paperHeight + " by " + paperHeight * CM_PER_INCH);

        System.out.println("运算符: +,-,*,/,%");

        //在Math类中，为了能达到最快的性能，所有的方法都使用计算机浮点单元中的例程。如果得到一个完全可预测的结果比运行速度更重要的
        //话，那么就应该使用StrictMath类。
        System.out.println("数学函数与常量==================================");
        double x = 4;
        //平方根
        System.out.println(sqrt(x));
        //幂
        System.out.println(pow(x, 2.0));
        //取余
        System.out.println(floorMod(5, 3));
        //三角函数
        System.out.println(sin(120.0));
        System.out.println(cos(120.0));
        System.out.println(tan(120.0));
        System.out.println(atan(120.0));
        System.out.println(atan2(120.0, 5.0));
        //指数函数
        System.out.println(exp(2.71));
        System.out.println(log(10));
        System.out.println(log10(10));
        System.out.println(E);
        System.out.println(PI);

        System.out.println("数值类型之间的转换==================================");
        short aShort = Short.parseShort("1");
        int aInt = 1;
        long aLong = 1L;
        double aDouble = 1.0;
        float aFloat = 1.0F;
        System.out.println("------无信息丢失的转换.byte->short->int->long、int->double、float->double、char->int------");
        System.out.println("------可能有精度损失的转换.int->float、long->double、long->float------");
        System.out.println("如果两个操作数中有一个是double类型，另一个操作数就会转换为double类型。");
        System.out.println(aInt + aDouble);
        System.out.println("否则，如果其中一个操作数是float类型，另一个操作数将会转换为float类型。");
        System.out.println(aInt + aFloat);
        System.out.println("否则，如果其中一个操作数是long类型，另一个操作数将会转换为long类型。");
        System.out.println(aInt + aLong);
        System.out.println("否则，两个操作数都将转换为int类型。");
        System.out.println(aShort + aInt);
        System.out.println("------强制类型转换------");
        double a1Double = 9.997;
        int a1Int = (int) a1Double;
        System.out.println(a1Int);
        //四舍五入
        System.out.println((int) Math.round(a1Double));
        System.out.println("------结合赋值和运算符------");
        System.out.println(aInt += 4);
        //aInt += 3.5   ==   aInt = (int) aInt + 3.5
        System.out.println(aInt += 3.5);
        int m = 7;
        int n = 7;
        //加1,使用
        System.out.println(2 * ++m);
        //加1,不使用, 不要在表达式用使用++,这样的代码很容易让人困惑。
        System.out.println(2 * n++);
        System.out.println(n);
        System.out.println("------关系和boolean运算符(== != > < >= <= | || & && ?:)------");
//        false
        System.out.println(3 == 7);
//        true
        System.out.println(3 != 7);
//        false
        System.out.println(3 > 7);
//        false
        System.out.println(3 >= 7);
//        true
        System.out.println(3 < 7);
//        true
        System.out.println(3 <= 7);
        System.out.println("短路不计算第二个,即第一个为false不计算第二个 " + (3 > 7 && aInt / 0 > 0));
//        System.out.println("不短路与运算第二个,即第一个为false仍然计算第二个" + (3 > 7 & aInt / 0 > 0));
        System.out.println("短路不计算第二个,即第一个为true不计算第二个 " + (3 < 7 || aInt / 0 > 0));
//        System.out.println("不短路或运算第二个,即第一个为true仍然计算第二个" + (3 < 7 | aInt / 0 > 0));
        System.out.println("三元操作符 " + (Integer.parseInt("1") > Integer.parseInt("2") ? 1 : 2));
        System.out.println("------位运算符(&'and', |'or', ^'xor', ~'not', >>'right,符号位填充高位', <<'left', " +
                ">>>>'right,0填充高位'),应用在布尔值上时参照上面.------");
        //TODO not understander
        int fourthBitFromRight = (0b1001 & 0b1000) / 0b1000;
        System.out.println(fourthBitFromRight);
//        0b1001
//        0b1000
//        0b1000
        System.out.println(0b1001 & 0b1000);
//        0b1001
//        0b1000
//        0b1001
        System.out.println(0b1001 | 0b1000);
//        1 = 0b0001 << 3 = 0b1000 = 8 >> 3 = 0b0001 = 1
        fourthBitFromRight = (0b1001 & (1 << 3)) >> 3;
        System.out.println(fourthBitFromRight);
        System.out.println("------运算符优先级------");
        System.out.println("运算符                                                   结合性");
        System.out.println("[].()()                                                 从左向右");
        System.out.println("! ~ ++ -- + - () new                                    从左向右");
        System.out.println("* / %                                                   从左向右");
        System.out.println("+ -                                                     从左向右");
        System.out.println("<< >> >>>                                               从左向右");
        System.out.println("< <= > >= instanceof                                    从左向右");
        System.out.println("== !=                                                   从左向右");
        System.out.println("&                                                       从左向右");
        System.out.println("^                                                       从左向右");
        System.out.println("|                                                       从左向右");
        System.out.println("&&                                                      从左向右");
        System.out.println("||                                                      从左向右");
        System.out.println("?:                                                      从左向右");
        System.out.println("= += -= *= /= %= &= |= ^= <<= >>= >>>=                  从左向右");
        System.out.println("------枚举类型------");
        Size size = Size.MEDIUM;
        System.out.println(size);
        System.out.println("3.6 字符串================================");
        String e = "string";
        System.out.println(e);
        System.out.println("3.6.1 子串-------------------------------");
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        System.out.println(s);
        System.out.println("3.6.2 拼接-------------------------------");
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println(message);
        int age = 13;
        String rating = "PG" + age;
        System.out.println(rating);
        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println(all);
        System.out.println("3.6.3 不可变字符串(Java中字符串不可直接进行修改.)-------------------------------");
        //实际上greetingCopy与greeting的引用地址都是@513,并未生成新的字符串
        String greetingCopy = greeting;
        //修改后不会在原来的对象上进行修改，而是生成一个新的字符串对象@514.
        greeting = greetingCopy.substring(0, 3) + "p!";
        System.out.println(greeting);
        //@513
        System.out.println(greetingCopy);
        //确实修改一个字符串要比创建一个字符串对象效率要低,但是正如下面的代码不可变字符串确有一个有点：编译器可以让字符串共享，
        //下面的字符串为@513
        String copy = "Hello";
        System.out.println(copy);
        System.out.println("3.6.4 检测字符串是否相等.-------------------------------");
//        false
        System.out.println(greeting.equals(greetingCopy));
//        true
        System.out.println("Help!".equals(greeting));
//        true
        System.out.println("HELLO".equalsIgnoreCase("hello"));
        System.out.println("3.6.5 空串与Null串.-------------------------------");
        String emptyString = "";
//        true
        System.out.println(emptyString.length() == 0);
        System.out.println(emptyString.equals(""));
        String nullString = null;
//        报错
//        System.out.println(nullString.length() == 0);
        System.out.println(nullString == null);
//        判断空字符串
        if (emptyString != null && emptyString != "") {
            System.out.println(emptyString + "不是空字符串");
        } else {
            System.out.println(emptyString + "是空字符串");
        }
        System.out.println("3.6.6 码点与代码单元.-------------------------------");

    }
}
