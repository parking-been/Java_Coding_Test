package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s3_2346 {
	static int N;
	static Deque<Node> deque = new ArrayDeque<>();
	
	static class Node{
		int num;
		int paper;
		Node(int num, int paper){
			this.num = num;
			this.paper = paper;
		}
	}
	
	public static void main (String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String[] paper_l = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			deque.addLast(new Node(i,Integer.parseInt(paper_l[i])));
		}
		
		int count = 0;
		Node ball = deque.pollFirst();
		count = ball.paper; 
		sb.append(ball.num+1).append(" ");
		while(deque.size()!=0) {
			
			for(int i=0;i<(count>0?Math.abs(count)-1:Math.abs(count));i++) {
				if(count>0) {
					ball = deque.pollFirst();
					deque.addLast(ball);
				}
				else {
					ball = deque.pollLast();
					deque.addFirst(ball);
				}
			}
			ball = deque.pollFirst();
			count= ball.paper;
			sb.append(ball.num+1).append(" ");
			
		}
		System.out.println(sb.toString());
		
	}

}
