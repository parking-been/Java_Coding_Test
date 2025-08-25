package dataStructure2;
import java.io.*;
import java.util.*;
public class back_s3_2075 {
	static Stack<Node>[] stacks;
	static int N;
	
	public static class Node{
		int num;
		int from;
		
		Node(int num, int from){
			this.num = num;
			this.from = from;
		}
		
		public int compareTo(Node p) {
			if(this.num > p.num) return -1;
			else return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stacks = new Stack[N]; //제너릭 생략
		//List<Integer> part =  new ArrayList();
		PriorityQueue<Node> part = new PriorityQueue<>(Node::compareTo);
		for(int i=0;i<N;i++) {
			String [] com = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				if(i==0) stacks[j] = new Stack<Node>();
				int ele = Integer.parseInt(com[j]);
				stacks[j].push(new Node(ele,j));
				if (i==N-1) {
					part.add(stacks[j].pop());
				}
			}
			
		}
		
		//System.out.println(part);
//		for(Node p : part) {
//			System.out.print(p.num+" ");
//		}
//		System.out.println();
		//Collections.sort();
		int count = 0;
		while(count!=N-1) {
			Node pop = part.poll();
			//System.out.println(pop.num);
			part.add(stacks[pop.from].pop());
			count++;
		}
		Node last = part.poll();
		System.out.println(last.num);
		
	}
}
