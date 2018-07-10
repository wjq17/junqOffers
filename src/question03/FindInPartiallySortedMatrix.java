package question03;

public class FindInPartiallySortedMatrix {  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int row=4,col=4,target=9;  
          
        int a[][]={{1,2,8,9},  
                   {2,4,9,12},  
                   {4,7,10,13},  
                   {6,8,11,15}};  
          
        System.out.println(getResult(a, row , col,target));  
          
    }  
  
    private static boolean getResult(int[][] a, int row, int col,int target) {  
        // TODO Auto-generated method stub  
        if (a==null||a.length==0||col<1||row<1) {  
            return false;  
        }  
        int x = 0, y = col-1;  
        while (y>=0&&x<row) {  
            if (a[x][y] == target) {  
                return true;  
            } else if (a[x][y] > target) {  
                y--;  
            } else {  
                x++;  
            }  
  
        }  
                
                
              return false;  
    }  
      
    
}  