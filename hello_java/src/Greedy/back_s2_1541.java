package Greedy;
import java.io.*;
import java.util.*;
public class back_s2_1541 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String com = br.readLine();

		//System.out.println(com.length());
		int tmp = 0;
		int result = 0;
		int flag = 0;
		char pre_m = '*';
		for(int i=0;i<com.length();i++) {
			char cur = com.charAt(i);
			
			
			if(cur=='+' || cur == '-') {
				if(pre_m=='*') {
					result = tmp;
				}
				else if(pre_m =='-') {
					result -=tmp;
					flag = 1;
				}else {
					if(flag == 1) result -=tmp;
					else result+=tmp;
				}
				pre_m = cur;
				tmp = 0;
			}
			
			else {
				tmp = tmp*10 + (int)(cur-'0');
			}
			
			if(i==com.length()-1) {
				if(pre_m =='-') {
					result -=tmp;
					flag = 1;
				}else {
					if(flag == 1) result -=tmp;
					else result+=tmp;
				}
			}
			
			//System.out.println(result);
			
		}
		
		System.out.println(result);
	}

}
