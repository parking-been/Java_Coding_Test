package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s4_10866 {
	static int N;
	static Deque<Integer> d1 = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String[] command = br.readLine().split(" ");
			action(command);
		}
		System.out.println(sb);
		
	}
	public static void action(String[] command) {
		switch(command[0]) {
		case "push_front":
			d1.addFirst(Integer.parseInt(command[1]));
			break;
		case "push_back":
			d1.addLast(Integer.parseInt(command[1]));
			break;
		case "pop_front":
			sb.append(d1.isEmpty()?"-1":d1.pollFirst()).append("\n");
			break;
		case "pop_back":
			sb.append(d1.isEmpty()?"-1":d1.pollLast()).append("\n");
			break;
		case "size":
			sb.append(d1.size()).append("\n");
			break;
		case "empty":
			sb.append(d1.isEmpty() ?"1\n":"0\n");
			break;
		case "front":
			sb.append(d1.isEmpty()?"-1":d1.peekFirst()).append("\n");
			break;
		case "back":
			sb.append(d1.isEmpty()?"-1":d1.peekLast()).append("\n");
			break;
		
		}
	}

}
