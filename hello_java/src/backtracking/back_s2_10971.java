package backtracking;
import java.io.*;
import java.util.*;

public class back_s2_10971 {
	
	static int N;
	static int[][] W;
	static int[] a_list;
	static boolean[] used;
	static int c_point=0;
	static int c_cost = 0;
	static int min_cost = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		N = scan.nextInt();
		W = new int[N][N];
		a_list = new int[N];
		used = new boolean[N];
		for(int i=0;i<N;i++) {
			used[i] = false;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				W[i][j] = scan.nextInt();
			}
		}
		
		select();
		System.out.println(min_cost);
		
		
	}
	public static void select() {
		int cost;
		int last_cost;
		if (c_point==N) {
//			for(int a : a_list) System.out.print(a + " ");
//			System.out.println();
			last_cost = W[a_list[N-1]][a_list[0]];
			if (last_cost==0) {
				return;
			}
			if (min_cost > last_cost + c_cost) {
				min_cost = c_cost+last_cost ;
				
			}
		}
		else {
		
			for(int i=0;i<N;i++) {
				
				
				if(used[i]==false) {
					a_list[c_point] = i;
					c_point++;
					used[i] = true;
					
					if(c_point!=1) {
						
						cost = W[a_list[c_point-2]][a_list[c_point-1]];
						if (cost==0) {
							c_point--;
							used[i] = false;
							return;
						}
						c_cost +=cost;
						select();
						c_cost -=cost;
						
					}
					else {
						select();
					}
					
					c_point--;
					used[i] = false;
					
				}
			}
		}
	}

}
