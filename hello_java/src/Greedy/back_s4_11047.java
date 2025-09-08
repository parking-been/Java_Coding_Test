package Greedy;
import java.io.*;
import java.util.*;
public class back_s4_11047 {
	static int N;
	static int K;
	static Integer[] coin;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com1 = br.readLine().split(" ");
		N = Integer.parseInt(com1[0]);
		K = Integer.parseInt(com1[1]);
		coin = new Integer[N];
		for(int i=N-1;i>=0;i--) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int count=0;
		for(int i=0;i<N;i++) {
			while(K-coin[i]>=0) {
				K = K-coin[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
