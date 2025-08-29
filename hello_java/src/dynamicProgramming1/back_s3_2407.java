package dynamicProgramming1;
import java.io.*;
import java.util.*;
import java.math.*;
public class back_s3_2407 {
	static int N;
	static int M;
	static BigInteger dp[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// BigInteger 을 쓰는 법에 대한 문제이다. long과 달리 limit가 없다. 
//		주어진 조건의 최대 범위를 잘 보고 자료형을 선택하기!
//		int : -2,147,483,648 ~ 2,147,483,647
//		long : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
//		BigInteger : 문자열 형태로 이루어져 있어 숫자의 범위가 무한
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Integer.parseInt(com[1]);
		dp = new BigInteger[101][101];
		for(int i=0;i<101;i++) {
			//dp[i] = new BigInteger[101];
			Arrays.fill(dp[i], BigInteger.valueOf(-1));
			dp[i][1] = BigInteger.valueOf(i);
			dp[i][0] = BigInteger.ONE;
			dp[i][i] = BigInteger.ONE;
		}
		
		BigInteger result = combi(N,M);
		System.out.println(result);
	}
	
	public static BigInteger combi(int n, int m) {
		if (n<0 || m<0 || m>n) return BigInteger.ZERO;
		if(dp[n][m]!=BigInteger.valueOf(-1)) return dp[n][m];
		
		BigInteger result = combi(n-1,m).add(combi(n-1,m-1));
		dp[n][m] = result;
		return result;
	}

}
