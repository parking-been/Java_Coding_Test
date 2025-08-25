package simulation;
import java.io.*;
import java.util.*;

public class back_g5_21922 {
	static int N,M; //세로 가로
	static int[][] room;
	static boolean[][] check;
	static List<int[]> aircon = new ArrayList<>();
	static boolean[][][] dp ;
	static int count = 0;
	static int[][][] objects = {
			{{1,1},{2,0},{3,0},{4,4}},
			{{1,0},{2,2},{3,3},{4,0}},
//			{{1,2},{2,1},{3,4},{4,3}},
//			{{1,3},{2,4},{3,1},{4,2}},
			{{1,3},{2,4},{3,1},{4,2}},
			{{1,2},{2,1},{3,4},{4,3}},
	};
	static int[][] move_l = {
			{-1,0},{0,-1},{0,1},{1,0}
	};
	static int[] c_location = new int[2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		room = new int[N][M];
		check = new boolean[N][M];
		dp = new boolean[N][M][4];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int a = scan.nextInt();
				room[i][j] = a;
				check[i][j] = false;
				//dp[i][j] = new StringBuilder();
				if (a==9) aircon.add(new int[] {i,j});
			}
		}
		
		for(int[] ele : aircon) {
			for(int i=1;i<5;i++) {
				//네 방향으로 
//				c_location[0] = ele[0];
//				c_location[1] = ele[1];
				//에어컨 지점 count 하기
				int a_x =ele[0];
				int a_y =ele[1];
				if(!check[a_x][a_y]) {
					check[a_x][a_y] = true;
					count++;
					
				}
				dp[a_x][a_y][i-1] = true;
				
				move(a_x, a_y,i);
				
			}
		}
		System.out.println(count);
		
	}
	public static void move(int px ,int py, int p) {
		
		//System.out.print(px+","+py+","+p);
		//System.out.println();
		
		if (p==0) return;
		
		int x = px + move_l[p-1][0];
		int y = py + move_l[p-1][1];
		
		if (x<0 || x>=N || y<0 || y>=M) return ; // 방을 넘어가면, 
		else {
			int o_num = room[x][y];
			int next_p;
			
			if(o_num==0 ||o_num==9 ) {
				next_p = p;
			}
			else {
				next_p = objects[o_num-1][p-1][1];
			}
			//이미 지나간 경우 
			//한번 이전에 어느 방향으로 지나갔는지 확인하고, 
			//이전에 지나간 방향이라면, 그만 돌기. 
			if (next_p !=0) {
			
				if(dp[x][y][next_p-1]) {
					return ;
				}
				dp[x][y][next_p-1]= true;
			
			}
			if (check[x][y]==false) { 
				count++;
				check[x][y] = true;
			}
			if (next_p==0) return;
			move(x, y, next_p);
			
			return ;
		}
		
	}

}
