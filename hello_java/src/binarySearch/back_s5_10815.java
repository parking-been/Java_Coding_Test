package binarySearch;
import java.io.*;
import java.util.*;
public class back_s5_10815 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String[] n_num = br.readLine().split(" ");
		for(int i=0 ; i<N;i++) {
			list.add(Integer.parseInt(n_num[i]));
		}
		Collections.sort(list);
		
		M = Integer.parseInt(br.readLine());
		String[] m_num = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			int result = Collections.binarySearch(list,Integer.parseInt(m_num[i]));
			
			sb.append(result>=0?1:0).append(" ");
		}
		System.out.println(sb.toString());
		
	}

}
