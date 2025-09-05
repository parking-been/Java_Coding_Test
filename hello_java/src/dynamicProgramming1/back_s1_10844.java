package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_10844 {
	static int N;
	static long[][] s_dp;
	
	static long[] dp;
	//이렇게 푸는게 맞을까? - 확인하기 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		s_dp = new long[10][N+1]; // {0,1,8,9}
		//dp = new long[N+1];
		//Arrays.fill(dp,-1); //Arrays.fill(s_dp,-1); 
		for(int i=0;i<10;i++) {
			Arrays.fill(s_dp[i],-1);
			s_dp[i][1] = 1;
		}
		s_dp[0][1]=0;
		
		for(int i=2;i<N+1;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					s_dp[0][i] = s_dp[1][i-1]%1000000000;
				}
				else if(j==9) {
					s_dp[9][i] = s_dp[8][i-1]%1000000000;
				}
				else {
					s_dp[j][i] = (s_dp[j-1][i-1] + s_dp[j+1][i-1])%1000000000;
				}
			}
		}
		
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum+= s_dp[i][N];
			sum = sum%1000000000;
			//System.out.print(s_dp[i][N]+" ");
		}
//		System.out.println();
		System.out.println(sum);
		
		
	}
	

}
