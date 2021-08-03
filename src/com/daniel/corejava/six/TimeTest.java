package com.daniel.corejava.six;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 6.2.1 回调定时器
 *
 * @author daniel
 * @version 20210802
 */
public class TimeTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        //构造一个定时器
        Timer timer = new Timer(10000, listener);
        //启动定时器,调用actionPerformed
        timer.start();
        //显示一个包含一条消息和OK按钮的对话框。
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
