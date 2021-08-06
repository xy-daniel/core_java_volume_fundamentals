package com.daniel.corejava.seven;

import java.io.IOException;

/**
 * 7.1.4 自定义异常类
 * @author daniel
 * @version v1.0
 * @date 2021/8/6
 */
public class MyException extends IOException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
