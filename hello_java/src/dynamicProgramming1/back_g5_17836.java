package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_g5_17836 {
	static int N, M, T;
	static int[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int[][] move = {{-1,0},{0,-1},{1,0},{0,1}};
	public static class Node{
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
		T = Integer.parseInt(com[2]);
		map = new int[N][M];
		count = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String[] com1 = br.readLine().split(" ");
			Arrays.fill(count[i], Integer.MAX_VALUE);
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(com1[j]);
			}
		}
		
		int result = bfs(0,0);
		if (result == Integer.MAX_VALUE) {
			System.out.println("Fail");
		}
		else if (result <= T) {
			System.out.println(result);
		}
		else {
			System.out.println("Fail");
		}
		
		//System.out.println(result);
	}
	public static int bfs(int x, int y) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x,y));
		visited[x][y] = true;
		count[x][y] = 0;
		int gram = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			//
			Node cur = queue.poll();
			int dis = count[cur.x][cur.y];
			if (cur.x == N-1 && cur.y == M-1) break;
			for(int[] e : move) {
				int cx = cur.x +e[0];
				int cy = cur.y + e[1];
				
				if(cx<0 || cy<0 || cx>=N || cy >=M) continue;
				//만약 그람이라면?
				if (!visited[cx][cy] && map[cx][cy]==2) {
					gram = dis+1 + (N-1-cx) + (M-1-cy);
					visited[cx][cy] = true;
					count[cx][cy] = dis + 1;
				}
				if(!visited[cx][cy] && map[cx][cy]==0) {
					queue.add(new Node(cx,cy));
					count[cx][cy] = dis + 1;
					visited[cx][cy] = true;
					
				}
			}
		}
		int result = Math.min(count[N-1][M-1],gram);
		
		return result;
	}
	
}
