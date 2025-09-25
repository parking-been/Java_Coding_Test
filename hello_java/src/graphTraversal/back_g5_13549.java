package graphTraversal;
import java.io.*;
import java.util.*;
public class back_g5_13549 {
	static int N,K;
	static boolean[] visited;
	static int max = 200000;
	public static class Node{
		int x;
		int time;
		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		K = Integer.parseInt(com[1]);
		visited = new boolean[max+1];
		int result = bfs(N);
		System.out.println(result);
	}
	public static int bfs(int x) {
		Deque<Node> dq = new ArrayDeque<>();
		dq.addFirst(new Node(x, 0));
		
		while(!dq.isEmpty()){
			Node cur = dq.pollFirst();
			//System.out.println(cur.x);
			if(cur.x == K )return cur.time;
			
			//0이동 비용 : x*2
			int nx = cur.x*2;
			if(nx<= max && !visited[nx]) {
				visited[nx] = true;
				dq.addFirst(new Node(nx,cur.time));
			
			}
			
			// 1 비용 이동 : x-1
			nx = cur.x-1;
			if(nx >=0 && ! visited[nx]) {
				visited[nx] = true;
				dq.addLast(new Node(nx, cur.time+1));
			}
			
			nx = cur.x+1;
			if(nx <= max && !visited[nx]) {
				visited[nx] = true;
				dq.addLast(new Node(nx, cur.time+1));
			}
			
		}
		return -1;
	}

}
