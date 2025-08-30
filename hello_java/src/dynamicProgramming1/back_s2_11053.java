package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s2_11053 {
	static int N;
	static int[] array;
	static int[] dp;
	static int max=1;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp , -1);
		String[] com1 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			array[i+1] = Integer.parseInt(com1[i]); 
		}
		dp[1]=1;
		//모든 case에 대해 다 돌려야함.
		//top down 방식
		for(int i=1;i<=N;i++) {
			fLength(i);
		}
		
		System.out.println(max);
		
	}
	public static int fLength(int n) {
		if (dp[n]!=-1)return dp[n];
		int flag = 0;
		int result =-1;
		int c_max=0;
		for(int i=1;i<n;i++) {
			int tmp = array[n-i];
			if(tmp<array[n]) {
				// 증가 함.  // 아닐 경우 계속 돌리기
				flag = 1;
				result = fLength(n-i) ;
				c_max = Math.max(c_max,result);
			}
		}
		if (flag==0) dp[n]=1;
		else {
			dp[n] = c_max+1;
		}
		max = Math.max(dp[n],max);
		return dp[n];
		
		
	}

}
