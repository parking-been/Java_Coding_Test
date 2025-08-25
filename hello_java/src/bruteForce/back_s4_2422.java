package bruteForce;
import java.io.*;
import java.util.*;

public class back_s4_2422 {
	static Set<String> badCombi = new HashSet<>();
	static int N, M;
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		for(int i=0 ; i<M ; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			String key = Math.min(a,b) + "," + Math.max(a,b);
			badCombi.add(key);
		}
		//System.out.println(badCombi);
		int count=0;
		
		for(int i=1; i<=N-2;i++) {
			for(int j=i+1; j<=N -1;j++) {
					if(badCombi.contains(key(i,j))) continue;
				for(int k=j+1; k<=N ; k++) {
					//System.out.println(i+" "+j+" "+k);
					if (badCombi.contains(key(i,k))||badCombi.contains(key(j,k))) continue;
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		
		
		
	}
	
	private static String key(int a, int b) {
		return Math.min(a,b)+","+Math.max(a,b);
	}

}
