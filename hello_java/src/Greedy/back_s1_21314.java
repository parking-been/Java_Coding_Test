package Greedy;
import java.io.*;
import java.util.*;
public class back_s1_21314 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String com = br.readLine();
		
		
		
		//System.exit(0);
		//최대값 구하기
		int m=0;
		int k=0;
		int flag = 0;
		for(int i=0;i<com.length();i++) {
			char x = com.charAt(i);
			if(x=='M') m++;
			else {
				k++;
				
				sb.append(exchange(m,k));
				m=0;
				k=0;
				flag = 1;
			}
		}
		//if(m!=0) sb.append(exchange(m,0));
		if(m!=0) {
			if (flag==0) {
				sb = new StringBuilder();
				m = com.length();
			}
			
			
			for(int i=0;i<m;i++) {
				sb.append("1");
			}
		}
		
		//sb.append()
		
		sb.append("\n");
		//최소값 구하기
		m=0;
		k=0;
		for(int i=0;i<com.length();i++) {
			char x = com.charAt(i);
			if(x=='M') m++;
			else {
				k++;
				
				if (m!=0) sb.append(exchange(m,0));
				sb.append(exchange(0,k));
				m=0;
				k=0;
			}
		}
		if(m!=0) sb.append(exchange(m,0));
		
		System.out.println(sb);
		
//		System.out.println(exchange(1,0));
//		System.out.println(exchange(0,1));
//		System.out.println(exchange(2,0));
//		System.out.println(exchange(1,1));
//		System.out.println(exchange(3,0));
//		System.out.println(exchange(2,1));
	}
	public static String exchange(int m, int k) {
		StringBuilder sb2 = new StringBuilder();
		
		if(k==0) {
			sb2.append("1");
			for(int i=1;i<m;i++) {
				sb2.append("0");
			}
			//return (int)Math.pow(10,m-1);
		}
		else {
			sb2.append("5");
			for(int i=0;i<m;i++) {
				sb2.append("0");
			}
			//return (int)Math.pow(10,m)*5;
		}
		return sb2.toString();
	}

}
