package binarySearch;
import java.io.*;
import java.util.*;
public class back_g5_3079 {
	static int N;
	static long M;
	static long[] T;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Long.parseLong(com[1]);
		T = new long[N];
		long max = 0;
		for(int i=0;i<N;i++) {
			T[i] = Integer.parseInt(br.readLine());
			if(max < T[i]) max = T[i];
		}
		long l = 1;
		long r = max*M; // 총걸리는 시간 구하기
		
		while(l<r) {
			long mid = (l+r)/2;
			if(count(mid)) {
				r = mid;
			}
			else l = mid+1;
		}
		System.out.println(l);
		
		
	}
	public static boolean count(long mid) {
		long count = 0;
		
		for(long ele : T) {
			count += (mid/ele);
			if(count >=M) return true; //오버플로우 방지 
		}
		return false;
		
	}

}
