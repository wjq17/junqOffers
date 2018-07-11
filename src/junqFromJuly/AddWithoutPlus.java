package junqFromJuly;

/**
 * @program: junqOffers
 * @description: 不用加减乘除做加法
 * @author: junQiuW
 * @create: 2018-07-10 21:34
 **/

public class AddWithoutPlus {
  public static void main(String[] args) {
    System.out.println("预期结果是3+5=8，实际结果是：");
    int result = add(3, 5);
    System.out.println(result);
  }

  public static int add(int num1, int num2) {
    while (num2 != 0) {
      int temp = num1 ^ num2;
      num2  = (num1&num2)<<1;
      num1 = temp;
    }
    return num1;
  }
}
