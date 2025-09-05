package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_1890 {
	static int N;
	static int[][] board;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int [N][N];
		dp = new long [N][N];
		dp[N-1][N-1] = (long)1;
		for(int i=0;i<N;i++) {
			String[] com1 = br.readLine().split(" ");
			Arrays.fill(dp[i],-1);
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(com1[j]);
			}
		}
		long result = check(0,0);
		System.out.println(result);
		
	}
	public static long check(int x, int y) {
		
		//도착하면 1
		if (x==N-1 && y==N-1) return (long)1;
		//만약 범위를 넘으면 0
		if (x>=N || y>=N) return (long)0;
		if (dp[x][y]!=-1) return dp[x][y];
		
		int c_num = board[x][y];
		if (c_num==0) {
			dp[x][y] = (long)0;
			return dp[x][y];
		}
		long result = check(x+c_num, y) + check(x, y+c_num);
		dp[x][y] = result;
		return result;
	}

}
