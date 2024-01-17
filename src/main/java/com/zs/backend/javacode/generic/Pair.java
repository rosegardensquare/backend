package com.zs.backend.javacode.generic;

/**
 * 泛型
 * @param <T>
 */
public class Pair<T1,T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public T1 getFirst(){
        return first;
    }

    public T2 getSecond(){
        return second;
    }

}

class Test{

    public static void main(String[] args) {
        Pair<Boolean, String> stringPair = new Pair<>(true, "second");
        System.out.println(stringPair.getFirst() + "," + stringPair.getSecond());
    }
}