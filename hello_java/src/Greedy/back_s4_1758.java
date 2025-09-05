package Greedy;
import java.io.*;
import java.util.*;
public class back_s4_1758 {
	static int N;
	static Integer[] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new Integer[N];
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array, Collections.reverseOrder()); //그냥 int는 안된다. 
		long sum = 0;
		for(int i=0;i<N;i++) {
			int n = (array[i] -((i+1)-1));
			sum +=(n>0?n:0);
		}
		
		
		
//		for(int ele : array) {
//			System.out.print(ele + " ");
//		}
		System.out.println(sum);
	}

}
