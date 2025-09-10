package graphTraversal;
import java.io.*;
import java.util.*;
public class back_s3_2606 {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	//static LinkedList<Integer> procedure = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	static int N, M;
	static int count =0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		Arrays.fill(visited, false);
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M;i++) {
			String[] com1 = br.readLine().split(" ");
			int x = Integer.parseInt(com1[0]);
			int y = Integer.parseInt(com1[1]);
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		DFS(1);
		//System.out.println(procedure.toString());
		System.out.println(count==0?0:count-1);
	}
	public static void DFS(int x) {
		stack.add(x);
		visited[x] = true; 
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			//System.out.println(cur);
			count++;
			//procedure.add(cur);
			for(int e : graph[cur]) {
				if(!visited[e]) {
					visited[e] = true; // 여기서 방문처리해야함.
					stack.add(e);
				}
			}
		}
	}

}
