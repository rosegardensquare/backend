package com.zs.backend.javacode.javaCollection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 算法：
 * 1.最近访问或者更新的元素会被移到链表末尾
 * 2.当缓存容量达到上限后，移除最近最少未使用的元素
 * 继承 LinkedHashMap, removeEldestEntry()
 * @param <K>
 * @param <V>
 */
public class JavaLRU<K,V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public JavaLRU(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * 当缓存容量达到上限后，移除最近最少未使用的元素
     * @param eldest
     * @return
     */
    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity;
    }

    public static void main(String[] args) {
        JavaLRU<Object, Object> javaLRU = new JavaLRU<>(3);
        javaLRU.put(1,"one");
        javaLRU.put(2,"tow");
        javaLRU.put(3,"three");
        System.out.println(javaLRU);// {1=one, 2=tow, 3=three}

        // 最近访问的会被移到链表末尾
        javaLRU.get(2);
        System.out.println(javaLRU);// {1=one, 3=three, 2=tow}

        // 当链表满了，会移除最早最久未使用的元素
        javaLRU.put(4,"four");
        System.out.println(javaLRU);// {3=three, 2=tow, 4=four}

    }

}
