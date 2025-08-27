package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s4_2839 {
	static int N;
	static int[] dp = new int[5001]; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arrays.fill(dp,-2);
		dp[0] = 5000;
		dp[1] = 5000;
		dp[2] = 5000;
		dp[3] = 1;
		dp[4] = 5000;
		dp[5] = 1;
		
		int result = countBag(N);
		System.out.println(result==5000?-1:result);
		
		
	}
	public static int countBag(int n) {
		if(dp[n]!=-2) {
			return dp[n];
		}
		int p1 = dp[n-3];
		int p2 = dp[n-5];
		int result = Math.min((p1==-2?countBag(n-3):p1), (p2==-2?countBag(n-5):p2))+1;
		if (p1==5000 && p2==5000) {
			dp[n] = 5000;
			return 5000;
		}
		else {
			dp[n] = result;
			return result;
		}
	}

}
