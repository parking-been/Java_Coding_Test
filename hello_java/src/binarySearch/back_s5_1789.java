package binarySearch;
import java.io.*;
import java.util.*;
public class back_s5_1789 {
	static long N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine()); // 여기도 고쳐야함.
		long sum = 0;
		long count = 0;
		long num = 1;
		while(N >= sum) {
			sum +=num; 
			num++;
			count++;
		}
		System.out.println(num == N ? count : count-1);
	}

}
