package bruteForce;

import java.io.*;
import java.util.*;

public class back_s4_16439 {
	static int[][] favers ;
	static int N, M;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		//다른 사람들은 입력 어떻게 받았는지 확인하기
		
		favers = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				favers[i][j] = scan.nextInt();
				
			}
			
		}
		
		int satis;
		int max_satis=0;
		for (int i=0;i<M-2;i++) {
			for(int j=i+1;j<M-1;j++) {
				for(int k=j+1;k<M;k++) {
					
					satis = 0;
					for(int t=0;t<N;t++) {
						//각 사람마다 만족도를 구한다.
						satis +=Math.max(favers[t][i],Math.max(favers[t][j],favers[t][k]));
					}
					if (satis > max_satis) max_satis = satis;
				}
			}
		}
		System.out.println(max_satis);
		
		
		
//		for (int[] arrays : favers) {
//			for(int ar : arrays) {
//				System.out.print(ar+" ");
//			}
//			System.out.println();
//		}
		
		
	}
	
	public static int max_value(int a, int b, int c) {
		if (a>b && a>c) {
			return a;
		}
		else if(b>a && b>c) {
			return b;
		}
		else {
			return c;
		}
	}
}
