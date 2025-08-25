package dataStructure1;
import java.io.*;
import java.util.*;
public class back_s3_1935 {
	static int N;
	static Map<Character,Double> map = new HashMap<>(); // H�� �빮�ڿ�����!
	static Stack<Double> stack = new Stack<>();
	public static void main (String[] args)throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] formula = br.readLine().toCharArray();
		
		//��ųʸ��� ��������. 
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
				
				//switch�� �ۿ� ����?..
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
					System.out.println("�˼����� ������"+ target);
					break;
				}
				stack.push(c);
				//System.out.println(c);
				
			}
			
		}
		
		System.out.printf("%.2f\n",stack.pop());
		
		
	}

}
