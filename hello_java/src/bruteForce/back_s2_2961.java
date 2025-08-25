package bruteForce;
import java.io.*;
import java.util.*;
public class back_s2_2961 {
	static int N;
	static int[] S;
	static int[] B;
	static int[][] combi;
	static int total;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		S = new int[N];
		B = new int[N];
		total = 1<<N;
		//System.out.println(N);
		for(int i=0;i<N;i++) {
			S[i] = scan.nextInt();
			B[i] = scan.nextInt();
		}
		makeCombi();
		int c_s;
		int c_b;
		int opt_taste=Integer.MAX_VALUE;
		int c_taste;
		for(int i=1;i<total;i++) {
			c_s = 1;
			c_b = 0;
			for(int j=0;j<N;j++) {
				if (combi[i][j]==1) {
					c_s *=S[j];
					c_b +=B[j];
				}
			}
			c_taste = Math.abs(c_s-c_b);
			if (opt_taste > c_taste) {
				opt_taste = c_taste;
			}
			
		}
		System.out.println(opt_taste);
		
	}
	public static void makeCombi() {
		
		//System.out.println("디버깅중입니다.");
		//System.out.println(total);
		combi = new int[total][N];
		for(int j=0;j<total;j++) {
			for(int i=0;i<N;i++) {
				combi[j][i] = (j>>i)&1;
			}
		}
		
//		for(int[] ele : combi) {
//			for(int e : ele) {
//				System.out.print(e+" ");
//			}
//			System.out.println();
//		}
		
	}

}
