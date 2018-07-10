package junq;

import java.util.ArrayList;

/**
* @Author : JunqWang
*
* @Description: 打印矩阵
*
* @Date: 10:05 2018/5/29
**/


public class printMatrix {
    public static void main(String[] args){
        int[][] inMatrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> out = printMatrix(inMatrix);
        System.out.println("希望的结果是："+"1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.");
        System.out.println(out);

        int[][] inMatrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ArrayList<Integer> out2 = printMatrix(inMatrix2);
        System.out.println("希望的结果是："+"1,2,3,4,8,12,11,10,9,5,6,7.");
        System.out.println(out2);


        int[][] inMatrix3 = {{1},{2},{3}};
        ArrayList<Integer> out3 = printMatrix(inMatrix3);
        System.out.println("希望的结果是："+"1,2,3");
        System.out.println(out3);

        int[][] inMatrix4 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        ArrayList<Integer> out4 = printMatrix(inMatrix4);
        System.out.println("希望的结果是："+"[1,2,4,6,8,10,9,7,5,3]");
        System.out.println(out4);
    }
    public static ArrayList<Integer> printMatrix(int[][] matrix){
        int length = matrix.length;   //行长度：矩阵的长
        int width = matrix[0].length; //列长度：矩阵的宽
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(matrix == null || length==0 || width==0) return null;
        if(length==1){
            for(int a1 = 0;a1<width;a1++){
                arrayList.add(matrix[0][a1]);
            }
            return arrayList;
        }
        if(width==1){
            for(int a2 = 0;a2<length;a2++){
                arrayList.add(matrix[a2][0]);
            }
            return arrayList;
        }

        //一次循环是一圈
        for(int i =0;i<length-i;i++){
            int j=i;
            if(j<width-i) {
                //一圈的上边
                for (;j<width - i; j++) {
                    arrayList.add(matrix[i][j]);
                }
                //一圈的右边
                for (int k = i + 1; k < length - i; k++) {
                    arrayList.add(matrix[k][width - 1 - i]);
                }

                int f = length - 1 - i; //下边所在的行数
                if (f != i) {
                    //一圈的下边
                    for (int m = width - 1 - i - 1; m >= i; m--) {
                        arrayList.add(matrix[f][m]);
                    }
                    //一圈的左边
                    for (int n = f - 1; n > i; n--) {
                        arrayList.add(matrix[n][i]);
                    }
                }
            }
        }

        return arrayList;
    }
}
