package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s5_1010 {
	static int T,N,M;
	static long[][] com = new long[30][30];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		
		for(int i=1;i<30;i++) {
			//조합의 성질을 까먹었다. 
			Arrays.fill(com[i],(long)(-1));
			com[i][0]=(long)1;
			com[i][1]=(long)i;
			if(i!=1) com[1][i] = (long)0;
		}
		
		
		for(int i=0;i<T;i++) {
			String[] com1 = br.readLine().split(" ");
			N = Integer.parseInt(com1[0]);
			M = Integer.parseInt(com1[1]);
			sb.append(combination(M,N)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static long combination(int m, int n) {
		
		if (com[m][n]!=-1) return com[m][n];
		long result = (com[m-1][n]!=-1?com[m-1][n]:combination(m-1,n)) + (com[m-1][n-1]!=-1?com[m-1][n-1]:combination(m-1,n-1));
		com[m][n] = result;
		return result;
		
	}

}
