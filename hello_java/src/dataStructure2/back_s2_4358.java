package dataStructure2;
import java.io.*;
import java.util.*;

public class back_s2_4358 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		//PriorityQueue<Node>
		Map<String, Integer> map = new HashMap<>();
		double total_count =0;
		//입력을 이렇게 받는게 맞나? 
		while((line = br.readLine())!=null && !line.isEmpty()) {
			if(map.containsKey(line)) {
				map.put(line,map.get(line)+1);
			}else {
				map.put(line,1);
			}
			total_count++;
		}
		
		Set<String> name_list = map.keySet();
		List<String> name_list2 = new ArrayList<>(name_list);
		Collections.sort(name_list2);
		for(String ele : name_list2) {
			String result = String.format("%s %.4f\n",ele,(double)(100*(map.get(ele)/total_count)));
			sb.append(result);
		}
		//System.out.println(name_list2);
		System.out.println(sb.toString());
	}

}
