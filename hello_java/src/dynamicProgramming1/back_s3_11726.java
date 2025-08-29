package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s3_11726 {
	static int N;
	static int dp[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp,-1);
		//dynamic programming 시, 앞부분에서 에러안나게 하기.
		if (N==1) {
			System.out.println(1);
			return;
		}
		dp[1]=1;
		dp[2]=2;
		int result = tile(N);
		System.out.println(result);
	}
	public static int tile(int n) {
		if (dp[n]!=-1) return dp[n];
		
		int result = tile(n-1) + tile(n-2);
		dp[n] = (result%10007);
		return (result%10007);
	}

}
