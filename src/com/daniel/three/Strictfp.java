package com.daniel.three;

/**
 * @author daniel
 */
public class Strictfp {

    /**
     * 使用strictfp标记的方法必须使用严格的浮点计算来生成可再生的结果
     * 基本不会使用，不进行金融计算这个指令没用
     * @param args 参数
     */
    public static strictfp void main(String[] args) {
        double paperWidth = 8.5212345615645615641651564156415641859641532156161561651586462156416586416546584165;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters:" + paperWidth * paperHeight);
    }
}
