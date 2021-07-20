package com.daniel.corejava.five;

import com.daniel.corejava.four.Employee;

/**
 * 继承层次：<br/>
 * 继承并<strong>不仅限于</strong>一个层次。<br/>
 * 由一个公共超类派生出来的所有类的集合称为<strong>继承层次</strong>。<br/>
 * 在继承层次中，从某个特定的类到其祖先的路径称为该类的<strong>继承链</strong>。<br/>
 * 有一个用来判断是否应该设计为继承关系的简单规则就是"is-a"<strong>置换法则</strong>规则，它表明子类的每个对象也是超类的对象.<br/>
 * 阻止继承：<br/>
 * final类(参考{@link Executive})和方法(参考{@link Employee#getName()})：<br/>
 * 注：域也可以声明为final,构造对象之后就不允许改变他们的值，如果一个类声明为final，其中的方法自动的被final修饰,但是不包括域.
 *
 * @author daniel
 * @version 2021.07.20
 */
public final class Executive extends Manager {
}
