package binarySearch;
import java.io.*;
import java.util.*;
public class back_s3_19637 {
	static int N;
	static int M;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//PriorityQueue<>
		Map<Integer, String> map = new HashMap<>();
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Integer.parseInt(com[1]);
		
		for(int i=0;i<N;i++) {
			String[] com2 = br.readLine().split(" ");
			if (!map.containsKey(Integer.parseInt(com2[1]))) {
				map.put(Integer.parseInt(com2[1]), com2[0]);
			}
			
		}
		
		//System.out.println(map);
		//순서가 이미 정렬되어있음.
		
		List<Integer> arr = new ArrayList<>(map.keySet());
		Collections.sort(arr);
		for(int i=0;i<M;i++) {
			int t = Integer.parseInt(br.readLine());
			int result = Collections.binarySearch(arr, t);
			//System.out.println(result);
			if (result >=0) {
				sb.append(map.get(arr.get(result))).append("\n");
				//System.out.println(result);
			}else {
				int n_result = -result-1;
				//System.out.println(result);
				//System.out.println(n_result);
				if (n_result == map.size()) {
					n_result--;
				}
				//System.out.println(arr.get(n_result));
				sb.append(map.get(arr.get(n_result))).append("\n");
				
			}
		}
		System.out.println(sb.toString());
		
	}

}
