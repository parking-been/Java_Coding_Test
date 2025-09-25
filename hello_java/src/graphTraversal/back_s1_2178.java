package graphTraversal;
import java.io.*;
import java.util.*;
public class back_s1_2178 {
	static int N,M;
	static boolean[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int[][] move = {{-1,0},{0,-1},{1,0},{0,1}};
	static public class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Integer.parseInt(com[1]);
		map = new boolean[N][M];
		count = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String com2 = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = (com2.charAt(j)=='1'?true:false);
				
			}
		}
		
		bfs(0,0);
		System.out.println(count[N-1][M-1]);
	}
	public static void bfs(int x, int y) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x,y));
		count[x][y]=1;
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int dis = count[cur.x][cur.y];
			for(int[] e:move) {
				int cx = cur.x + e[0];
				int cy = cur.y + e[1];
				if(cx<0 || cy<0 || cx>=N || cy>=M)continue;
				if(!visited[cx][cy] && map[cx][cy]) {
					queue.add(new Node(cx, cy));
					visited[cx][cy] = true;
					count[cx][cy] = dis + 1;
				}
				if(cx == N-1 && cy == M-1) break;
			}
		}
	}

}
