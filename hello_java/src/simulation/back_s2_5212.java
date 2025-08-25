package simulation;
import java.io.*;
import java.util.*;
public class back_s2_5212 {
	static int X, Y;
	static char[][] map;
	//아직까지 살아있는 섬들의 좌표
	//static List<int[]> after = new ArrayList<>();
	static List<List<Integer>> after = new ArrayList<>();
	static int[][] near = {{0,-1},{-1,0},{0,1},{1,0}};
	static int min_x, max_x, min_y, max_y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan =new Scanner(System.in);
		X = scan.nextInt();
		Y = scan.nextInt();
		map = new char[X][Y];
		for(int i=0;i<X;i++) {
			String str = scan.next();
			for(int j=0;j<Y;j++) {
				
				map[i][j] = str.charAt(j);
			}
		}
		//System.out.println("안녕");
		int c_count=0;
		min_x = X-1;
		max_x = 0;
		min_y = Y-1;
		max_y = 0;
		for(int i=0;i<X;i++) {
			for(int j=0;j<Y;j++) {
				if(map[i][j]=='X') {
					c_count=0;
					for(int[] n : near) {
						int x= i+n[0];
						int y= j+n[1];
						if((x<0 || y<0 || x>=X || y>=Y) || map[x][y]=='.') {
							c_count++; // 바다주변
						}
					}
					if(c_count <3) {
						//존재할 섬
						after.add(Arrays.asList(i,j)); // 기억하자
						min_x = Math.min(min_x,i);
						max_x = Math.max(max_x,i);
						min_y = Math.min(min_y,j);
						max_y = Math.max(max_y,j);
						//System.out.println(i+","+j);
					}
				}
			}
		}
//		System.out.println(after.size());
//		System.out.println(min_x);
//		System.out.println(max_x);
//		System.out.println(min_y);
//		System.out.println(max_y);
		
		for(int i = min_x;i<=max_x;i++) {
			for(int j=min_y;j<=max_y;j++) {
				if(after.contains(Arrays.asList(i,j))) {
					System.out.print("X");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		
		
		
	}

}
