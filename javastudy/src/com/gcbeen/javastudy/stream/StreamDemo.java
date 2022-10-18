package com.gcbeen.javastudy.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有 5 只宠物！筛选：
 * 1、ID 必须是偶数
 * 2、年龄必须大于3岁
 * 3、宠物名转为大写字母
 * 4、宠物名字母倒着排序
 * 5、只输出一个用户！
 */
public class StreamDemo {

    public static void main(String[] args) {
        Pet u1 = new Pet(1, "a", 1);
        Pet u2 = new Pet(2, "b", 2);
        Pet u3 = new Pet(3, "c", 3);
        Pet u4 = new Pet(4, "d", 4);
        Pet u5 = new Pet(6, "e", 5);

        // 集合是存储
        List<Pet> list = Arrays.asList(u1, u2, u3, u4, u5);

        // 计算交给Stream流

        // lambda表达式、链式编程、函数式接口、Stream流式计算
        list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 3;
        }).map(u -> {
            return u.getName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);
    }

}
