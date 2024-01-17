package com.zs.backend.javacode.reflect;

import java.lang.reflect.Field;

/**
 * 克隆 bean
 */
public class CloneBean {

    public static <T> T clone(T source, Class<T> targetClazz){

        try {
            // 创建对象实例
            T target = targetClazz.getDeclaredConstructor().newInstance();
            // 获取源对象的所有方法
            Field[] allFields = targetClazz.getDeclaredFields();
            for(Field field : allFields){
                field.setAccessible(true);
                // 获取当前字段的值
                Object fieldValue = field.get(source);
                field.set(target, fieldValue);
            }
            return target;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setId(1l);
        student1.setName("zs");
        Student student = clone(student1, Student.class);
        System.out.println(student);
    }

}
