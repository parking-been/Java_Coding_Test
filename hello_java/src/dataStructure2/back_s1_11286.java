package dataStructure2;
import java.io.*;
import java.util.*;
public class back_s1_11286 {
	static int N;
	
	static public class Node{
		int num;
		
		Node(int num){
			this.num = num;
		}
		
		public int CompareTo(Node p) { // 이거 다시한번 더 확인하기. 
			if (Math.abs(this.num) > Math.abs(p.num)) {
				return 1;
			}
			else if (Math.abs(this.num) == Math.abs(p.num)) {
				if(this.num>0) return 1;
			}
			return -1;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Node> pq = new PriorityQueue<>(Node :: CompareTo);
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				sb.append(pq.isEmpty()? 0 : pq.poll().num).append("\n");
			}else {
				pq.add(new Node(num));
			}
		}
		System.out.println(sb.toString());
	}

}
