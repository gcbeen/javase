package com.gcbeen.javastudy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
public class TestCustomAnnotation {

    // 注解可以显示赋值,如果没有默认值,就必须给注解赋值
    @MyAnnotation2(name = "王五")
    public void test() {
        
    }

    @MyAnnotion3("gcbeen")
    public void test2() {

    }

    public static void main(String[] args) {
        TestCustomAnnotation testCustomAnnotation = new TestCustomAnnotation();
        testCustomAnnotation.test();
        testCustomAnnotation.test2();
    }

}


@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数: 参数类型 + 参数名()
    // String name();
    String name() default "";

    int age() default 0;

    int id() default -1; // -1代表不存在

    String[] schools() default {"暑假好长", "不想实习"};
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotion3 {
    String value();
}