package question40;

public class NumbersAppearOnce {
	public  static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

		int xor=0;
		for (int i : array) {
			xor=xor^i;
		}
		
		int flag=1;
		while ((flag&xor)==0) {
			flag=flag<<1;
		}
		num1[0]=num2[0]=0;
		for (int i : array) {
			if ((i&flag)==0) {
				num1[0]=num1[0]^i;
			}else {
				num2[0]=num2[0]^i;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int array[]={2,4,3,6,3,2,5,5};
          int num1[]=new int[1];
          int num2[]=new int [1];
          FindNumsAppearOnce(array, num1, num2);
          System.out.println(num1[0]+" "+num2[0]);
	}

}
