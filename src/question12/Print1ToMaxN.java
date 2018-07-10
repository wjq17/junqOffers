package question12;

import java.util.ArrayList;  

public class Print1ToMaxN {  
      
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int n = 2;          
  
        ArrayList<int[]> list = new ArrayList<>(); // 实质是一个二维数组  
        int answer[] = new int[n]; // answer[i] 表示 二维数组中 第 i 行所选的 列 值。 假如  
                                    // answer[1]=6,  
        // 那么就表示取二维数组 list[1][6]  
  
        int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
        for (int i = 0; i < n; i++) {  
            list.add(num); // 生成二维数组  
        }  
  
        recursive(0, n, answer, list);  
  
    }  
  
    private static void recursive(int index, int n, int[] answer, ArrayList<int[]> list) {  
        // TODO Auto-generated method stub  
        if (index == n) { // 递归结束条件  
            boolean beginWith0 = true; // 是否是0 开头  
            for (int i = 0; i < n; i++) {  
  
                if (list.get(i)[answer[i]] != 0) {  
                    beginWith0 = false;  
                }  
                if (!beginWith0) {  
                    System.out.printf("%d", list.get(i)[answer[i]]); // list.get(i)[answer[i]] 表示 list[i][j]  
                }  
  
            }  
            if (!beginWith0) {  
                System.out.println();  
  
            }  
            return;  
        }  
  
        for (answer[index] = 0; answer[index] < 10; answer[index]++) {  
            recursive(index + 1, n, answer, list); // 递归  
        }  
  
    }  
  
}  