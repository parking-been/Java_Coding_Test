package test;
import java.io.*;
import java.util.*;
public class priorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq1 = new PriorityQueue<>(Node :: compareTo);
		pq1.add(new Node(1,2));
		pq1.add(new Node(1,1));
		pq1.add(new Node(2,3));
		pq1.add(new Node(2,1));
		
		while(!pq1.isEmpty()) {
			Node node = pq1.poll();
			System.out.println(node.y+" "+node.x);
		}
		
	}
	static class Node{
		int y;
		int x;
		
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
		
		public int compareTo(Node p) {
			if(this.y < p.x) return -1;
			else if(this.y==p.y) {
				if(this.x < p.x) return -1;
			}
			return 1;
		}
	}

}
