package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s3_1935 {
	static int N;
	static Map<Character,Double> map = new HashMap<>(); // H가 대문자였구낭!
	static Stack<Double> stack = new Stack<>();
	public static void main (String[] args)throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] formula = br.readLine().toCharArray();
		
		//딕셔너리로 저장하자. 
		for(int i=0;i<N;i++) {
			map.put((char)((int)('A')+i),Double.parseDouble(br.readLine()));
		}
		//System.out.println(map);
		//System.out.println(formula.length);
		char target;
		double c=0;
		
		
		for(int i=0;i<formula.length;i++) {
			target = formula[i];
			if(target>='A' && target<='Z') {
				stack.push(map.get(target));
			}
			else {
				double b = (stack.pop());
				double a = (stack.pop());
				
				//switch문 밖에 없나?..
				switch(target) {
				case '+':
					c = a+b;
					break;
				case '-':
					c = a-b;
					break;
				case '*':
					c = a*b;
					break;
				case '/':
					c = a/b;
					break;
				default:
					System.out.println("알수없는 연산자"+ target);
					break;
				}
				stack.push(c);
				//System.out.println(c);
				
			}
			
		}
		
		System.out.printf("%.2f\n",stack.pop());
		
		
	}

}
