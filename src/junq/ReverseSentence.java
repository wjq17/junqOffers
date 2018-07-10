package junq;
/**
* @Author : JunqWang
*
* @Description: 翻转单词顺序列
*
* @Date: 15:58 2018/6/25
**/
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "I am a student.";
        String re = reverseSentence(str);
        System.out.println("预期结果是：“student. a am I”，实际结果是："+re);


        String re1 = reverseSentence2(str);
        System.out.println("二、预期结果是：“student. a am I”，实际结果是："+re1);
    }

    public static String reverseSentence(String str) {
        String result = new String();
        if (str == null || str.length() == 0) {
            return result;
        }
        if (str == " ") {
            return str;
        }
        String[] strarray = str.split(" ");
        for(int i =strarray.length-1;i>0;i--) {
            result += strarray[i] + " ";
        }
        result += strarray[0];
        return result;
    }

    /*思路二：先旋转每个单词，再旋转整个字符串*/
    public static String reverseSentence2(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (i <= len) {
            //翻转每个单词
            if (j == len || chars[i] == ' ') {
                reverse(chars, i, j - 1);
                i=j+1;
            }
            j++;
        }
        reverse(chars, 0, len - 1); //再翻转整个字符串
        return new String(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char a = chars[i];
        chars[i] = chars[j];
        chars[j] = a;
    }
}
