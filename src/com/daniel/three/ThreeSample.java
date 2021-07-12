package com.daniel.three;

//直接使用Math类方法

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * This is the first sample program in Core Java Chapter 3
 *
 * @author daniel
 * @version 1.0 20210609
 */
@SuppressWarnings("ALL")
public class ThreeSample {

    /**
     * 常量,必须使用final定义
     */
    private static final double CM_PER_INCH = 2.54;

    public static void main(String[] args) throws IOException {
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
        System.out.println("Java字符串由char值序列组成，char数据类型是一个采用UTF-16编码表示的Unicode码点的代码单元");
        System.out.println("length方法将返回采用UTF-16编码表示的给定字符串所需的代码单元数量：");
        greeting = "Hello";
        //is 5
        n = greeting.length();
        System.out.println("得到实际的长度，即码点数量：");
        int cpCount = greeting.codePointCount(0, n);
        System.out.println("greeting.codePointCount(0, n) = " + cpCount);
        System.out.println("调用s.chatAt(n)将返回位置n的代码单元：");
        char first = greeting.charAt(0);
        char last = greeting.charAt(4);
        System.out.println(first + "----" + last);
        System.out.println("要想得到第i个码点，应该使用下列的语句：");
        int index = greeting.offsetByCodePoints(0, 2);
        int cp = greeting.codePointAt(index);
        System.out.println(cp);
        System.out.println("字符串转换为码点数组：");
        Arrays.stream(greeting.codePoints().toArray()).forEach(System.out::println);
        System.out.println("码点数组转换为字符串：");
        System.out.println(new String(greeting.codePoints().toArray(), 0, greeting.codePoints().toArray().length));
        System.out.println("总结：代码单元即是组成字符串的实际代码单元，码点即是代码单元对应的utf-16值");
        System.out.println("3.6.7 String API -------------------------------");
        System.out.println("返回给定位置的代码单元：" + greeting.charAt(0));
        System.out.println("返回给定位置的码点：" + greeting.codePointAt(2));
        System.out.println("返回从startIndex代码点开始，位移cPCount后的码点索引：" + greeting.offsetByCodePoints(0, 2));
        System.out.println("按照字典顺序，字符串位于参数之前返回一个负数，字符串位于参数之后返回一个正数，两个字符串相等返回0");
        //相等0
        System.out.println(greeting.compareTo(greeting));
        //参数之前负数
        System.out.println(greeting.compareTo("greeting---"));
        //参数之后正数
        System.out.println(greeting.compareTo("---greeting"));
        System.out.println("将一个字符串的码点作为一个流返回调用toArray将它们放在一个数组中：" + greeting.codePoints().toArray());
        System.out.println("用数组中从offset开始的count个码点构造一个字符串：" + new String(greeting.codePoints().toArray(), 2, 2));
        System.out.println("判断字符串是否相等：");
        System.out.println("greeting".equals(greeting));
        System.out.println("Hello".equals(greeting));
        System.out.println("忽略大小写判断字符串是否相等：" + "hello".equalsIgnoreCase(greeting));
        System.out.println("判断字符串是否以参数开头或结尾：");
        System.out.println(greeting.startsWith("Hel"));
        System.out.println(greeting.endsWith("lo"));
        System.out.println("返回字符串参数或代码点参数匹配的第一个子串的额开始位置：");
        System.out.println(greeting.indexOf("l"));
        System.out.println(greeting.indexOf(108));
        System.out.println(greeting.indexOf("l", 3));
        System.out.println(greeting.indexOf(108, 3));
        System.out.println("返回字符串参数或代码点参数匹配的最后一个子串的额开始位置：");
        System.out.println(greeting.lastIndexOf("l"));
        System.out.println(greeting.lastIndexOf(108));
        System.out.println(greeting.lastIndexOf("l", 2));
        System.out.println(greeting.lastIndexOf(108, 2));
        System.out.println("返回字符串长度：" + greeting.length());
        System.out.println("返回startIndex与endIndex-1之间的代码点数量：" + greeting.codePointCount(0, 4));
        System.out.println("字符串替换：" + greeting.replace("lo", "test"));
        System.out.println("字符串截取：");
        System.out.println(greeting.substring(1));
        System.out.println(greeting.substring(1, 3));
        System.out.println("字符串小写：" + greeting.toLowerCase(Locale.ROOT));
        System.out.println("字符串大写：" + greeting.toUpperCase(Locale.ROOT));
        System.out.println("字符串去掉两端空格：" + (" " + greeting + " ").trim());
        System.out.println("字符串拼接(静态方法)：" + String.join("-", "H", "e", "l", "l", "o"));
        System.out.println("3.6.8 阅读联机API文档 -------------------------------");
        System.out.println("https://docs.oracle.com/javase/8/docs/api/");
        System.out.println("3.6.9 构建字符串 -------------------------------");
        System.out.println("StringBuilder(前身为StringBuffer，效率稍低，但是允许使用多线程方式执行添加或删除字符操作，两个类的API相同):");
        System.out.println("构造一个空的字符串构建器：");
        StringBuilder builder = new StringBuilder();
        System.out.println("追加一个字符串并返回this:" + builder.append("china"));
        System.out.println("追加一个代码单元并返回this:" + builder.append('/'));
        System.out.println("追加一个代码点，并将其转换为一个或两个代码单元并返回this:" + builder.appendCodePoint(108));
        System.out.println("追加一个代码单元并返回this:" + builder.append('/'));
        System.out.println("将第i(从0开始计算)个代码单元设置为c:void setCharAt(int i,char c)");
        builder.setCharAt(6, 'L');
        System.out.println(builder.toString());
        System.out.println("返回构建器或缓冲器中的代码单元数量：" + builder.length());
        System.out.println("注：采用字符串连接的方式连接较短的字符串效率比较低，每次连接都构建一个新的String对象，耗时且浪费空间.");
        System.out.println("3.7 输入输出================================");
        System.out.println("3.7.1 读取输入 -------------------------------");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("读取整行：" + scanner.nextLine());
//        System.out.println("读取单词：" + scanner.next());
//        System.out.println("读取整数：" + scanner.nextInt());
//        System.out.println("读取浮点数：" + scanner.nextDouble());
//        System.out.println("检测未读取输入中是否还有其他单词：" + scanner.hasNext());
//        System.out.println("检测未读取输入中是否还有其他整数：" + scanner.hasNextInt());
//        System.out.println("检测未读取输入中是否还有其他浮点数：" + scanner.hasNextDouble());
        System.out.println("Scanner为明文输入,可以使用console进行密文输入但是真的是需要javac控制台运行");
//        Console console = System.console();
//        String readLine = console.readLine("username:");
//        char[] readPassword = console.readPassword("password:");
//        System.out.println(readLine);
//        System.out.println(readPassword);
        System.out.println("3.7.2 格式化输出 -------------------------------");
        x = 10000.0 / 3.0;
        System.out.print(x);
        //8个字符宽度(1个空格、7个字符)和小数点后两位
        System.out.printf("%8.2f", x);
        System.out.printf("Hello, %s. Next year, you'll be %d%n", "daniel", 24);
        System.out.println("printf转换符:表3-5");
        System.out.println("printf标志:表3-6");
        System.out.println("使用静态的String.format()方法创建一个格式化字符串，而不打印输出：" + String.format("Hello, %s. Next Year, you'll " +
                "be %d", "daniel", 24));
        System.out.printf("%tc%n", new Date());
        System.out.println("日期和时间转换符:表3-7(p59)");
        System.out.println("格式说明符语法:图3-6(p60)");
        System.out.println("3.7.2 文件输入与输出 -------------------------------");
        Scanner fileScanner = new Scanner(
                Paths.get("src\\com\\daniel\\three\\testRead.txt"),
                "UTF-8"
        );
        System.out.println(fileScanner.nextLine());
        System.out.println(fileScanner.nextLine());
        System.out.println(fileScanner.next());
        System.out.println(fileScanner.nextInt());
        PrintWriter printWriter = new PrintWriter(
                "src\\com\\daniel\\three\\testWrite.txt",
                "UTF-8"
        );
        printWriter.println("testWrite");
        printWriter.print(123);
        printWriter.printf("Hello %s.", "daniel");
        System.out.println("IDE用户当前路径：" + System.getProperty("user.dir"));
        System.out.println("3.8 控制流程 ===========================");
        System.out.println("3.8.1 块作用域 -------------------------");
        {
            String bolckParams = "blockParams";
            System.out.println(bolckParams);
        }
        System.out.println("3.8.2 条件语句 -------------------------");
        if (true) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println("3.8.3 循环 -------------------------");
        int condtion = 10;
        while (condtion > 0) {
            System.out.println("while --- " + condtion);
            condtion--;
        }
        System.out.println("condition = " + condtion);
        condtion = 0;
        do {
            System.out.println("while --- " + condtion);
            condtion--;
        } while (condtion > 0);
        System.out.println("condition = " + condtion);
        System.out.println("3.8.4 确定循环 -------------------------");
        condtion = 10;
        for (int i = 0; i < condtion; i++) {
            System.out.println("condition = " + i);
        }
        System.out.println("从n个数字中选择6个数字.");
        int lotterOdds = 1;
        int k = 6;
        n = 50;
        for (int i = 1; i <= k; i++) {
            lotterOdds = lotterOdds * (n - i + 1) / i;
        }
        System.out.println("1/" + lotterOdds);
        System.out.println("3.8.5 多重选择：switch语句 -------------------------");
        int choice = 1;
        switch (choice) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            default:
                System.out.println("default");
        }
        System.out.println("case标签可以是char/byte/short/int/menu/string");
        System.out.println("3.8.5 中断控制流程语句 -------------------------");
        int years = 1;
        while (years <= 100) {
            if (years == 50) {
                System.out.println("退出while循环,year = " + years);
                break;
            }
            years++;
        }
        int forResult = 0;
        for (int i = 0; i <= 100; i++) {
            if (i > 5) {
                continue;
            }
            forResult += i;
        }
        System.out.println(forResult);
        System.out.println("3.9 大数值 =========================");
        System.out.println("Biglnteger类实现了任意精度的整数运算,BigDecimal实现了任意精度的浮点数运算.但是无法使用普通的运算符号.");
        System.out.println("使用静态的 valueOf方法可以将普通的数值转换为大数值：");
        BigInteger bigInteger = BigInteger.valueOf(100);
        bigInteger = bigInteger.subtract(bigInteger);
        System.out.println(bigInteger);
        bigInteger = bigInteger.add(BigInteger.valueOf(100));
        System.out.println(bigInteger);
        bigInteger = bigInteger.multiply(bigInteger);
        System.out.println(bigInteger);
        bigInteger = bigInteger.divide(bigInteger);
        System.out.println(bigInteger);
        bigInteger = bigInteger.mod(bigInteger);
        System.out.println(bigInteger);
        int compareTo = bigInteger.compareTo(BigInteger.valueOf(10));
        System.out.println(compareTo);
        BigDecimal bigDecimal = BigDecimal.valueOf(10.01);
        bigDecimal = bigDecimal.subtract(bigDecimal);
        System.out.println(bigDecimal);
        bigDecimal = bigDecimal.add(BigDecimal.valueOf(10.01));
        System.out.println(bigDecimal);
        bigDecimal = bigDecimal.multiply(bigDecimal);
        System.out.println(bigInteger);
        bigDecimal = bigDecimal.divide(bigDecimal);
        System.out.println(bigDecimal);
        int compareToBigDecimal = bigDecimal.compareTo(BigDecimal.valueOf(10.01));
        System.out.println(compareToBigDecimal);
        BigDecimal decimal = BigDecimal.valueOf(10, 5);
        System.out.println(decimal);
        System.out.println("3.10 数组 =========================");
        int[] intArray = new int[100];
        for (int i = 0; i < 100; i++) {
            intArray[i] = i;
        }
        System.out.println("创建一个数字数组时，所有元素初始化为0，boolean数组元素会初始化为false，对象数组则为null");
        String[] names = new String[10];
        for (int i = 0; i < 10; i++) {
            names[i] = "";
        }
        System.out.println("3.10.1 for each 循环 --------------------------");
        System.out.println("循环intArray中的每一个元素:");
        for (int intParameter : intArray) {
            System.out.println(intParameter);
        }
        System.out.println("3.10.2 数组初始化以及匿名数组 --------------------------");
        int[] smallPrimes = {3, 2, 5, 7, 9, 11, 13};
        System.out.println(smallPrimes[0]);
        //赋值后将不是原来的对象，引用地址会发生变化
        smallPrimes = new int[]{3, 5, 7, 9, 11, 13, 15};
        System.out.println(smallPrimes[0]);
        System.out.println("3.10.3 数组拷贝 ----------------------------");
        //此方法赋值数组不生成新的对象还是原来的引用地址，修改后原参数将发生变化.
        int[] luckyNumbers = smallPrimes;
        luckyNumbers[5] = 12;
        System.out.println(smallPrimes[5]);
        //生成新数组,观察输出的引用地址，luckyNumbers.length通常用来增加数组的大小
        //如果数组元素是数值型，那么多余的元素将被赋值为 0 ; 如果数组元素是布尔型，则将赋值为 false。相反，如果长度小于原始数组的长度，则只拷贝最前面的数据元素
        int[] copidLuckyNumbers = Arrays.copyOf(luckyNumbers, luckyNumbers.length);
        System.out.println(luckyNumbers);
        System.out.println(copidLuckyNumbers);
        System.out.println("3.10.4 命令行参数(main方法String arg[],假设此类使用java Message -g cruel world运行)");
        args = new String[3];
        args[0] = "-g";
        args[1] = "cruel";
        args[2] = "world";
        if (args.length == 0 || args[0].equals("h")) {
            System.out.print("Hello.");
        } else if (args[0].equals("-g")) {
            System.out.print("Goodbye.");
        }
        for (int i = 1; i < args.length; i++)
            System.out.print(" " + args[i]);
        System.out.println("!");
        System.out.println("3.10.5 数组排序 ------------------------");
        //优化的快速排序算法
        Arrays.sort(smallPrimes);
        //输出以逗号分割的元素字符串
        System.out.println(Arrays.toString(smallPrimes));
        //截取
        System.out.println(Arrays.toString(Arrays.copyOf(smallPrimes, 3)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(smallPrimes, 3, 5)));
        //二分搜索算法查找值
        System.out.println(Arrays.binarySearch(smallPrimes, 12));
        System.out.println(Arrays.binarySearch(smallPrimes, 6, 7, 12));
        //将数组的所有元素设置为参数
        Arrays.fill(smallPrimes, 1);
        System.out.println(Arrays.toString(smallPrimes));
        //判断两个数组是否相等
        System.out.println(Arrays.equals(smallPrimes, luckyNumbers));
        System.out.println("3 . 1 0.6 多维数组 --------------------");
        double[][] balances = new double[10][5];
        //使用for或for_each初始化二维数组
        for (int i = 0; i < balances.length; i++) {
            double[] row = balances[i];
            for (int j = 0; j < row.length; j++) {
                balances[i][j] = i + j;
            }
        }
        System.out.println(balances[1][2]);
        System.out.println(Arrays.deepToString(balances));
        int[][] magicSqurare = {
                {16, 3, 2, 12},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };
        System.out.println(magicSqurare[1][0]);
        System.out.println("3.10.7 不规则数组 -------------------");
        //java中不存在二维数组其实二维数组就是包含多个数组元素的数组，因此可以将两行进行交换,还可以构造不同长度的二维数组
        double[] temp = balances[0];
        balances[0] = balances[1];
        balances[1] = temp;
        System.out.println(Arrays.deepToString(balances));
        int[][] odds = new int[5][];
        for (int i = 0; i < odds.length; i++) {
            //初始化数组长度
            odds[i] = new int[i + 1];
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                odds[i][j] = i + j;
            }
        }
        System.out.println(Arrays.deepToString(odds));
    }
}
