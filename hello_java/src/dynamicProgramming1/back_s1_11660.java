package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_11660 {
	static int N,M;
	static int[][] map;
	static int[][] S;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] com1 = br.readLine().split(" ");
		N = Integer.parseInt(com1[0]);
		M = Integer.parseInt(com1[1]);
		map = new int[N+1][N+1];
		S = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			String[] com2 = br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(com2[j-1]);
				S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + map[i][j];
			}
		}
		
		for(int i=0;i<M;i++) {
			String[] com3 = br.readLine().split(" ");
			int x1 = Integer.parseInt(com3[0]);
			int y1 = Integer.parseInt(com3[1]);
			int x2 = Integer.parseInt(com3[2]);
			int y2 = Integer.parseInt(com3[3]);
			int result = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
	}
	
	

}
