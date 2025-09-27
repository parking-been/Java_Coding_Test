package Tree;
import java.io.*;
import java.util.*;
public class back_g4_20924 {
	static int N, R;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static public class Node{
		int x;
		int w;
		int total;
		
		public Node(int x, int w) {
			this.x = x;
			this.w = w;
			this.total = 0;
			
		}
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		R = Integer.parseInt(com[1]);
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		list[0].add(new Node(R,0));
		for(int i=1;i<N;i++) {
			String[] com2 = br.readLine().split(" ");
			int x = Integer.parseInt(com2[0]);
			int y = Integer.parseInt(com2[1]);
			int w = Integer.parseInt(com2[2]);
			
			list[x].add(new Node(y, w));
			list[y].add(new Node(x, w));
		}
		//기둥 길이 구하기
		root(R);
		System.out.println(sb);
		
	}
	public static void root(int x) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(list[0].get(0));
		visited[0] = true;
		visited[x] = true;
		int giga_length = 0;
		int giga_flag = 0;
		int pre_length = 0;
		int length = 0;
		int max = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int dis = cur.total;
			int count= 0;
			for(Node e : list[cur.x]) {
				if(!visited[e.x]) {
					e.total = dis + e.w;
					max = Math.max(e.total, max);
					queue.add(e);
					visited[e.x] = true;
					length +=e.w;
					count++;
					//System.out.println(e.x + " "+ count + " " + giga_flag);
					
				}
				
			}
			//기가 노드 찾기 및 길이 찾기
			if (count>=2 && giga_flag == 0) {
				
				giga_flag = 1;
				giga_length = pre_length;
				
			}
			pre_length = length;
		}
		
		if (giga_flag==0) { // 나무 전체가 기가 노드
			giga_length = max;
			max = 0;
		}
		else {
			max = max - giga_length ;
		}
		//System.out.println(giga_length + " "+max);
		sb.append(giga_length + " "+max);
	}

}
