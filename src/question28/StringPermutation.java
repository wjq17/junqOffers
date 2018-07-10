package question28;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
static	ArrayList<String> list=new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           String str="abc";
           char pStr[]=str.toCharArray();  
          Permutation(pStr);
          System.out.println(list);
         
	}
	 static ArrayList<String> Permutation(char[] pStr) {
		if (pStr==null||pStr.length==0) {
			return list;
		}
		Permutation(pStr,0);
		return list;
	}
	 static void Permutation(char[] pStr,int index) {  //index 代表待处理的字符数组的开始位置
		// TODO Auto-generated method stub
		
		if (index==pStr.length-1) {  
			StringBuffer sb=new StringBuffer();
			for (char c : pStr) {
				
				sb.append(String.valueOf(c));
				
			}
			if (!list.contains(sb.toString())) {  // 防止加入重复的 例如输入字符串"aa" ,只需要输出["aa"],而不是["aa","aa"]
				 list.add(sb.toString());
			}
		 
		}else {
			
			
			for (int i=index; i<pStr.length; i++) {
			// 交换
				char temp=pStr[index];
				pStr[index]=pStr[i];
				pStr[i]=temp;
				
				Permutation(pStr, index+1);  
				
			// 交换回来	
				temp=pStr[index];
				pStr[index]=pStr[i];
				pStr[i]=temp;
				
				
				
			}
		}
	}
	
	
}
