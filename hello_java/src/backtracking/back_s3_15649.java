package backtracking;
import java.io.*;
import java.util.*;
public class back_s3_15649 {
	static int N;
	static int M;
	static boolean[] used;
	static int[] a_list;
	static int c_M=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		used = new boolean[N]; //한번에 false로 만드는 방법
		for(int i=0;i<N;i++) {
			used[i] = false;
		}
		a_list = new int[M];
		select();
	}
	public static void select() {
		for(int i=0;i<N;i++) {
			if(used[i]==false) {
				a_list[c_M] = i;
				used[i] = true;
				c_M++;
				if (c_M==M) {
					for(int ele : a_list) System.out.print((ele+1) + " ");
					System.out.println();
					
				}
				else {
					select();
				}
				c_M--;
				used[i] = false;
			}
		}
	}

}
