package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_2156 {
	static int N;
	static int[] array;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		dp = new int[N+1][2];
		
		for(int i=0;i<N;i++) {
			array[i+1] = Integer.parseInt(br.readLine());
		}
		
		int max =0;
		int result =0;
		for(int i=1; i<=N;i++) {
			
			if(i==1) {
				dp[1][0] = array[1];
				dp[1][1] = array[1];
				result = Math.max(Math.max(result, dp[i][0]),dp[i][1]);	
				continue;
			}
			
			dp[i][1] = dp[i-1][0] + array[i];
			
			if(i>2) {
				max = Math.max(Math.max(max,dp[i-2][0]),dp[i-2][1]);
				dp[i][0] = max + array[i]; 
			}
			else {//i==2
				dp[i][0] = array[i];
			}
			
			result = Math.max(Math.max(result, dp[i][0]),dp[i][1]);			
		}
		System.out.println(result);
	}

}
