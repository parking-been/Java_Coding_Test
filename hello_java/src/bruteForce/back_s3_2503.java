package bruteForce;
import java.io.*;
import java.util.*;
public class back_s3_2503 {
	static int N ;
	static int[][] number;
	static int[] s;
	static int[] b;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		number= new int[N][3];
		s = new int[N];
		b = new int[N];
		int count = 0;
		//입력받기
		for(int i=0;i<N;i++) {
			int num = scan.nextInt();
			
			number[i][0] = num/100;
			number[i][1] = (num%100)/10;
			number[i][2] = (num%10);
			//System.out.println(number[i][0] + " " + number[i][1] + " " + number[i][2]);	
			s[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}
		
		for(int i=1;i<10;i++) {
			for(int j=1; j<10; j++) {
				if (i==j) continue;
				for(int k=1; k<10;k++) {
					if (k==i || k==j) continue;
					count += check(i,j,k);
				}
			}
		}
		System.out.println(count);
		
	}
	public static int check(int i, int j, int k) {
		int[] target = {i,j,k};
		int c_s = 0;
		int c_b = 0;
		//틀리면 바로 돌아가기.
		for(int l=0;l<N;l++) {
			c_s = 0;
			c_b = 0;
			for(int n=0;n<3;n++) { // target
				 
				for(int m=0;m<3;m++) { //source
					if(target[m] == number[l][n] ) {
						if(m==n) c_s++;
						else c_b++;
					}
				}
					
			}
			if(c_s == s[l] && c_b == b[l]) continue;
			else return 0;
			
		}
		return 1;
	}
	
}
