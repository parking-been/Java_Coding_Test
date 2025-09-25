package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_g5_15486 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		dp = new int[N+1];
		dp[0]=0;
		for(int i=0;i<N;i++) {
			String[] com = br.readLine().split(" ");
			T[i+1] = Integer.parseInt(com[0]);
			P[i+1] = Integer.parseInt(com[1]);
			
		}
		
		for(int i=1;i<=N;i++) {
			//1. 넘기기
			dp[i] = Math.max(dp[i],dp[i-1]);
			
			//퇴사일 이후 마무리 되는 작업 패스
			if(i+T[i]-1>N) continue;
			
			//2. 상담수행
			dp[i+T[i]-1] = Math.max(dp[i-1]+P[i], dp[i+T[i]-1]);
			
		}
		
		System.out.println(dp[N]);
		
		

	}

}
