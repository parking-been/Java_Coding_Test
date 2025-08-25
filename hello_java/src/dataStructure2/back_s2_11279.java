package dataStructure2;
import java.io.*;
import java.util.*;
public class back_s2_11279 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
			}else {
				pq.add(num);
			}
		}
		
		System.out.println(sb.toString());
	}

}
