package question20;

import java.util.ArrayList;

public class PrintMatrix {

	static int [][]matrix={
			{1, 2, 3,  4},
			{5, 6, 7,  8},
			{9,10,11, 12},
			{13,14,15,16}
	};

	public static void main(String[] args) {
		printMatrix(matrix);

	}
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		if (matrix==null || matrix.length==0) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		int cols,rows;
		cols=matrix[0].length;
		rows=matrix.length;

		int start=0;
		while (cols>2*start&&rows>2*start) {
			printMatrixIncircle(matrix,cols,rows,start,list);   
			start++;
		}

		System.out.println(list);

		return list;
	}
	// 打印左上角坐标为 (start,start) 的圈
	private static void printMatrixIncircle(int[][] matrix, int cols, int rows, int start, ArrayList<Integer> list) {
		int endX=cols-1-start;
		int endY=rows-1-start;
		
		// 打印第一步
		for (int i = start; i <=endX; i++) {
			list.add(matrix[start][i]);
			
		}
		
		
		if (endY>start) {  //至少有两行才可以打印第二步
			for (int i = start+1; i<=endY; i++) {
				list.add(matrix[i][endX]);
			}
		}
		
		if (endY>start&&endX>start) {//至少有两行和两列才可以打印第三步
			for (int i = endX-1; i>=start; i--) {
				list.add(matrix[endY][i]);
			}
		}
		
		if (endY>start+1&&endX>start) {//至少有三行和两列才可以打印第三步
			for (int i = endY-1; i >=start+1; i--) {
				list.add( matrix[i][start]);
			}
		}
		
		
	}

}
