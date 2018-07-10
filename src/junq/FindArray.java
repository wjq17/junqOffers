package junq;

/**
 * @Author : JunqWang
 * @Description: 二维数组中的查找
 * @Date: 16:25 2018/5/30
 **/

public class FindArray {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean result = Find(7, array);
        System.out.println("true：====" + result);
        boolean result2 = Find2(7,array);
        System.out.println("这里应该是true：===="+result2);
    }

    /*更优的解法: 比较右上角*/
    private static boolean Find2(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length==0) return false; //二维数组的判空
        int length = array[0].length; //列数
        int width = array.length;//行数
        for(int i =0;i<width;i++){
            if(target<=array[i][length-1]){
               for(int j=0;j<length;j++){
                   if(target==array[i][j]) return true;
               }
            }
        }
        return false;
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length==0) return false; //二维数组的判空
        int length = array[0].length; //列数
        int width = array.length;//行数
        if (target < array[0][0] || target > array[width - 1][length - 1]) return false;
        for (int i = 0; i < width; i++) {
            if (target < array[i][0]) continue;
            for (int j = 0; j < length; j++) {
                boolean result = (target == array[i][j]) ? true : false;
                if (result)
                    return true;
            }
        }
        return false;
    }
}
