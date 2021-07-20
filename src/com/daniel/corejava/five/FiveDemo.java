package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

import static java.lang.System.out;

/**
 * 第五章测试类
 *
 * @author daniel
 * @version 2021.07.19
 */
public class FiveDemo {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setBonus(5000);

        Manager boss = new Manager("boss", 50000, 1989, 10, 1);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        //5.1.8 自下而上的转换
        staff[0] = boss;
        staff[1] = new Employee("jack", 20000, 1989, 10, 1);
        staff[2] = new Employee("tom", 20000, 1989, 10, 1);
        for (Employee e : staff) {
            //一个对象变量能够指示多种实际类型的现象称为多态。   ******
            //在运行时能够自动选择调用哪个方法的现象称为动态绑定。******
            out.println("name=" + e.getName() + ",salary=" + e.getSalary());
            //5.1.8 在进行自上而下的强制转换之前应该使用instanceof查看是否能够转换成功.
            if (e instanceof Manager) {
                out.println(e.getName() + "是一个Manager.");
            }
            //5.1.8 如果类型不可能转换成功，编译器就不会进行这个转换，如下：
//            String stringDemo = (String) e;
            /*
                5.1.8 综上所述：
                1、只能在继承层次内进行类型转换
                2、在将超类转换成子类之前，应该使用instanceof进行检查
                3、通过类型转换调整对象的类型并不是一种友好的做法。大多数情况下并不需要将Employee转换为Manager,两个类的对象
                都能正确的调用getSalary方法，因为存在动态绑定机制。只有使用Manager中特有的方法时才需要进行类型的转换，例如setBonus方法。
                如果存在这种情况说明超类设计的并不合理，可以适当的对超类进行调整.
             */
        }

        //5.1.8 强制类型转换----在暂时忽视对方的实际类型之后，使用对象的全部功能(自上而下的转换)。
        //5.1.8 staff数组必须是Employee的数组,但是Manager也是一个Employee所以我们可以存入数组中。
        //5.1.8 因为在初始化时staff[0]就是一个Manager,因此我们可以将staff[0]复原为Manager
        Manager managerEmployee = (Manager) staff[0];
        //5.1.8 而其他的不能,Casting 'staff[1]' to 'Manager' will produce 'ClassCastException' for any non-null value
//        managerEmployee = (Manager) staff[1];


        //程序中任何出现超类的地方都可以用子类对象置换,这表明在Java程序中，对象变量是多态的。
        Employee employee;
        employee = new Employee();
        employee = new Manager();
        employee = new Executive();
        //警告：
        //在Java中，子类数组的引用可以转换成超类数组的引用，而不需要采用强制类型转换。
//        Manager[] managers = new Manager[10];
//        Employee[] employees = managers;
        //简写
        Employee employee1 = new Manager();
        Employee[] employees = new Manager[10];
        //但是要时刻牢记employees创建的出师数据类型是Manager而不是Employee，因此使用下面的语句进行复制将导致ArrayStoreException异常
        //Storing element of type 'com.daniel.corejava.four.Employee' to array of 'com.daniel.corejava.five.Manager' elements will produce 'ArrayStoreException'
        //employees[0] = new Employee();

        /*
        方法调用过程(x.f(args)：
        1.编译器查看对象的声明类型和方法名。(获得所有可能被调用的候选方法,例如f(int) f(String))
        2.编译器查看调用方法时提供的参数类型。如果在所有名为f的方法中存在一个与提供的参数类型完全匹配，就选择这个方法。
          这个过程被称为重载解析。(获得需要调用的方法名字和参数类型)
        注：方法的名字和参数列表称为方法的签名.例如f(int)/f(String)是两个具有相同名字，不同签名的方法.
        3.如果是private方法、static方法、final方法或者构造器，编译器可以准确的知道应该调用哪个犯法，我们称这种调用
          方式称为静态绑定。
        4.当程序运行，并且采用动态绑定调用方法时，虚拟机一定调用与x所引用对象的实际类型最合适的那个类的方法。
          假设x的实际类型是D，他是C的子类，D定义了方法f(String),就直接调用，否则将在D类的超类中寻找f(String)，以此类推。
          每次调用方法都需要进行搜索，时间开销相当大。因此虚拟机会为每个类创建一个方法表，其中列出了所有方法的签名和实际调用的方法。
          动态绑定是一个非常重要的特性：无需对现存的代码进行修改，就可以对程序进行拓展。
          注：在覆盖一个方法的时候，子类方法不能低于超类方法的可见性。
         */
        //5.1.9 抽象类不能被实例化。但是可以创建一个具体子类对象。
        Person studentPerson = new Student("小乙");
        out.println(studentPerson.getDescription());
        Person employeePerson = new Employee("小布丁");
        out.println(employeePerson.getDescription());

        //5.2 所有类的超类
    }
}
