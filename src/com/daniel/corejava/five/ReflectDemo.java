package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 5.7 反射----reflection library<br/>
 * 能够分析类能力的程序称为<tt>反射</tt><br/>
 * 功能：<br/>
 * 1.在运行时分析类的能力.<br/>
 * 2.在运行时查看对象,例如编写一个toString方法供所有类使用.<br/>
 * 3.实现通用的数组操作代码.<br/>
 * 4.利用{@link java.lang.reflect.Method}对象.(参考C++中的函数指针)
 *
 * @author daniel
 * @version 2021.07.22
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        classType();
        exception();
//        useReflectAnalyseClass(args);
        useReflectAnalyseClassInRunning();
        useReflectFinishArray();
        useAnyMethod();
    }


    /**
     * 5.7.1 {@link Class}
     */
    @SuppressWarnings("ConstantConditions")
    public static void classType() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Object类中的getClass()方法将会返回一个Class类型的实例.
        //如果类在包里,包的名字也作为类名的一部分.
        Employee employee = new Employee("daniel");
        Class<? extends Employee> aClass = employee.getClass();
        System.out.println(aClass.getName() + " : " + employee.getName());//com.daniel.corejava.four.Employee : daniel
        employee = new Manager("tom");
        Class<? extends Employee> aClass1 = employee.getClass();
        System.out.println(aClass1.getName() + " : " + employee.getName());//com.daniel.corejava.five.Manager : tom

        //调用静态方法forName获得类名对应的Class对象,当然只有是类型或者接口名时此方法才能执行.
        String className = "java.util.Random";
        Class<?> aClass2 = Class.forName(className);
        System.out.println(aClass2.getName());//java.util.Random

        //最简单的方法
        Class<Random> randomClass = Random.class;
        System.out.println(randomClass.getName());//java.util.Random
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.getName());//int
        Class<Double[]> doubleArrayClass = Double[].class;
        System.out.println(doubleArrayClass.getName());//[Ljava.lang.Double;

        //可以使用==运算符实现两个类对象比较的操作
        System.out.println(employee.getClass() == Employee.class);//false

        //动态创建一个类的实例
        Employee instance = employee.getClass().newInstance();
        System.out.println(instance.getClass().getName());//com.daniel.corejava.five.Manager
        System.out.println(aClass2.newInstance().getClass().getName());//java.util.Random
    }

    /**
     * 5.7.2 捕获异常 ---- {@link Exception}<br/>
     * 可以提供一个"捕获异常的处理器"对异常情况进行处理.<br/>
     * 异常类型：未检查异常、已检查异常(try.catch)
     */
    public static void exception() {
        try {
            String className = "java.util.Random";
            Class<?> aClass2 = Class.forName(className);
            System.out.println(aClass2.getName());//java.util.Random
        } catch (ClassNotFoundException e) {
            //将Throwable对象和栈的轨迹输出到标准错误流.
            e.printStackTrace();
        }
    }

    /**
     * 5.7.3 利用反射({@link java.lang.reflect})分析类的能力 ---- 检查类的结构<br/>
     * {@link java.lang.reflect.Field}描述类的域<br/>
     * {@link java.lang.reflect.Method}描述类的方法<br/>
     * {@link java.lang.reflect.Constructor}描述类的构造器<br/>
     */
    public static void useReflectAnalyseClass(String[] args) throws ClassNotFoundException {
        //3#getName方法返回项目的名称
        //Field#getType方法返回描述域所属类型的Class对象
        //Method/Constructor#能够报告参数类型的方法
        //Method#报告返回类型的放
        //3#getModifiers方法返回一个用于描述修饰符的整形数值(使用Modifier可以分析返回的整形数值,并可使用#isPublic/#isPrivate
        //#isFinal判断方法或构造器是否是public/private/final,并可使用Modifier.toString方法将修饰符打印出来)
        //Class类中的getFields、getMethods、getConstructors方法将分别返回类提供的public域、方法和构造器数组，其中包括超类的共有成员.
        //Class类中的getDeclaredFields、getDeclaredMethods、getDeclaredConstructors方法将分别返回类提供的全部域、方法和构造器数组,
        //其中包括私有和受保护成员,但不包括超类的成员.
        String name;
        if (args.length > 0)
            name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入一个如java.util.Date的类名：");
            name = in.next();
        }
        Class<?> aClass = Class.forName(name);
        Class<?> superclass = aClass.getSuperclass();
        String modifier = Modifier.toString(aClass.getModifiers());
        if (modifier.length() > 0)
            System.out.print(modifier + " ");
        System.out.print("class " + name);
        if (superclass != null && superclass != Object.class)
            System.out.print(" extends " + superclass.getName());
        System.out.println(" {");
        printConstructors(aClass);
        printMethods(aClass);
        printFields(aClass);
        System.out.println("}");
        System.exit(0);
        /*
            console - java.util.Date - 结果如下：
            public class java.util.Date {
                public java.util.Date(int, int, int, int, int, int);
                public java.util.Date(java.lang.String);
                public java.util.Date();
                public java.util.Date(long);
                public java.util.Date(int, int, int);
                public java.util.Date(int, int, int, int, int);
                public int getDate();
                public boolean equals(java.lang.Object);
                public java.lang.String toString();
                public int hashCode();
                public java.lang.Object clone();
                public volatile int compareTo(java.lang.Object);
                public int compareTo(java.util.Date);
                public static long parse(java.lang.String);
                public boolean after(java.util.Date);
                public boolean before(java.util.Date);
                public static java.util.Date from(java.time.Instant);
                public long getTime();
                public void setTime(long);
                public int getDay();
                public int getHours();
                public int getMinutes();
                public int getMonth();
                public int getSeconds();
                public int getTimezoneOffset();
                public int getYear();
                public void setDate(int);
                public void setHours(int);
                public void setMinutes(int);
                public void setMonth(int);
                public void setSeconds(int);
                public void setYear(int);
                public java.lang.String toGMTString();
                public java.time.Instant toInstant();
                public java.lang.String toLocaleString();
                public static long UTC(int, int, int, int, int, int);
                public final void wait();
                public final void wait(long, int);
                public final native void wait(long);
                public final native java.lang.Class getClass();
                public final native void notify();
                public final native void notifyAll();
            }
         */
    }

    /**
     * 5.7.4 在运行时使用反射分析对象
     *
     * @see java.lang.reflect.AccessibleObject#setAccessible(boolean)
     */
    public static void useReflectAnalyseClassInRunning() throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee("daniel", 14000, 2019, 8, 26);
        Class<? extends Employee> aClass = employee.getClass();
        Field hireDay = aClass.getDeclaredField("hireDay");
        //查看反射对象的可访问标志的值
        System.out.println(hireDay.isAccessible());//false
        //反射机制的默认行为受限于Java的访问控制(private),因此设置值必须开启权限,如下：
        hireDay.setAccessible(true);//setAccessible是AccessibleObject类中的一个方法,它是Field、Method、Constructor类的公共超类。
        Object v = hireDay.get(employee);
        //查看反射对象的可访问标志的值
        System.out.println(hireDay.isAccessible());//true


        //ObjectAnalyzer将记录已经被访问过的对象
        ArrayList<Object> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));//java.util.ArrayList[elementData=class java.lang.Object[]{java.lang.Integer[value=0][][],java.lang.Integer[value=1][][],java.lang.Integer[value=4][][],java.lang.Integer[value=9][][],java.lang.Integer[value=16][][],null,null,null,null,null},size=5][modCount=5][][]
    }

    /**
     * 5.7.5 使用反射编写泛型数组代码
     * {@link java.lang.reflect.Array}允许动态地创建数组.
     * 
     */
    public static void useReflectFinishArray() {
        Employee[] a = new Employee[100];
        for (int i = 0; i < 100; i++) {
            a[i] = new Employee();
        }
        //array is full
        a = Arrays.copyOf(a, 2 * a.length);
        System.out.println(Array.getLength(a));//200

        Object[] badCopyOf = badCopyOf(a, 2 * a.length);
        System.out.println(Array.getLength(badCopyOf));//400
        a = (Employee[]) goodCopyOf(a, 2 * a.length);
        System.out.println(Array.getLength(a));//400
    }

    /**
     * 5.7.6 调用任意方法<br/>
     * 反射机制匀速你调用任意方法.
     *
     * @see Method#invoke(Object, Object...)
     */
    public static void useAnyMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee("daniel", 10000, 2020, 10, 25);
        Method getName = Employee.class.getMethod("getName");
        Method getSalary = Employee.class.getMethod("getSalary");
        Method raiseSalary = Employee.class.getMethod("raiseSalary", double.class);
        Object name = getName.invoke(employee);
        System.out.println(name);
    }

    /**
     * 数组扩展方法(不可转换)
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * 通用的数组扩展方法<br/>
     * 不仅仅只用于对象数组
     */
    @SuppressWarnings("SuspiciousSystemArraycopy")
    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> cl = a.getClass();
        //判断是否是数组
        if (!cl.isArray())
            return null;
        //获取组件类型
        Class<?> componentType = cl.getComponentType();
        //获取数组长度
        int length = Array.getLength(a);
        //创建新数组
        Object newArray = Array.newInstance(componentType, newLength);
        //正式复制
        System.arraycopy(a, 0, newArray,0, Math.min(length, newLength));
        return newArray;
    }

    /**
     * 获取并打印域
     *
     * @param aClass 类
     */
    private static void printFields(Class<?> aClass) {
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            String name = field.getName();
            System.out.print("    ");
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.length() > 0)
                System.out.print(modifier + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * 获取并打印方法
     *
     * @param aClass 类
     */
    private static void printMethods(Class<?> aClass) {
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String name = method.getName();
            System.out.print("    ");
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.length() > 0)
                System.out.print(modifier + " ");
            System.out.print(returnType.getName() + " " + name + "(");
            printParams(method);
        }
    }

    /**
     * 获取并打印构造器
     *
     * @param aClass 类
     */
    private static void printConstructors(Class<?> aClass) {
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            String name = declaredConstructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(aClass.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");
            //打印参数类型
            printParams(declaredConstructor);
        }
    }

    /**
     * 打印构造器或者方法的参数类型
     *
     * @param declared 构造器或者方法
     */
    public static void printParams(Object declared) {
        Class<?>[] paramTypes = new Class[0];
        if (declared instanceof Method) {
            paramTypes = ((Method) declared).getParameterTypes();
        }
        if (declared instanceof Constructor<?>) {
            paramTypes = ((Constructor<?>) declared).getParameterTypes();
        }
        for (int i = 0; i < paramTypes.length; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(paramTypes[i].getName());
        }
        System.out.println(");");
    }
}
