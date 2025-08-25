package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s4_18258 {
	static int N;
	static String command;
	//static Scanner scan;
	static Queue<Integer> q1 = new LinkedList<>(); //new 쓰는거 까먹지 말자. 
	static int last;
	static StringBuilder sb;
	//throws IOException : main 함수 안에서 IOExceptionㅇ 발생할 수 있으며, 
	// 이걸 써두면 IOException 발생시 try-catch 없이 JVM 으로 예외를 넘긴다. 
	public static void main (String[] args)throws IOException  {
		//scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			//command = scan.next();
			//action(command);
			String command = br.readLine();
			String[] parts = command.split(" ");
			action(parts);
			
		}
		System.out.println(sb.toString());
	}
	
	public static void action(String[] parts) {
		int num;
		switch(parts[0]) { // case 값 : 기억하기.
		case "push" : 
			num = Integer.parseInt(parts[1]);
			q1.add(num);
			last = num;
			break;
		case "pop" :
			if(q1.isEmpty()) sb.append("-1\n");
			else {
			num = q1.poll();
			//System.out.println(num);
			sb.append(num).append("\n");
			}
			break;
		case "size":
			sb.append(q1.size()).append("\n");
			break;
		case "empty":
			sb.append(q1.isEmpty() ? "1\n" : "0\n");
			break;
		case "front":
			sb.append(q1.isEmpty() ? "-1" : q1.peek()).append("\n");
			break;
		case "back":
//			if(q1.isEmpty()) System.out.println(-1);
//			else {
//				//int idx = q1.size()-1;
//				//System.out.println(new ArrayList<>(q1).get(idx)); //꼭 다른 풀이랑 비교할것.
//				//last 값을 따로 int로 저장 
//				System.out.println(last);
//			}
			sb.append(q1.isEmpty() ? "-1" : last).append("\n");
			break;
		}
		
			
	}
}
