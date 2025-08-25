package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s2_1874 {
	static int n;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] used;
	static boolean[] poped;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		used = new boolean[n+1];
		poped = new boolean[n+1];
		
		Arrays.fill(poped,false);
		Arrays.fill(used,false);
		
		int target ;
		int current;
		boolean flag = true ;
		OUT:
		for(int i=0;i<n;i++) {
			//하나씩 입력받고 되나 확인하기.
			target = Integer.parseInt(br.readLine());
			
			int peek = (stack.isEmpty()?0:stack.peek());
			
			if(target> peek) {
				for(int j=1;j<=(target-peek);j++) {
					if(!used[peek+j] && !poped[peek+j]) { 
						stack.push(peek+j);
						sb.append("+\n");
						used[peek+j] = true;
					}
				}
				
				
				
			}else {
				
				if (stack.peek()!=target) {
					while(!stack.isEmpty() && stack.peek() != target) {
						int x = stack.pop();
						used[x] = false;
						poped[x] = true;
						sb.append("-\n");
					}
				}
				//만약 빈거라면 error
				
			}
			//System.out.println(stack.peek());
			
			current = (stack.isEmpty() ? -1 :stack.pop());
			
			
			if (current != target) {
				flag = false;
				break OUT;}
			sb.append("-\n");
			used[current] = true;
			
			poped[current] = true;
			
			//System.out.println(stack);
		}
		
		
		
		if (flag == true) System.out.println(sb.toString());
		else System.out.println("NO");
		
		
	}

}
