package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s4_10828 {
	static Stack<Integer> s1 = new Stack<>();
	static int N;
	static StringBuilder sb;
	public static void main (String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); //기억하기.
		
		for(int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			action(command);
		}
		System.out.println(sb.toString());
	}
	public static void action(String[] command) {
		int num;
		switch(command[0]){
			case "push":
				s1.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				if (s1.isEmpty()) sb.append(-1).append("\n");
				else {
					sb.append(s1.pop()).append("\n");
				}
				break;
			case "size":
				sb.append(s1.size()).append("\n");
				break;
			case "empty":
				sb.append(s1.isEmpty() ? "1\n":"0\n");
				break;
			case "top":
				sb.append(s1.isEmpty() ? "-1" : s1.peek()).append("\n");
				break;
		}
	}

}
