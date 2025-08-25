package backtracking;
import java.io.*;
import java.util.*;
public class back_s2_1182 {
	static int N;
	static int S;
	static int[] num;
	static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = scan.nextInt();
		//System.out.println("æ»≥Á«œººø‰1");
		num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = scan.nextInt();
		}
		//System.out.println("æ»≥Á«œººø‰");
		select();
		System.out.println(count);
	}
	public static void select() {
		int total = 1<<N;
		int current =0;
		int c_t = 0;
		for(int i=0;i<total;i++) {
			current = 0;
			for(int j=0;j<N;j++) {
				//System.out.print(((i>>j)&1) + " ");
				if (c_t!=0) {
					if(((i>>j)&1)==1) {
						current += num[j];
					}
				}
			}
			//System.out.println();
			
			if (current == S && c_t!=0) count++;
			c_t++;
		}
	}
	

}
