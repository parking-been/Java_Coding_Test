package Greedy;
import java.io.*;
import java.util.*;
public class back_s2_16953 {
	static int A, B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com = br.readLine().split(" ");
		A = Integer.parseInt(com[0]);
		B = Integer.parseInt(com[1]);
		int count=0;
		int flag = 0; // 만들 수 없다.
		while(B>A) {
			if(B%2==0) { // 짝수이면
				B = B/2;
			}
			else if((B-1)%10==0){ // 홀수이자 뒷자리수가 1이라면
				B = (B-1)/10;
			}
			else { // 그것도 아니라면..
				break;
			}
			count++;
			//System.out.println(B);
			if(B==A) {
				flag =1;
				break;
			}
		}
		System.out.println(flag==0?-1:count+1);
		
		
	}

}
