package com.daniel.corejava.six;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 6.2.1 实现用于接收操作事件的侦听器接口,用于执行特定的操作
 *
 * @author daniel
 * @date 2021/08/02
 * @version v1.0
 */
public class TimePrinter implements ActionListener {

    /**
     * 特定操作
     * @param e 提供事件的相关信息
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //打印
        System.out.println("At the tone, the time is " + new Date());
        //获得默认工具箱并响一声
        Toolkit.getDefaultToolkit().beep();
    }
}
