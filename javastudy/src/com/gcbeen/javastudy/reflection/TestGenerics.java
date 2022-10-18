package com.gcbeen.javastudy.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

// 通过反射获取泛型
public class TestGenerics {

    public void test02(Map<String, User> map, List<User> list) {
        System.out.println("test02");
    }

    public Map<String, User> test03() {
        System.out.println("Test03");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestGenerics.class.getMethod("test02", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] typeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type typeArgument : typeArguments) {
                    System.out.println(typeArgument);
                }
            }
        }

        method = TestGenerics.class.getMethod("test03", null);
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            Type[] typeArguments = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                System.out.println(typeArgument);
            }
        }

    }


}
