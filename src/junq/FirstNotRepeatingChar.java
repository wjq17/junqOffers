package junq;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
* @Author : JunqWang
*
* @Description: 第一个只出现一次的字符（在一个字符串中找到第一个只出现一次的字符，并返回它的位置）
*
* @Date: 15:21 2018/6/19
**/

public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        int result = firstNotRepeatingChar(in);
        System.out.println(result);
    }

    private static int firstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        if(str.length()==1) return 0;
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (hashMap.containsKey(item)) {
                hashMap.put(item, hashMap.get(item) + 1);
            } else {
                hashMap.put(item, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue()==1)
                return str.indexOf(entry.getKey());
        }
        return 0;
    }

}
