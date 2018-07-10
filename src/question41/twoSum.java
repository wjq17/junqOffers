package question41;

import java.util.HashMap;
public class twoSum {
	public static void main(String[] args) {
		int numbers[]={1,2,4,7,8,11,15};
		int a[]=twoSum(numbers, 15);
		for (int i : a) {
			System.out.println(numbers[i-1]);
		}
	}
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        //map里面放 键为target-每个数的结果 值为下标
        //每次放入的时候看是否包含 当前值
        //有的话说明当前值和已包含的值下标的那个元素为需要的结果
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
			if (map.containsKey(numbers[i])) {
				result[0]=1+map.get(numbers[i]);
				result[1]=i+1;
			}else {
				map.put(target-numbers[i], i);
			}
		}
        return result;
    }
}
