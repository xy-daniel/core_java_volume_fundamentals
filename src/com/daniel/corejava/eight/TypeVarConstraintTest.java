package com.daniel.corejava.eight;

import com.daniel.corejava.six.ArrayAlg;

/**
 * 8.3 类型变量约束测试
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/8
 */
public class TypeVarConstraintTest {

    public static void main(String[] args) {
        String min = ArrayAlg.min(new String[]{"daniel", "tom", "daniel"});
        System.out.println("min = " + min);

        PairTwo<String> stringPairTwo = ArrayAlg.minmax(new String[]{"daniel", "tom", "daniel"});
        System.out.println("min = " + stringPairTwo.getFirst());
        System.out.println("max = " + stringPairTwo.getSecond());
    }

}
