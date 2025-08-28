package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s3_2579 {
	static int N;
	static int[] stairs;
	static int[][] scores;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int num = (N<=2?3:N);
		stairs = new int[num+1];
		scores = new int[num+1][2];
		
		
		
		for(int i=1;i<N+1;i++) {
			int tmp = Integer.parseInt(br.readLine());
			stairs[i] = tmp;
			scores[i] =  new int[] {-1,-1};
			
		}
		
		//1,2,3 stair 에 대해 미리 계산
		//0 : i-1, i
		//1 : i-2, i
		scores[1][0] = stairs[1]; scores[1][1] = stairs[1];
		scores[2][0] = stairs[2]+scores[1][1]; scores[2][1] = stairs[2];
		
		int result = Math.max(jump(N, 0),jump(N, 1));
		System.out.println(result);
		
	}
	
	public static int jump(int n, int f) {
		if (scores[n][f]!=-1)return scores[n][f];
		
		int result0 = jump(n-1,1) + stairs[n];
		int result1 = Math.max(jump(n-2,0),jump(n-2,1)) + stairs[n];
		
		scores[n][0] = result0;
		scores[n][1] = result1;
		
		return scores[n][f];
	}

}
