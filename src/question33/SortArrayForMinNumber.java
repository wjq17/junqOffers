package question33;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortArrayForMinNumber {
	public static void main(String[] args) {
		int arr[]={3,32,321};
		int arr1[]={3,32,321};
	
		System.out.println("方法一");
		String res=PrintMinNumber(arr);
		System.out.println(res);
		
		// 方法二  
		String res2=PrintMinNumber2(arr1);
		System.out.println("方法二");
		System.out.println(res);
		
	}
	public static String PrintMinNumber2(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();
        n=numbers.length;
         
        for(int i=0;i<n;i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){
         
            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub         
                    String s1=str1+""+str2;
                    String s2=str2+""+str1;
                     
                    return s1.compareTo(s2);
                }
            });
         
        for(int j:list){
            s+=j;
        }
        return s;
    }
	public static String PrintMinNumber(int [] numbers) {
		String res="";
		ArrayList<String> minNumber=new ArrayList<String>();
		for (int i : numbers) {
			minNumber.add(String.valueOf(i));
		}
		Collections.sort(minNumber, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				int len1 = a.length();
				int len2 = b.length();
				int lim = Math.min(len1, len2);
				char v1[] = a.toCharArray();
				char v2[] = b.toCharArray();

				int k = 0;
				while (k < lim) {
					char c1 = v1[k];
					char c2 = v2[k];
					if (c1 != c2) {
						return c1 - c2;
					}
					k++;
				}

				if (len1>lim) {
					return	compare(a.substring(lim), b);
				}else if (len2>lim) {
					
				
					return	compare(a,b.substring(lim));
				}else {
					return len1 - len2;
				}




				
			}
		});

		//System.out.println(minNumber);
		StringBuilder sb=new StringBuilder();
		for (String i : minNumber) {
			sb.append(i);
		}
		return sb.toString();
	}
}