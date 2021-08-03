package com.daniel.corejava.six;

import java.util.function.Predicate;

/**
 * 6.3.3 函数式编程<br/>实现过滤器接口用于比较lambda表达式
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/2
 */
public class PredicateAction implements Predicate<Object> {
    @Override
    public boolean test(Object o) {
        return o == null;
    }
}
