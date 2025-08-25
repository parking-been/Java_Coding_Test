package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s4_1158 {
	static int N, K;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	//static List<Integer> used = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String[] command = br.readLine().split(" ");
		N = Integer.parseInt(command[0]);
		K = Integer.parseInt(command[1]);
		int count=0;
		
		for(int i=0;i<N;i++) {
			queue.add(i+1);
		}
		sb.append("<");
		while(queue.size()!=0) {
			
			
			int num = queue.poll();
			
			if ((count-(K-1))%K==0 ) {//|| count==(K-1)
				
				sb.append(num); //.append(", ");
				if(queue.size()!=0)sb.append(", ");
			}
			else {
				queue.add(num);
			}
			
			count++;
			
		}
		sb.append(">");
		System.out.println(sb.toString());
		
		
	}

}
