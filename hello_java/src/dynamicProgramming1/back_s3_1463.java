package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s3_1463 { // 이거 꼭 답지랑 비교해보기
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int num = (N<=2?3:N);
		dp = new int[num+1];
		
		Arrays.fill(dp, -1);
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		int result = makeOne(N);
		System.out.println(result);

	}
	
	public static int makeOne(int n) {
		if (dp[n]!=-1) return dp[n];
		
		int result = makeOne(n-1);
		if (n%3==0) {
			int tmp = makeOne(n/3);
			if(result > tmp) {
				result = tmp;
			}
		}
		if (n%2==0) {
			int tmp = makeOne(n/2);
			if(result> tmp) {
				result = tmp;
			}
		}
		
		
		dp[n] = result+1;
		return result+1;
	}
	
	

}
