package graphTraversal;
import java.io.*;
import java.util.*;
public class dfs {
	static boolean[] visited = new boolean[7]; // �湮 �迭
	static ArrayList<Integer>[] A = new ArrayList[7]; //ArrayList Ÿ�� �迭
	static ArrayList<Integer> procedure = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�迭�� �� ��Ҹ��� ArrayList�� ������.
		for(int i=1;i<=6;i++) {
			A[i] = new ArrayList<>();
		}
		A[1].add(2);
		A[1].add(3);
		A[2].add(5);
		A[2].add(6);
		A[3].add(4);
		A[4].add(6);
		
		//1�� ��忡�� DFS ����
		DFS(1);
		System.out.println(procedure.toString()); // ��½� ��!
		//[1, 3, 4, 6, 2, 5]
	}
	//stack ����Ͽ� ����
	public static void DFS(int v) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			visited[cur] = true;
			procedure.add(cur);
			
			//�ش� ����� ���� ����Ʈ�� �˻��ϸ�, visited �� false�� ��쿡�� stack.push.
			for(int i: A[cur]) {
				if(!visited[i]) {
					stack.push(i);
				}
			}
		}
	}
	

}
