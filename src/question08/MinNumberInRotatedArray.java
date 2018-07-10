package question08;

public class MinNumberInRotatedArray {  
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int array[]={4,5,1,2,3};  
        //int array[]={1,0,1,1,1};  
        //int array[]={1,1,1,0,1};  
        int min=minNumberInRotateArray(array);  
        System.out.println(min);  
    }  
  
    private static  int minNumberInRotateArray(int[] array) {  
        if (array==null||array.length==0) {  
            return -1;  
        }  
        int i=0;   //i指针指向左边递增的数组  
        int j=array.length-1;   // j 指向 右边递增的数组  
        int mid=0;  
  
        while (i<j) {  
  
            if (j-1==i) {  // 边缘情况，右边那个就是最小数  
                mid=j;  
                break;  
            }  
            mid=(i-j)/2+j;  
            if (array[i]==array[j]&&array[mid]==array[i]) {    // 针对这两种特殊情况 int array[]={1,0,1,1,1}; //int array[]={1,1,1,0,1};  
                return minInorder(array,i,j);  
            }  
  
            if (array[mid]>=array[i]) {  
                i=mid;  
            }else {  
                j=mid;  
            }  
        }  
  
        return array[mid];  
  
    }  
  
    private static int minInorder(int[] array, int i, int j) {  
        // TODO Auto-generated method stub  
        for (int k = i; k < j; k++) {  
            if ((array[k+1]-array[k])<0) {  
                return array[k+1];  
            }  
        }  
        return -1;  
    }  
  
}  