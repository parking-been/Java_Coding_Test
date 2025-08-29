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
		// BigInteger �� ���� ���� ���� �����̴�. long�� �޸� limit�� ����. 
//		�־��� ������ �ִ� ������ �� ���� �ڷ����� �����ϱ�!
//		int : -2,147,483,648 ~ 2,147,483,647
//		long : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
//		BigInteger : ���ڿ� ���·� �̷���� �־� ������ ������ ����
		
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
