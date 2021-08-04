package com.daniel.corejava.six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 6.4.1 使用内部类访问对象状态
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/3
 */
public class TalkingClock {

    private int interval;
    private boolean beep;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public TalkingClock() {
    }

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {

        // 6.4.4 局部内部类
        // 使用场景：TimePrinterThree只在start方法中使用过一次
        // 注：局部类不能使用public或private访问说明符进行声明,他的作用域被限定在声明这个局部类的块中
        // 优势：对外部世界完全的隐藏起来
        class TimePrinterThree implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(new Date());
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        }

//        ActionListener listener = new TimePrinterTwo();
        ActionListener listener = new TimePrinterThree();
        //构造一个定时器
        Timer timer = new Timer(this.interval, listener);
        //启动定时器,调用actionPerformed
        timer.start();
    }

    /**
     * 6.4.5 不在使用对象的参数的局部内部类方法
     *
     * @param interval 时间
     * @param beep 是否响
     */
    public void startHaveParams(int interval, boolean beep) {

        class TimePrinterFour implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TimePrinterFour --- " + new Date());
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinterFour();
        Timer timer = new Timer(this.interval, listener);
        timer.start();
    }

    /**
     * 6.4.6 匿名内部类
     *
     * @param interval 时间
     * @param beep 是否响
     */
    public void startMethod(int interval, boolean beep) {

        //含义：创建一个实现ActionListener接口的类的新对象
        //语法
//        new SuperType(params) {
//            inner class methods and data
//        }
        //SuperType可以是一个接口,内部类就要实现这个接口,也可以是一个类,内部类就要对他进行拓展
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("匿名内部类 --- " + new Date());
            if (beep)
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer = new Timer(this.interval, listener);
        timer.start();
    }

    /**
     * 改进TimeTest<br/>
     * 私有的只有TalkingClock才能够构造TimePrinterTwo对象
     *
     * @see TimeTest
     * @see TimePrinter
     */
    private class TimePrinterTwo implements ActionListener {
        /**
         * 特定操作
         * @param e 提供事件的相关信息
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //打印
            System.out.println("At the tone, the time is " + new Date());
            //获得默认工具箱并响一声
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
