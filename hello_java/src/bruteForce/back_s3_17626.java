package bruteForce;
import java.io.*;
import java.util.*;
public class back_s3_17626 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			dp[i] = i; // ÃÖ´ë: 1^2 + 1^2 ... (i¹ø)
			for(int j=1;j*j<=i;j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);
		
	}
	
	

}
