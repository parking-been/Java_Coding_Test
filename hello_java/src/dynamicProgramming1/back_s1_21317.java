package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_s1_21317 {
	static int N;
	static int[][] power;
	static int[][] dp;
	static int[] min;
	static int[] min2;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0);
			return;
		}
		power = new int[N+1][3];
		dp = new int[N+1][4];
		min = new int[N+1]; // k 미사용
		min2 = new int[N+1]; //k 사용
		for(int i=0;i<N-1;i++) {
			String[] com1 = br.readLine().split(" ");
			power[i+1][1] = Integer.parseInt(com1[0]);
			power[i+1][2] = Integer.parseInt(com1[1]);
		}
		k = Integer.parseInt(br.readLine());
		Arrays.fill(min,10000000);
		Arrays.fill(min2,10000000);
		min[1] = 0;
		if (N>=2) min[2] = min[1] + power[1][1];
		if(N>=3) min[3] = Math.min(min[2]+power[2][1], min[1]+power[1][2]);
		
		for(int i=4;i<=N;i++) {
			// k 미사용상태
			min[i] = Math.min(min[i-1]+power[i-1][1] , min[i-2] + power[i-2][2]);
			// k 사용상태 (이미 사용한 상태로 1칸, 2칸)
			min2[i] = Math.min(min2[i-1]+power[i-1][1] , min2[i-2] + power[i-2][2]);
			// 이번에 처음으로 k 사용
			min2[i] = Math.min(min2[i], min[i-3]+k);
		}

		int result = Math.min(min2[N],min[N]);
		System.out.println(result);
		
	}
}
