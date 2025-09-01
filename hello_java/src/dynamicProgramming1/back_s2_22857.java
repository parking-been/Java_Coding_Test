package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s2_22857 {
	static int N, K;
	static int[] nums;
	static int[][] dp;
	static int max=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com1 = br.readLine().split(" ");
		N = Integer.parseInt(com1[0]);
		K = Integer.parseInt(com1[1]);
		
		String[] com2 = br.readLine().split(" ");
		nums = new int[N+1];
		dp = new int[N+1][K+1];
		for(int i=0;i<N;i++) {
			nums[i+1] = Integer.parseInt(com2[i]);
			
		}
		
		for(int i=0;i<K;i++) {
			dp[0][i+1]=0;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=K;j++) {
				int result=0;
				if(nums[i]%2==0) {//Â¦¼öÀÌ¸é
					result = dp[i-1][j] +1; 
				}
				else {//È¦¼ö ÀÌ¸é
					if(j==0) result=0;
					else {
						result = dp[i-1][j-1];
					}
				}
				dp[i][j] = result;
				max = Math.max(result, max);
			}
		}
		
		System.out.println(max);
//		for(int[] ele : dp) {
//			for(int e : ele) System.out.print(e + " ");
//			System.out.println();
//		}
		
	}
	

}
