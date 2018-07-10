package question10;

/*二进制中1的个数*/

public class NumOf1 {
    /* 预定义的结果表 */
    static int countTable[] = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3,
            4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1,
            2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3,
            4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2,
            3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4,
            5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3,
            4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5,
            6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8 };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        byte v = (byte) 254;

        System.out.println(count3(v));
    }

    // 解法一         时间复杂度为O(M) M为1的个数
    private static int count1(byte v) {
        // TODO Auto-generated method stub
        int num = 0;
        while (v != 0) {
            v = (byte) (v & (v - 1));
            num++;
        }
        return num;
    }
    //

    // 解法2    时间复杂度为O(M) M为二进制的位数，此处为8
    private static int count2(byte v) {
        // TODO Auto-generated method stub
        int num = 0;
        int flag = 1;
        while (flag != 0) {
            if ((v & flag) != 0) {
                num++;

            }
            flag <<= 1;
        }
        return num;
    }

    // 解法3  空间换时间，时间复杂度为O(1)
    private static int count3(byte v) {
    //java 中的byte范围是-128~127 ，负数加256转成整数
        int a = v > 0 ? v : v + 256; 

        return countTable[a];
    }

}
