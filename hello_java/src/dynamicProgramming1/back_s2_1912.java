package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s2_1912 {
	static int N;
	static int[] array;
	static Integer[] dp; // i번째 원소를 반드시 포함하는 연속 부분 최대값.
	static int max_I=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		dp = new Integer[N+1];
		String[] com = br.readLine().split(" ");
		
		for(int i=1;i<N+1;i++) {
			array[i] = Integer.parseInt(com[i-1]);	
		}
		Arrays.fill(dp,null);
		dp[1] = array[1];
		max_I = dp[1];
		conti(N);
		System.out.println(max_I);
	}
	public static int conti(int n) {
		if(dp[n]!=null) return dp[n];
		int result = Math.max(conti(n-1)+array[n], array[n]);
		max_I = Math.max(result, max_I);
		
		return result;
	}

}
