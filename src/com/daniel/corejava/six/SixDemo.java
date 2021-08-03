package com.daniel.corejava.six;

import com.daniel.corejava.four.Employee;

import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

/**
 * 第6章 接口、lambda表达式与内部类<br/>
 * 重点：接口、内部类、接口示例、代理、lambda表达式<br/>
 * 接口：用来描述类具有什么功能,而并不给出每个功能的具体实现。<br/>
 * 实现：一个或多个接口,并在需要接口的地方,随时使用实现了相应接口的对象<br/>
 * lambda表达式：一种表示可以在将来某个时间点执行的代码块的间接方法<br/>
 * 内部类：类内部的类<br/>
 * 代理：一种实现任意一个接口的对象<br/>
 * 6.1 接口<br/>
 * 6.2 接口示例<br/>
 * 6.3 lambda表达式<br/>
 * 6.4 内部类
 *
 * @author daniel
 * @version 2021.07.30
 * @see com.daniel.corejava.four.Employee#compareTo(com.daniel.corejava.four.Employee)
 * @see java.util.Collection
 * @see java.util.Collections
 * @see java.util.AbstractCollection
 * @see java.nio.file.Path
 * @see java.nio.file.Paths
 * @see Moveable
 * @see Powered
 * @see java.awt.event.MouseListener
 * @see java.awt.event.MouseAdapter
 * @see ActionListener
 * @see java.util.function.BiFunction
 * @see java.util.function.Predicate
 */
public class SixDemo {

