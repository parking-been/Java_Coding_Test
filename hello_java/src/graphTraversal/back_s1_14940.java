package graphTraversal;
import java.io.*;
import java.util.*;
public class back_s1_14940 {
	static int n,m;
	static int[][] array;
	static boolean[][] visited;
	static int[][] distance;
	static int[][] move = {{-1,0},{0,-1},{0,1},{1,0}};
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] com = br.readLine().split(" ");
		n = Integer.parseInt(com[0]);
		m = Integer.parseInt(com[1]);
		
		array = new int[n][m];
		visited = new boolean[n][m];
		distance = new int[n][m];
		
		int[] target = new int[2];
		for(int i=0;i<n;i++) {
			String[] com2 = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				int x = Integer.parseInt(com2[j]);
				array[i][j] = x;
				if (2==x) {
					target[0] = i;
					target[1] = j;
				}
			}
		}
		
		bfs(target[0], target[1]);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && array[i][j]==1)sb.append("-1 ");
				else {
					sb.append(distance[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x,y));
		distance[x][y] = 0;
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			int c_dis = distance[cur.x][cur.y];
			for(int[] e : move) {
				int cx = cur.x + e[0];
				int cy = cur.y + e[1];
				if(cx <0 || cy<0 || cx>=n || cy >=m) continue;
				if(!visited[cx][cy] && array[cx][cy]!=0) {
					distance[cx][cy] = c_dis+1;
					queue.add(new Point(cx,cy));
					visited[cx][cy] = true;
				}
			}
			
			
		}
		
	}

}
