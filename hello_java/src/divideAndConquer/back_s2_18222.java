package divideAndConquer;
import java.io.*;
import java.util.*;

public class back_s2_18222 {
	static long K;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Long.parseLong(br.readLine());
		long result = find(K);
		System.out.println(result);
	}
	
	static int find(long n) {
		if (n==1) return 0;
		//정수부분 소수부분 뭐 해ㅑㅇ하나?
		long depth = (long)(Math.log(n)/Math.log(2));
		double temp = Math.pow(2,depth);
		long minus;
		if (temp <n) {
			minus = (long)temp;
		}else 
			{minus = (long) Math.pow(2,depth-1);}
		
		
		return 1-find(n-minus);
	}
}
