package binarySearch;
import java.io.*;
import java.util.*;
public class back_s2_2805 {
	static long N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Long> array = new ArrayList<>();
		String[] com = br.readLine().split(" ");
		N = Long.parseLong(com[0]);
		M = Long.parseLong(com[1]);
		long max = 0;
		String[] com2 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			long n = Long.parseLong(com2[i]);
			array.add(n);
			if (max < n) max = n;
		}
		
		long l = 1;
		long r = max+2;
		while(l < r) {
			long mid = (l+r)/2;
			long result = restTree(array, mid);
			//System.out.println(mid);
			if(result >= M) {
				l = mid+1;
			}else {
				r = mid;
			}
		}
		System.out.println(l-1);
		
		
	}
	
	public static long restTree(List<Long> array, long cen) {
		long rest = 0;
		for(Long ele : array) {
			if (ele > cen) rest +=(ele - cen);
		}
		return rest;
	}

}
