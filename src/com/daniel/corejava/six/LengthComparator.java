package com.daniel.corejava.six;

import java.util.Comparator;

/**
 * 6.2.2 自定义比较器
 *
 * @author daniel
 * @version v1.0
 * @date 2021/8/2
 */
public class LengthComparator implements Comparator<String> {

    public int compare(String first, String second) {
        return first.length() - second.length();
    }

}
