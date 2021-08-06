package com.daniel.corejava.six;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 6.5.2 如何使用代理
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/4
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length -1)
                    System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
