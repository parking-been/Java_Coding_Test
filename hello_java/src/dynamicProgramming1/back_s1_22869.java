package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_22869 {
	static int N;
	static int K;
	static int[] array;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com1 = br.readLine().split(" ");
		N = Integer.parseInt(com1[0]);
		K = Integer.parseInt(com1[1]);
		String[] com2 = br.readLine().split(" ");
		array = new int[N+1];
		dp = new int[N+1];
		for(int i=0;i<N;i++) {
			array[i+1] = Integer.parseInt(com2[i]);
		}
		dp[1] = 1;
		
		for(int j=2;j<=N;j++) {
			dp[j] = 0;
			for(int i=j;i>=1;i--) {
				int power = (j-i)*(1+Math.abs(array[i]-array[j]));
				if(power<=K && dp[i]==1) {
					dp[j] = 1;
					break;
				}
			}
		}
		
//		for(int ele : dp) {
//			System.out.print(ele + " ");
//		}System.out.println();
		
		System.out.println(dp[N]==1?"YES":"NO");
		
	}

}