    @SuppressWarnings({"ConstantConditions", "ComparatorCombinators", "UseCompareMethod"})
    public static void main(String[] args) {
        //6.1 接口
        Employee daniel = new Employee("daniel", 100, 2000, 2, 2);
        Employee tom = new Employee("tom", 99, 2000, 2, 2);
        System.out.println(Employee.compare(daniel, tom));
        Employee[] employees = new Employee[2];
        employees[0] = daniel;
        employees[1] = tom;
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));

        /*
            6.1.2 接口的特性
            接口不是类,不能通过new运算符构造接口的对象,但是能够声明接口的变量,但是必须引用实现了接口的对象
        */
        Comparable<Employee> x = new Employee();
        if (x instanceof Comparable) {
            System.out.println("true");
        }

        //6.1.3 接口与抽象类
        //为什么不一样？每个类只能扩展一个抽象类,但是可以实现多个接口

        //6.1.4 静态方法-java8之后允许接口中增加静态方法
        //目前为止,通常的做法是将静态方法放在伴随类中,如：Collection/Collections,Path/Paths

        //6.1.5 默认方法default-可以为接口方法提供一个默认实现
        //其实大可不必,例如：Comparable#compareTo.
        //但是有时候一个事件需要使用几个方法,但是我们只需要关注其中一两个,例如：MouseListener
        //当然他们都没有这么做只是可以这么做,他们还是使用的伴随类实现了相应接口的部分或全部方法。现在可以直接在接口中实现方法。
        //重要用法：接口演化-以Collection为例,实现了这个类如果增加非默认的方法将导致程序不可运行.

        //6.1.6 解决默认方法冲突
        //规则：1.超类优先 2.接口冲突：都未实现则实现就好,如有已实现则需要解决二义性的问题

        //6.2.1 接口与回调
        //回调:一种常见的设计模式,在这种模式下,可移指出某个特定时间发生时应该采取的动作。参考TimeTest

        //6.2.2 Comparator接口
        //使用默认的String比较器进行排序
        Arrays.sort(employees);
        //自定义比较器进行排序(自定义的比较器要在比较器上调用而不是在字符串本身调用)
        Comparator<String> comparator = new LengthComparator();
        if (comparator.compare("daniel", "tom") > 0) {
            System.out.println("daniel > tom");
        }
        String[] friends = {"daniel", "tom", "jack"};
        Arrays.sort(friends, comparator);
        System.out.println(Arrays.toString(friends));

        //6.2.3 对象克隆--提供一个安全的克隆方法
        Employee original = new Employee("daniel", 10000, 2020,10,1);
        //这样的复制引用的是同一个对象
        Employee copy = original;
        System.out.println(original.getSalary());//10000
        System.out.println(copy.getSalary());//10000
        copy.raiseSalary(10);
        System.out.println(original.getSalary());//11000
        System.out.println(copy.getSalary());//11000

        //克隆：默认的克隆操作是浅拷贝(Object),没有克隆对象中引用的其他对象.并且是受保护状态的因此我们无法直接使用,所以必须重写接口方法并修改为public
        //视情况而定,如果对象引用的子对象是不可变的我们大可不必重写克隆方法,不过,通常情况下子对象是可变的
        copy = original.clone();
        copy.raiseSalary(10);
        System.out.println(original.getSalary());//11000
        System.out.println(copy.getSalary());//12100

        //所有数组类型都有一个public的clone方法。
        int[] luckyNumber = {1,2,3,4,5};
        int[] clone = luckyNumber.clone();
        System.out.println(clone[4]);//5

        //6.3 lambda表达式：一个可传递的代码块,可以在以后执行一次或多次.

        //6.3.1 为什么引用lambda表达式
        //TimePrinter.actionPerformed/Arrays.sort都是将一个代码块传递到某个对象。这个代码块会在某个时间调用。
        //java中不能直接传递代码段,Java是一个面向对象语言,所以必须构造一个对象,这个对象的类需要一个方法包含所需的代码。

        //6.3.2 语法
        //形式：参数,箭头(->)以及一个表达式.
        //1.Java是一种强类型语言,所以我们必须指定参数的类型
        Comparator<String> comparatorLength = (String first, String second) -> first.length() - second.length();
        System.out.println("comparatorLength = " + comparatorLength.compare("daniel", "tomcat"));//comparatorLength = 0
        //2.如果无法直接放在一个表达式中,就可以像写方法一样给出显示的return语句
        Comparator<String> stringComparator = (String first, String second) -> {
            if (first.length() < second.length())
                return -1;
            else if (first.length() > second.length())
                return 1;
            else
                return 0;
        };
        System.out.println("stringComparator = " + stringComparator.compare("daniel", "tomcat"));//stringComparator = 0
        //3.即使lambda表达式没有参数,任然要提供(),就像无参数方法一样
        final Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + ",");
            }
            System.out.println();
        };
        runnable.run();
        //4.如果可以推导出一个lambda表达式的参数类型,则可以忽略其类型
        Comparator<String> comp = (first, second) -> first.length() - second.length();
        System.out.println("comp = " + comp.compare("daniel", "tomcat"));//comp = 0
        //5.如果方法只有一个参数，而且这个参数的类型可以推导得出，那么甚至还可以省略小括号
        ActionListener actionListener = event -> System.out.println("The time is " + new Date());
        //6.无需指定lambda表达式的返回类型.就如1.中，可以在需要int类型结果的上下文中使用.
        //注：如果一个lambda表达式只在某些分支返回一个值，而在另外一些分支不返回值，这是不合法的.如：
