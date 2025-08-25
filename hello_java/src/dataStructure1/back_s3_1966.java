package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s3_1966 {
	static int test_num;
	static int N;
	static int M;
	static Integer[] imp;
	public static class Node{
		int num;
		Integer level;
		Node(int num, int level){
			this.num = num;
			this.level = level;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		test_num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<test_num;i++) {
			Queue<Node> q1 = new LinkedList<>(); // queue의 위치 중요!!!
			// 총 개수, 궁금한 문서 번호 
			String[] com = br.readLine().split(" ");
			N = Integer.parseInt(com[0]);
			M = Integer.parseInt(com[1]);
			
			imp = new Integer[N];
			String[] com2 = br.readLine().split(" ");
			
			for(int j=0;j<N;j++) {
				//우선 queue에 다 담기
				int n = Integer.parseInt(com2[j]);
				q1.add(new Node(j,n));
				imp[j] = n;
			}
			
			Arrays.sort(imp, Collections.reverseOrder()); // int에 대해서는 안되고 Integer만 된다. 
			//for(Integer ele : imp) System.out.print(ele + " ");
			int count = 0;
			OUT:
			while(q1.size()!=0) {
				int target_weight = imp[count];
				Node now = q1.poll();
				if (now.level == target_weight) {
					count++;
					if(now.num == M) {
						sb.append(count).append("\n");
						break OUT;
					}
				}
				else {
					q1.add(now);
				}
			}
			
			//System.out.println(imp);
			
			
		}
		
		System.out.println(sb.toString());
		
	}

}
