package divideAndConquer;
import java.io.*;
import java.util.*;
public class back_g5_1074 {
	static int N, r, c;
	static int count;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] com1 = br.readLine().split(" ");
		N = Integer.parseInt(com1[0]);
		r = Integer.parseInt(com1[1]);
		c = Integer.parseInt(com1[2]);
		int N_t = (int)Math.pow(2,N);
		checkZ(0,N_t-1,0,N_t-1);
		System.out.println(count);
		
		
	}
	public static void checkZ(int x_l, int x_r, int y_l, int y_r) {
		if (x_l==x_r) return;
		
		
		int x_mid = (x_l + x_r)/2;
		int y_mid = (y_l + y_r)/2;
		int face=0;
		int n_x_l , n_x_r, n_y_l ,n_y_r ; 
		if(r<=x_mid && c<=y_mid) {
			face = 0;
			n_x_l = x_l; n_x_r = x_mid; n_y_l = y_l; n_y_r = y_mid;
		}
		else if(r<=x_mid && c>y_mid) {
			face = 1;
			n_x_l = x_l; n_x_r = x_mid; n_y_l = y_mid+1; n_y_r = y_r;
		}
		else if(r>x_mid && c<=y_mid) {
			face = 2;
			n_x_l = x_mid+1; n_x_r = x_r; n_y_l = y_l; n_y_r = y_mid;
		}
		else {
			face = 3;
			n_x_l = x_mid+1; n_x_r = x_r; n_y_l = y_mid+1; n_y_r = y_r;
		}
		int size = ((x_r-x_l+1)/2);
		checkZ(n_x_l, n_x_r, n_y_l,n_y_r);
		count+=size*size*face;
		
	}

}
