package com.gcbeen.javastudy.annotation;

import java.lang.annotation.*;

// 测试元注解
public class TestAnnotation {

    @MyAnnotation
    public void test() {
        System.out.println("TestAnnotation");
    }

    public static void main(String[] args) {

        new TestAnnotation().test();
    }

}

// 定义一个注解
/*Target 注解可以用在什么地方ElementType.METHOD 方法上有效  ElementType.TYPE类上有效 */
@Target(value = ElementType.METHOD)

/*@Retention 在什么地方有效RUNTIME > CLASS > SOURCES */
@Retention(value = RetentionPolicy.RUNTIME)

// @Documented 表示是否将我们的注解生成在Javadoc中
@Documented

// @Inherited 子类可以继承父类的注解
@Inherited

@interface MyAnnotation {

}


