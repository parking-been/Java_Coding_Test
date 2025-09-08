package Greedy;
import java.io.*;
import java.util.*;
public class back_s3_20300 {
	static int N;
	static long[] array;
	static long one;
	static int N_t;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new long[N];
		String[] com1 = br.readLine().split(" ");
		//System.out.println(Long.MAX_VALUE);
		for(int i=0;i<N;i++) {
			array[i] = Long.parseLong(com1[i]);
		}
		Arrays.sort(array);
		N_t = N;
		one = 0;
		if (N%2==1) {
			one = array[N-1];
			N_t=N-1;
			}
		long max = 0;
		for(int i=0;i<(N_t/2);i++) {
			max = Math.max(max, array[i] + array[N_t-1-i]);
		}
		
		max = Math.max(max,one);
		System.out.println(max);
		
	}

}
