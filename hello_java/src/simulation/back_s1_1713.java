package simulation;
import java.io.*;
import java.util.*;
public class back_s1_1713 {
	static int N, M;
	static List<Node> candidate = new ArrayList<>();
	static int delete_idx;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i=0;i<M;i++) {
			int new_student = scan.nextInt();
			
			//�߰�
			Node new_node = new Node(new_student,i);
			int flag = candidate.indexOf(new_node);
			if(flag!=-1) {
				//�̹� ���ο� �ִٸ�
				candidate.get(flag).count++;
			}
			else {
				
				if(candidate.size() == N) {
					//����
					candidate.remove(0);
				}
				//���ο� ���ٸ� �׳� �߰�. 
				candidate.add(new_node);
			}
			//delete_idx update
			candidate.sort(Comparator.comparingInt((Node n)-> n.count).thenComparingInt(n->n.add_w));
			
//			for(Node n : candidate) {
//				System.out.print(n.student+" ");
//			}
//			System.out.println();
		}
		candidate.sort(Comparator.comparingInt((Node n)-> n.student));
		for(Node n : candidate) {
			System.out.print(n.student+" ");
		}
		System.out.println();
	}
	
	//�� �޼ҵ��, Ŭ������ static �ۼ�����.
	public static class Node{
		int student;
		int add_w;
		int count;
		
		
		Node(int student, int add_w){
			this.student = student;
			this.add_w = add_w;
			this.count = 0;
		}
		
		//�̰� �� �ܿ��
		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(!(obj instanceof Node)) return false;
			Node other = (Node)obj;
			return this.student == other.student;
		}
		@Override
		public int hashCode() {
			return Objects.hash(student);
		}
		
	}

}
