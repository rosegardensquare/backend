package com.zs.backend.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final int DEFAULT_SEED = 65535;
    private static final String DEFAULT_CODE = "0123456789";

    /**
     * 生成随机数 (全部为正数)
     *
     * @param length 生成随机数位数
     * @param bound  边界
     * @return 返回随机数
     * @see #getRandomString(int)
     * @see #getRandomString(int, String)
     */
    @Deprecated
    public static String randomAuthCode(int length, Integer bound) {
        assert length > 0;
        StringBuilder result = new StringBuilder();
        if (bound == null) {
            bound = DEFAULT_SEED;
        }
        for (int i = 0; i < length; i++) {
            result.append(Math.abs(randomNum(bound)) % 10);
        }
        return result.toString();
    }

    /**
     * 获取随机数
     *
     * @param bound 边界
     * @return 返回随机数
     */
    public static int randomNum(Integer bound) {
        if (bound == null) {
            bound = DEFAULT_SEED;
        }
        return Math.abs(ThreadLocalRandom.current().nextInt(bound));
    }

    /**
     * 获取随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 返回随机数
     */
    public static int randomNum(int min, int max) {
        ThreadLocalRandom.current().nextInt(min, max);
        return Math.abs(ThreadLocalRandom.current().nextInt(min, max));
    }

    /**
     * 生成字符和数据的随机字符串
     *
     * @param length     位数
     * @param sourceCode 生成
     * @return
     */
    public static String getRandomString(int length, String sourceCode) {

        sourceCode = DEFAULT_CODE;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(sourceCode.charAt(random.nextInt(sourceCode.length())));
        }
        return sb.toString();
    }

    /**
     * 生成数据的随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        return getRandomString(length, DEFAULT_CODE);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            createpwd();
        }
    }

    private static void createUsername() {
        int fixedIndex = randomNum(8);
        char[] chars = "abcdefghjkmnopqrstuvwxyz".toCharArray();
        char[] username = new char[8];
        username[fixedIndex] = '_';
        for (int x = 0; x < 8; ++x) {
            if (x != fixedIndex) {
                username[x] = chars[randomNum(chars.length)];
            }
        }
        String name = String.valueOf(username);
        System.out.println(name);
    }

    private static void createpwd() {
        int engLen = randomNum(8 / 2, 8 / 2 + 3);
        char[] englishChar = "abcdefghjkmnpqrstuvwxyz".toCharArray();
        StringBuilder engBuilder = new StringBuilder();
        for (int x = 0; x < engLen; ++x) {
            engBuilder.append(englishChar[randomNum(englishChar.length)]);
        }
        char[] specialChar = "@%#".toCharArray();
        StringBuilder speBuilder = new StringBuilder();
        speBuilder.append(specialChar[randomNum(specialChar.length)]);

        char[] numChar = "23456789".toCharArray();
        StringBuilder numBuilder = new StringBuilder();
        for (int x = 0; x < 8 - 1 - engLen; ++x) {
            numBuilder.append(numChar[randomNum(numChar.length)]);
        }
        List<String> lists=new ArrayList<>(3);
        lists.add(numBuilder.toString());
        lists.add(speBuilder.toString());
        lists.add(engBuilder.toString());
        Collections.shuffle(lists);

        StringBuilder pwd= new StringBuilder();
        for (String list : lists) {
            pwd.append(list);
        }
        System.out.println(pwd);
    }

}
