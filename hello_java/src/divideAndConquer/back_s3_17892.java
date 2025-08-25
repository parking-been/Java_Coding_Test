package divideAndConquer;
import java.io.*;
import java.util.*;
public class back_s3_17892 {
	static int N;
	static int[][] array;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for(int i=0;i<N;i++) {
			array[i] = new int[N];
			String[] com = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(com[j]);
			}
		}
		
		int result = divide(0,N-1,0,N-1);
		System.out.println(result);
//		for(int[] eles : array) {
//			for(int ele : eles) {
//				System.out.print(ele + " ");
//			}
//			System.out.println();
//		}
		
		
		
		
	}
	public static int divide(int x_l, int x_r, int y_l, int y_r) {
		if(x_l==x_r && y_l== y_r) return array[x_l][y_l];
		int x_mid = (x_l+x_r)/2;
		int y_mid = (y_l + y_r)/2;
		
		int a = divide(x_l, x_mid, y_l, y_mid);
		int b = divide(x_l, x_mid, y_mid+1, y_r);
		int c = divide(x_mid+1, x_r, y_l, y_mid);
		int d = divide(x_mid+1, x_r, y_mid+1, y_r);
		
		int[] arr = {a,b,c,d};
		Arrays.sort(arr);
		return arr[2];
		
		
	}
	

}
