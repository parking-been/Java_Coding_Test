package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_g4_1106 {
	static int N, C;
	static int[] price;
	static int[] num;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		C =Integer.parseInt(com[0]);
		N = Integer.parseInt(com[1]);
		price = new int[N+1];
		num = new int[N+1];
		dp = new int[C+1];
		
		for(int i=0;i<N;i++) {
			String[] com2 = br.readLine().split(" ");
			price[i+1] = Integer.parseInt(com2[0]);
			num[i+1] = Integer.parseInt(com2[1]);
		}
		
		for(int i=1;i<=C;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=N;j++) {
				int tmp = 0;
				if(i-num[j]<=0) tmp = price[j];
				else tmp = dp[i-num[j]]+price[j];
				
				min = Math.min(tmp, min);
			}
			dp[i] = min;
		}
		System.out.println(dp[C]);
//		for(int ele : dp) {
//			System.out.println(ele);
//		}
		
		
	}

}
