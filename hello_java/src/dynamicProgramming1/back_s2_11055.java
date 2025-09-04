package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s2_11055 {
	static int N;
	static int[] nums;
	static int[] dp;
	static int[] dp2;
	static int result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		dp = new int[N+1];
		dp2 = new int[N+1];
		String[] com1 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			nums[i+1] = Integer.parseInt(com1[i]);
		}
		
		dp[1]=1;
		dp2[1]=nums[1];
		result = dp2[1];
		for(int i=2;i<=N;i++) {
			int max = 0; //dp2 
			int idx = 0; //idx
			int c_num = nums[i];
			for(int j=i-1;j>=1;j--) {
				if (nums[j]<c_num) {
					max = Math.max(max,dp2[j]); 
					idx = j;}
			}
			if (idx==0) {
				//이때까지 내가 젤 작다.
				dp[i] = 1;
				dp2[i] = nums[i];
			}
			else {
				//앞에 나보다 작은 얘들이 있다.
				dp[i] = dp[idx]+1;
				dp2[i] = max + nums[i];
			}
			result = Math.max(result, dp2[i]);
			
		}
		
		
		System.out.println(result);
	}

}
