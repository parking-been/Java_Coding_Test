package bruteForce;
import java.io.*;
import java.util.*;
public class back_s3_14501 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] maxP;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		T = new int[N];
		P = new int[N];
		maxP = new int[N+1];
		int result = 0;
		for(int i=0;i<N;i++) {
			T[i] = scan.nextInt();
			P[i] = scan.nextInt();
		}
		
		for(int i=N-1;i>=0;i--) {
			//0~N-1
			if (i+ T[i]>N) maxP[i]=result;
			
			else {
				maxP[i] = Math.max(P[i] + maxP[i+T[i]],result);
			}
			if (result < maxP[i]) result = maxP[i];
		}
		
		//for(int e : maxP) System.out.print(e+ " ");
		//System.out.println();
		System.out.println(result);
	}

}