//        IntFunction<Integer> integerIntFunction = (int params) -> {
//            if (params > 0) {
//                return 1;
//            }
//        };

        //6.3.3 函数式编程
        //lambda表达式与如ActionListener或Comparator等很多封装代码块的接口是兼容的
        //对于只有一个抽象方法的接口，需要这种接口的对象时，就可以提供一个lambda表达式，这种接口称之为函数式接口
        //简化：Arrays.sort(friends, comparator);
        System.out.println("6.3.3 函数式编程");
        System.out.println(Arrays.toString(friends));//[tom, jack, daniel]
        Arrays.sort(friends, (first, second) -> second.length() - first.length());
        System.out.println(Arrays.toString(friends));//[daniel, jack, tom]
        //简化TimeTest: event = (ActionListener event)
        Timer timer = new Timer(1000, event -> {
            System.out.println("At the tone, the time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
//        timer.start();
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);
        //实际上，在Java中，lambda表达式能做的也只是能转换为函数式接口。甚至不能把lambda表达式赋值给类型为Object的变量,Object不是一个函数式接口。
        //Java API在java.util.function包中定义了很多非常通用的函数式接口。其中一个接口BiFunction<T,U,R>描述了参数类型为T和U而且返回类型为R的函数：
        BiFunction<String, String, Integer> biFunction = (first, second) -> first.length() - second.length();
        System.out.println("biFunction = " + biFunction.apply("daniel", "tom"));
        //BiFunction作用不大，想要lambda表达式做某些处理，还是谨记表达式的用途，为它建立一个函数式接口.
        //java.util.function包中有一个尤其有用的接口Predicate
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(null);
        //boolean test(T t);----相当于实现此接口并编写代码块进行过滤：参考PredicateAction
        Predicate<? super Object> filter = o -> o == null;
        objects.removeIf(filter);
        System.out.println(objects.size());//1
        //测试实现接口的方式
        objects.add(null);
        objects.removeIf(new PredicateAction());
        System.out.println(objects.size());//1

        //6.3.4 方法引用----可能已经有现成的方法可以完成你想要传递到其他代码的某个动作.
        Timer timer1 = new Timer(1000, event -> System.out.println(event));
        //如上,可以直接把println方法传递到Timer构造器
        Timer timer2 = new Timer(1000, System.out::println);
        //注：System.out::println是一个方法引用。它等价于lambda表达式x -> System.out.println(x)
        Arrays.sort(friends, (String a, String b) -> b.compareToIgnoreCase(a));
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(friends));
        //综上，要用::操作符将方法名与对象名或类名分隔开,主要有三种情况：
        //1.object::instanceMethod
        //2.Class::staticMethod
        //3.Class::instanceMethod
        //1.2:等价于提供参数的lambda表达式x -> System.out.println(x) == System.out::println
        //3:第一个参数将会成为方法的目标(隐式参数)(String a, String b) -> a.compareToIgnoreCase(b) == String::compareToIgnoreCase
        //可以使用this:如x -> this.equals(x) == this::equals
        //可以使用super:如super::instanceMethod

        //6.3.5 构造器引用----Object::new
        ArrayList<String> names = new ArrayList<>();
        names.add("daniel");
        names.add("tom");
        names.add("jack");
        //stream、map、collect会在第二卷第一章解释(Employee::new会寻找最合适的构造器)
        Stream<Employee> employeeStream = names.stream().map(Employee::new);
        java.util.List<Employee> collect = employeeStream.collect(Collectors.toList());
        System.out.println(collect);
        //可以用数组类型建立构造器引用：int[]::new == x -> new int[x]
        IntFunction<int[]> intFunction = (int length) -> new int[length];
        System.out.println("intFunction = " + intFunction.apply(10).length);
        IntConsumer bNew = int[]::new;

        employeeStream = names.stream().map(Employee::new);
        //Java有个限制，无法构造泛型类型的数组，如：
        Object[] objectsArray = employeeStream.toArray();

        employeeStream = names.stream().map(Employee::new);
        //但是数组构造器应用对于客服这个限制很有帮助，如：
        Employee[] employeesArray = employeeStream.toArray(Employee[]::new);

        // 6.3.6 变量作用域 -- lambda引用外部变量,但是方法返回后外部引用的变量如何处理呢？
        // 注：关于代码块和自由变量的值有一个术语称之为闭包
        // lambda可以引用外围作用域中的值，但是要确保引用的值是明确定义的，只能引用不会改变的变量
//        String text = "test";
//        for (int i = 0; i < 10; i++) {
//            ActionListener eventListener = event -> System.out.println(i + ":" + text);
//            new Timer(1000, eventListener).start();
//        }
        // 并且lambda代码块不允许声明一个局部变量同名的参数或局部变量，
//        Path first = Paths.get("/usr/local");
//        Comparator<String> errorComp = (first, second) -> first.length() - second.length();
        // 在一个lambda表达式中使用this关键字时，是指创建这个lambda表达式的方法的this参数
//        ActionListener eventListener = event -> {
//            System.out.println(this.toString());//this == SixDemo
//        };

        // 6.3.7 处理lambda表达式
        // 重点：延迟执行
        // 原因：
        // 1、在一个单独的线程中运行代码
        // 2、多次运行代码
        // 3、在算法的适当位置运行代码
        // 4、发生某种情况时执行代码
        // 5、只在必要时才运行代码
        repeat(10, () -> System.out.println("Hello Daniel."));
        //常用的函数式接口：类名：参数类型：返回值类型：抽象方法名：描述：其他方法
        //Runnable：无：void： forTest：作为无参数或返回值的动作运行
        //Supplier<T>：无：T：get：提供一个T类型的值
        //Consume<T>：T：void：accept：提供一个T类型的值：andThen
        //BiConsumer<T>：T,U：void：accept：处理T和U类型的值：andThen
        //Function<T,R>：T：R：apply：有一个T类型参数的函数：compose,andThen,identity
        //BiFunction<T,U,R>：T,U：R：apply：有T和U类型参数的函数：andThen
        //UnaryOperator<T>：T：T：apply：类型T上的一元操作符：compose,andThen,identity
        //BinaryOperator<T>：T,T：T：apply：类型T上的二元操作符：andThen,maxBy,minBy
        //Predicate<T>：T：boolean：test：布尔值函数：and,or,negate,isEqual
        //BiPredicate<T,U>：T,U：boolean：test：有两个参数的布尔值函数：and,or,negate
        //举例：告诉这个动作出现在哪一次迭代中，因此要选择一个合适的函数式接口，包含一个方法，有一个int类型的参数而且返回值类型为void
        //选择：IntConsumer
        repeat(10, i -> System.out.println("CountDown: " + i));
        //减少自动装箱的函数式接口：类名：参数类型：返回类型：抽象方法名 + java.io.FileFilter
        //BooleanSupplier：none：boolean：getAsBoolean
        //PSupplier：none：p：getAsP
        //PConsumer：p：void：accept
        //ObjPConsumer<T>：T,p：void：accept
        //PFunction<T>：p：T：apply
        //PToQFunction：p：q：applyAsQ
        //ToPFunction<T>：T：p：applyAsP
        //ToPBiFunction<T,U>：T,U：p：applyAsP
        //PUnaryOperator：p：p：applyAsP
        //PBinaryOperator：p,p：p：applyAsP
        //PPredicate：p：boolean：test
        //注：p,q为int,long,double;P,Q为Int,Long,Double
        //注：大多数标准函数式接口都提供了非抽象方法来生成或合并函数.例如：Predicate.isEqual(a) == a::equals
        //注：如果自定义函数式接口，其中只有一个抽象方法，可以用@FunctionInterface注解来标记这个接口.
        Test test = () -> System.out.println("Test a author's interface.");
        test.forTest(); //没有参数无法使用::操作符

        //6.3.8 再谈Comparator
        //Comparator接口包含很多方便的静态方法来创建比较器,这些方法可以用于lambda表达式或方法引用.
        //静态 comparing 方法取一个“ 键提取器” 函数
        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, Comparator.comparing(Employee::getName, (s, t) -> Integer.compare(s.length(), t.length())));
        System.out.println(Arrays.toString(employees));
        //避免自动装箱使用变体形式(比较一个int,这个int是参数p(Employee)的name的长度)
        Arrays.sort(employees, Comparator.comparingInt(p -> p.getName().length()));
        System.out.println(Arrays.toString(employees));
        //如果键函数可以返回null,可能要使用nullsFirst和nullsLast适配器.这些静态方法会修改现有的比较器,从而在遇到null时不会抛出异常,而是将这个值标记为小于或大于正常值.
        //nullsFirst方法需要一个比较器.
        //naturalOrder方法可以为实现了Comparable的类建立一个比较器.
        Arrays.sort(employees, Comparator.comparing(Employee::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println(Arrays.toString(employees));
        //静态reverseOrder方法会提供自然顺序的逆序：Comparator.reverseOrder() == Comparator.naturalOrder().reversed()
        Arrays.sort(employees, Comparator.comparing(Employee::getName, Comparator.nullsFirst(Comparator.reverseOrder())));
        System.out.println(Arrays.toString(employees));




    }

    /**
     * 自定义函数式方法
     * @param n 参数
     * @param action 函数式接口
     */
    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    /**
     * repeat改进
     *
     * @param n 参数
     * @param action 函数式接口
     */
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}
