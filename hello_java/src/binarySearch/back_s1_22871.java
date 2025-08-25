package binarySearch;
import java.io.*;
import java.util.*;
public class back_s1_22871 {
	static int N;
	static long[] rocks;
	static long[] min_power;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rocks = new long[N];
		min_power = new long[N];
		
		String[] comm = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			rocks[i] = Long.parseLong(comm[i]);
			min_power[i]=-1;
		}
		
		
		for(int i=N-1;i>=0;i--) {
			if(i==N-1) min_power[i] = 0;
			else {
				dp(i);
				//System.out.println("~~~~~~~~~");
			}
		}
		
		System.out.println(min_power[0]);
	}
	
	public static long dp(int n) {
		long min = Long.MAX_VALUE;
		for(int i=n+1;i<N;i++) {
			long dpv;
			if (min_power[i]==-1) dpv = dp(i);
			else dpv = min_power[i];
			long semi = Math.max(dpv , ((i-n)*(1+Math.abs(rocks[i] - rocks[n]))));
			//System.out.println(dpv+" " + semi);
			if(min > semi) min = semi;
		}
		
		min_power[n] = min;
		return min;
	}

}
