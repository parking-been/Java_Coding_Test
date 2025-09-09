package graphTraversal;
import java.io.*;
import java.util.*;
public class bfs {
	static boolean[] visited = new boolean[7];
	static Queue<Integer> queue = new LinkedList<>(); // 이부분 주의!
	static ArrayList<Integer>[] A = new ArrayList[7];
	static ArrayList<Integer> procedure = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=6;i++) {
			A[i] = new ArrayList<>(); // 배열의 각 요소마다 ArrayList를 가진다
		}
		A[1].add(2);
		A[1].add(3);
		A[2].add(5);
		A[2].add(6);
		A[3].add(4);
		A[4].add(6);
		
		BFS(1);
		
		System.out.println(procedure.toString());
		//[1, 2, 3, 5, 6, 4]

	}
	
	public static void BFS(int start) {
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			//poll()할때, 탐색  순서 리스트에 넣어주고, 방문배열을 true로 바꿔준다.
			procedure.add(now);
			visited[now] = true;
			
			for(int i : A[now]) {
				if(!visited[i]) {
					queue.add(i);
				}
			}
		}
		
	}

}
