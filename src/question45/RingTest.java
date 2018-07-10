package question45;

import java.util.Scanner;
/**
 *使用数组实现约瑟夫环问题
 *由m个人围成一个首尾相连的圈报数。
 *从第一个人开始，从1开始报数，报到n的人出圈，
 *剩下的人继续从1开始报数，直到所有的人都出圈为止。
 *对于给定的m和n，求出所有人的出圈顺序.
 */
public class RingTest{
	public static void main(String[] args){
		System.out.println("程序说明如下：");
		System.out.println("由m个人围成一个首尾相连的圈报数。从第一个人开始，从1开始报数，报到n的人出圈，剩下的人继续从1开始报数，直到所有的人都出圈为止。对于给定的m和n，求出所有人的出圈顺序.");

		//提示输入总人数
		System.out.println("请输入做这个游戏的总人数：");
		Scanner sca=new Scanner(System.in);
		int N=sca.nextInt();
		//提示输入要出圈的数值
		System.out.println("请输入要出圈的数值：");        
		int M=sca.nextInt();
		System.out.println("按出圈的次序输出序号：");        
		//创建有m个值的数组
		int[] a=new int[N];
		//初始长度，以后出圈一个，长度就减一
		int len=N;
		//给数组赋值
		for(int i=0;i<a.length;i++)
			a[i]=i;
		//i为元素下表，j代表当前要报的数
		int i=0;
		int j=0;
		while(len>0){
			if(a[i%N]>-1){
				j++;
				if(j==M){//找到要出圈的人，并把圈中人数减一
					System.out.print(a[i%N]+"  ");
					a[i%N]=-1;
					j=0;
					len--;
				}
			}
			i++;
		}
	}
}
