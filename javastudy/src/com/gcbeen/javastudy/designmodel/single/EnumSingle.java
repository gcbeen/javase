package com.gcbeen.javastudy.designmodel.single;

import java.lang.reflect.Constructor;

public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}


class Test {
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        System.out.println(instance1);

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        // java.lang.NoSuchMethodException: com...single.EnumSingle.<init>() 没有空参构造方法
        EnumSingle instance2 = declaredConstructor.newInstance();
        System.out.println(instance2);
    }
}
