package dataStructure2;
import java.io.*;
import java.util.*;
public class back_s4_14425 {
	static int N, M;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Integer.parseInt(com[1]);
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		int count=0;
		for(int i=0;i<M;i++) {
			String target = br.readLine();
			if(set.contains(target)) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}

}
