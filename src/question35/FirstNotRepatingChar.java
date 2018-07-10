package question35;

public class FirstNotRepatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="google";
	   
	int   index=	firstNotRepatingChar(str);
	   System.out.println(index);
	}

	private static int firstNotRepatingChar(String str) {
		// TODO Auto-generated method stub
		char temp=0;
		char arr[]=str.toCharArray();
		int tab[]=new int[256];
		for (int i = 0; i < arr.length; i++) {
			tab[arr[i]]++;
		}
		
	
		for (int i = 0; i < arr.length; i++) {
			if (tab[arr[i]]==1) {
				return i;
			}
		}
		return 0;
	}

}
