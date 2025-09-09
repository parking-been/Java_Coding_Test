package graphTraversal;
import java.io.*;
import java.util.*;
public class dfs {
	static boolean[] visited = new boolean[7]; // 방문 배열
	static ArrayList<Integer>[] A = new ArrayList[7]; //ArrayList 타입 배열
	static ArrayList<Integer> procedure = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열의 각 요소마다 ArrayList를 가진다.
		for(int i=1;i<=6;i++) {
			A[i] = new ArrayList<>();
		}
		A[1].add(2);
		A[1].add(3);
		A[2].add(5);
		A[2].add(6);
		A[3].add(4);
		A[4].add(6);
		
		//1번 노드에서 DFS 실행
		DFS(1);
		System.out.println(procedure.toString()); // 출력시 팁!
		//[1, 3, 4, 6, 2, 5]
	}
	//stack 사용하여 구현
	public static void DFS(int v) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			visited[cur] = true;
			procedure.add(cur);
			
			//해당 노드의 인접 리스트를 검사하며, visited 가 false인 경우에만 stack.push.
			for(int i: A[cur]) {
				if(!visited[i]) {
					stack.push(i);
				}
			}
		}
	}
	

}
