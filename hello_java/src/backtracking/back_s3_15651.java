package backtracking;
import java.io.*;
import java.util.*;
public class back_s3_15651 {
	static int N;
	static int M;
	static boolean[] used;
	static int[] a_list;
	static int c_M=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		used = new boolean[N];
		a_list = new int[M];
		select();
		System.out.print(sb);
		
		
	}
	public static void select() {
		for(int i=0;i<N;i++) {
			a_list[c_M] = i;
			c_M++;
			if(c_M==M) {
				for(int ele : a_list) {
					//System.out.print((ele+1)+" ");
					sb.append(ele+1).append(" ");
				}
				sb.append("\n");
				//System.out.println();
			}
			else {
				select();
			}
			c_M--;
		}
	}

}
