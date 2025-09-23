package graphTraversal;
import java.io.*;
import java.util.*;
public class back_s1_2667 {
	static int N;
	static boolean[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> result = new ArrayList<>();
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String com = br.readLine();
			for(int j=0;j<N;j++) {
				if(com.charAt(j)=='1') map[i][j]=true;
			}
		}
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j]==true) {
					bfs(i,j);
					
				}
			}
		}
		
		Collections.sort(result);
		sb.append(result.size()+"\n");
		for(int e : result) {
			sb.append(e+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x,y));
		visited[x][y] = true;
		int count = 1;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int[] e : move) {
				int cx = cur.x + e[0];
				int cy = cur.y + e[1];
				
				if(cx<0||cy<0||cx>=N || cy>=N) continue;
				if(!visited[cx][cy] && map[cx][cy]==true) {
					q.add(new Node(cx,cy));
					visited[cx][cy] = true;
					count++;
				}
			}
			
		}
		
		result.add(count);
		
		//System.out.println(count);
		//System.exit(0);
		//result 안에 담기
	}
}
