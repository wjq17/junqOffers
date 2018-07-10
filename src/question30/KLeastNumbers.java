package question30;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.LineListener;

public class KLeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int  k=4;
		int arr[]={4,5,1,6,2,7,3,8};
		int arr1[]={4,5,1,6,2,7,3,8};
        int arr2[]={4,5,1,6,2,7,3,8};
		getLeastNumbers(arr1,arr1.length,k);     //此方法为方法二
	ArrayList<Integer> list=	bubble(arr2,arr2.length,k);              // 此方法为方法三
		int kMaxHeap[]=new int[k];
		for (int i = 0; i < k; i++) {
			kMaxHeap[i]=arr[i];
		}
		
		// 建立大根堆，大根堆的元素个数为k
		for(int i=kMaxHeap.length/2-1;i>=0;--i)  
	        HeapAdjust(kMaxHeap,i,kMaxHeap.length);  
		
		// 依次跟大根堆的最大值比较，如果比最大值小，取而代之并且调整大根堆
		for (int i = k; i < arr.length; i++) {
			if (arr[i]<kMaxHeap[0]) {
				kMaxHeap[0]=arr[i];
				HeapAdjust(kMaxHeap, 0, k);
			}
		}
		Arrays.sort(kMaxHeap);
		System.out.println("以下是方法一的结果:");
		for (int i : kMaxHeap) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("以下是方法二的结果:");
		for (int i = 0; i <k; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("以下是方法三的结果:");
		System.out.println(list);
		
	}
	
	private static ArrayList<Integer> bubble(int[] arr, int length, int k) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]<arr[j+1]) {
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		ArrayList<Integer>  list=new ArrayList<Integer>();
		for (int i = arr.length-1; i>=arr.length-k; i--) {
			list.add(arr[i]);
		}
		return list;
	}

	// 方法二   利用分治法
	private static void getLeastNumbers(int[] arr, int length, int k) {
		// TODO Auto-generated method stub
		if (arr==null||arr.length==0||k<=0||k>length) {
			return;
		}
		int start=0;
		int end=length-1;
		int index=partition(arr,start,end);
		while (index!=k) {
			if (index>k) {
				end=index-1;
				index=partition(arr,start,end);
			}else {
				start=index+1;
				index=partition(arr,start,end);
			}
		}
		
		
	}


	private static int partition(int[] numbers, int left, int right) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int i=left;
		int j=right;
		int key=numbers[left];
		
		while (i<j) {
			while (i<j&&numbers[j]>=key)  j--;
			numbers[i]=numbers[j];
			while (i<j&&numbers[i]<=key)  i++;
			numbers[j]=numbers[i];
		}
		numbers[i]=key;
		return i;
	
	}

	//array是待调整的堆数组，i是待调整的数组元素的位置，nlength是数组的长度
	//本函数功能是：根据数组array构建大根堆
	private static void HeapAdjust(int[] array, int i, int nLength) {  
        // TODO Auto-generated method stub  
        int nChild;  
        int nTemp;  
        for(;2*i+1<nLength;i=nChild)  
        {  
            //子结点的位置=2*（父结点位置）+1  
            nChild=2*i+1;  
            //得到子结点中较大的结点  
            if(nChild<nLength-1&&array[nChild+1]>array[nChild])++nChild;  
            //如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点  
            if(array[i]<array[nChild])  
            {  
                nTemp=array[i];  
                array[i]=array[nChild];  
                array[nChild]=nTemp;   
            }  
            else break; //否则退出循环  
        }  
    }  
}
