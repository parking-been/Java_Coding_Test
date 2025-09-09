package graphTraversal;
import java.io.*;
import java.util.*;
public class bfs {
	static boolean[] visited = new boolean[7];
	static Queue<Integer> queue = new LinkedList<>(); // �̺κ� ����!
	static ArrayList<Integer>[] A = new ArrayList[7];
	static ArrayList<Integer> procedure = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=6;i++) {
			A[i] = new ArrayList<>(); // �迭�� �� ��Ҹ��� ArrayList�� ������
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
			//poll()�Ҷ�, Ž��  ���� ����Ʈ�� �־��ְ�, �湮�迭�� true�� �ٲ��ش�.
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
