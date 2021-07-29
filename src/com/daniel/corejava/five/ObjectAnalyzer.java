package com.daniel.corejava.five;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 5.7.4 记录已经被访问过的对象
 *
 * @author daniel
 * @version 2021.07.23
 */
public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null)
            return "null";
        if (visited.contains(obj))
            return "...";
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class)
            return (String) obj;
        if (cl.isArray()) {
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    r.append(",");
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive())
                    r.append(val);
                else
                    r.append(toString(val));
            }
            return r+"}";
        }

        StringBuilder r = new StringBuilder(cl.getName());
        do {
            r.append("[");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())){
                    if (!r.toString().endsWith("["))
                        r.append(",");
                    r.append(field.getName()).append("=");

                    try {
                        Class<?> t = field.getType();
                        Object val = field.get(obj);
                        if (t.isPrimitive())
                            r.append(val);
                        else
                            r.append(toString(val));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
            r.append("]");
            cl = cl.getSuperclass();
        } while (cl != null);
        return r.toString();
    }
}
