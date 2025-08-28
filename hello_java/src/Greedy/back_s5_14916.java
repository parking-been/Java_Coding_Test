package Greedy;
import java.io.*;
import java.util.*;
public class back_s5_14916 {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count=-1;
		for(int i=N/5;i>=0;i--) {
			int rest = N-i*5;
			if (rest%2==0) { count = i+(rest/2); break;}
		}
		System.out.println(count);
		
	}

}
