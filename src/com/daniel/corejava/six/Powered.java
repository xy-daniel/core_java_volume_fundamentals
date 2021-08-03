package com.daniel.corejava.six;

/**
 * 接口扩展并声明常量
 *
 * @author daniel
 * @version 20210731
 * @see javax.swing.SwingConstants
 */
public interface Powered extends Moveable {

    double SPEED_LIMIT = 95;

    @Override
    void move(double x, double y);

    double milesPerGallon();
}
