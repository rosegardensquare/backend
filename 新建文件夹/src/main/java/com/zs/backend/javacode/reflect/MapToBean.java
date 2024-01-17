package com.zs.backend.javacode.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean copy
 */
public class MapToBean {

    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz){
        try {
            T t = clazz.getDeclaredConstructor().newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for(Field field : declaredFields){
                Object o = map.get(field.getName());
                if(o == null){
                    continue;
                }
                field.setAccessible(true);
                field.set(t, o);
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1L);
        map.put("name", "zs");
        Student student = mapToBean(map, Student.class);
        System.out.println(student);

    }
}
