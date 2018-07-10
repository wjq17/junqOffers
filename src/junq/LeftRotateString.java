package junq;
/**
* @Author : JunqWang
*
* @Description: 左旋转字符串
*
* @Date: 11:37 2018/6/25
**/

public class LeftRotateString {
    public static void main(String[] args) {
        String s = "abcXYZdef";
        int n  = 3;
        s =leftRotateString(s, n);
        System.out.println("预期结果是：XYZdefabc，实际结果是："+s);
    }

    public static String leftRotateString(String str,int n) {
        if (str==null || str.length() < n) {
            return "";
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);
        return s2+s1;
    }
}
