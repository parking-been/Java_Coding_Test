package Greedy;
import java.io.*;
import java.util.*;
public class back_s3_13305 {
	static int N;
	static long[] cost;
	static long[] length;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new long[N];
		length = new long[N];
		
		String[] com1 = br.readLine().split(" ");
		for(int i=0;i<N-1;i++) {
			length[i] = Long.parseLong(com1[i]);
		}
		String[] com2 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			cost[i] = Long.parseLong(com2[i]);
		}
		long c_cost = cost[0];
		long sum = 0;
		for(int i=1;i<N;i++) {
			long now = length[i-1]*c_cost;
			if(c_cost<cost[i]) {
				sum+= now;
			}else {
				sum+=now;
				c_cost = cost[i];
				
			}
			
		}
		
		System.out.println(sum);
		
	}

}
