package question42;

public class ReverseWordsInSentence {
	 public static String ReverseSentence(String str) {
	        if(str == null){ return null;}
	         if(str.trim().equals("")){
	            return str;
	        }
	        String string = str;
	        String[] strings = string.split(" ");
	        StringBuilder sBuilder = new StringBuilder();
	        for (int i = strings.length-1 ; i>=0;i--) {
	            if(i == 0){
	                sBuilder.append(strings[i]);
	            }else {
	                sBuilder.append(strings[i]);
	                sBuilder.append(" ");
	            }  
	        }
	     
	        String string2 = sBuilder.toString();
	        return string2;
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input="I am liu shu xiu";
	
		String a[]=input.split(" ");
		
		for (int i = 0,j=a.length-1; i <j; i++,j--) {
			String t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
		String output="";
		for (int i = 0; i < a.length; i++) {
			if (i==a.length-1) {
				output=output+a[i];
			}else {
				output=output+a[i]+" ";
			}
			
		}
		System.out.println(output);
		String res=ReverseSentence(input);
		System.out.println(res);
	}


	private static String doit(String string) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder(string );
		
		return sb.reverse().toString();
	}

	

	

}
