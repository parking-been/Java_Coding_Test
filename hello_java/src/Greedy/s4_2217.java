package Greedy;
import java.io.*;
import java.util.*;

public class s4_2217 {
	static int N;
	static int[] rope;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rope = new int[N];
		for(int i=0;i<N;i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		int result = -1;
		for(int i=0; i<N;i++) {
			int tmp = rope[i]*(N-i);
			if(tmp > result) result = tmp; // Math.max
		}
		System.out.println(result);
	}

}
