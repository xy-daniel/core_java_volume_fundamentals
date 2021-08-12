package com.daniel.corejava.eight;

import com.daniel.corejava.six.ArrayAlg;

/**
 * 8.1 泛型类测试
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/8
 * @see PairTwo
 * @see ArrayAlg#minmax(String[])
 */
public class TClassTest {

    public static void main(String[] args) {
        String[] words = {"daniel", "tom", "a", "little"};
        PairTwo<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
