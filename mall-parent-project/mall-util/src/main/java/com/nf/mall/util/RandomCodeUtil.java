package com.nf.mall.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: LJP
 * @Classname RandomCodeUtil
 * @Date: 2019-12-03 23:20
 * @Description:
 */
public final class RandomCodeUtil {
    private static final char[] CHARS = new char[]{
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };
    private RandomCodeUtil() {
    }
    public static String randomGenerate(int length) {
        List<String> list = new ArrayList<String>(CHARS.length);
        for (int i = 0; i < CHARS.length; i++) {
            list.add(String.valueOf(CHARS[i]));
        }
        Collections.shuffle(list);
        int count = 0;
        StringBuffer sb = new StringBuffer();
        Random random = new Random(System.nanoTime());
        while (count < length) {
            int i = random.nextInt(list.size());
            sb.append(list.get(i));
            count++;
        }
        return sb.toString();
    }
}
