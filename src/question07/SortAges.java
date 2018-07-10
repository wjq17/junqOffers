package question07;

public class SortAges {  
    
    static int oldAge=99;  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
        int ages[]=new int[]{5,6,8,2,3,4,1,99};  
        SortAges(ages);  
        for (int i : ages) {  
            System.out.println(i);  
        }  
          
    }  
  
    private static void SortAges(int[] ages) {  
        // TODO Auto-generated method stub  
          
        int timesOfAge[]=new int[oldAge+1];  
        int age;  
        for (int i = 0; i < ages.length; i++) {  
            age=ages[i];  
            timesOfAge[age]++;  
              
        }  
        int index=0;  
        for (int i = 0; i <=oldAge; i++) {  
            for (int j = 0; j < timesOfAge[i]; j++) {  
                  
                ages[index]=i;  
                index++;  
            }  
        }  
    }  
  
}  
