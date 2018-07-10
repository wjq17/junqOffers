package question12;

import java.util.ArrayList;  

public class numberToPhone1 {  
  
    public static void main(String[] args) {  
        // int num[] = { 0, 1 };  
        int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
        int n = 3;  
        ArrayList<int[]> list = new ArrayList<>(); // 实质是一个二维数组  
        int answer[] = new int[n]; // answer[i] 表示 二维数组list 中 第 i 行所选的 列 值。  
          
          
        for (int i = 0; i < n; i++) {  
            list.add(num); // 生成二维数组  
        }  
  
        while (true) {  
            // n为电话号码的长度  
            boolean beginWith0 = true; // 是否是0 开头  
            for (int i = 0; i < n; i++) {  
                if (list.get(i)[answer[i]] != 0) {  
                    beginWith0 = false;  
                }  
                if (!beginWith0) {  
                    System.out.printf("%d", list.get(i)[answer[i]]);  // list.get(i)[answer[i] 表示 list[i][j]  
                }  
  
            }  
            if (!beginWith0) {  
                System.out.printf("\n");  
            }  
  
            int k = n - 1;  
            while (k >= 0) {  
                if (answer[k] < num.length - 1) {  
                    answer[k]++;  
                    break;  
                } else {                   // 进位  
                    answer[k] = 0;  
                    k--;  
                }  
            }  
            if (k < 0)  
                break;  
        }  
  
    }  
  
}  