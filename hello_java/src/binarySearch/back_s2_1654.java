package binarySearch;
import java.io.*;
import java.util.*;
public class back_s2_1654 {
	static long K,N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] com = br.readLine().split(" ");
		K = Long.parseLong(com[0]);
		N = Long.parseLong(com[1]);
		List<Long> array = new ArrayList<>();
		long max = 0;
		for(int i=0;i<K;i++) {
			long n = Long.parseLong(br.readLine());
			array.add(n);
			if (n>max) max = n;
			
		}
		
		long l = 1;
		long r = max+2;
		long ans=0;
		//int result = count(array, 200);
		//System.out.println(result);
//		
		
		while(l<r) {
			long m = (l+r)/2;
			long result = count(array, m);
			//System.out.println(result);
			if (result < N) {
				
				r = m;
			}
			else {
				
				l = m+1;
			}
		}
		System.out.println(l-1);
		
	}
	public static long count(List<Long> array, long length) {
		long count = 0;
		for(long ele : array) {
			count += (ele/length);
		}
		return count;
		
	}

}
