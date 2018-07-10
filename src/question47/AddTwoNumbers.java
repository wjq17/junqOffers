package question47;

public class AddTwoNumbers {
	static int Add(int num1,int num2){
		int sum,carry;
		do {
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
			
		} while (num2!=0);
		return num1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=Add(5, 19);

		System.out.println(res);
		System.out.println("善哉!善哉!大地众生皆具如来智慧德相,但因妄想执着而不能证得,只要恢复了自己本有的清净自性,一切众生皆可成佛!");
		System.out.println("南无阿弥陀佛!");
		System.out.println("南无本师释迦牟尼佛!");
	}

}
