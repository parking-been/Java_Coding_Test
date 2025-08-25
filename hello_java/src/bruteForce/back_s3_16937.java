package bruteForce;
import java.io.*;
import java.util.*;
public class back_s3_16937 {
	
	static int H,W,N;
	static int[][] sticker ; 
	static int[][] c = {{0,0},{0,1},{1,0},{1,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		W = scan.nextInt();
		N = scan.nextInt();
		sticker = new int[N][2];
		for(int i=0;i<N;i++) {
			sticker[i][0] = scan.nextInt();
			sticker[i][1] = scan.nextInt();
			
		}
		int max_value = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				int val = calculate(i,j);
				if (val!=-1 && val > max_value) {
					max_value = val;
				}
			}
		}
		System.out.println(max_value);
		
		
//		for(int[] ele : sticker) {
//			for(int e : ele) {
//				System.out.print(e + " ");
//			}
//			System.out.println();
//		}
	}
	public static int calculate(int i, int j) {
		for (int[] order : c) {
			int a1 = sticker[i][(0+order[0])%2];
			int a2 = sticker[i][(1+order[0])%2];
			int b1 = sticker[j][(0+order[1])%2];
			int b2 = sticker[j][(1+order[1])%2];
			
			boolean t1 = ((Math.max(a1,b1)<=H) && (a2 + b2)<=W);
			boolean t2 = ((Math.max(a2,b2)<=W) && (a1 + b1)<=H);
			if (t1 || t2) {
				return a1*a2 + b1*b2;
			}
		}
		
		return -1;
	}

}
