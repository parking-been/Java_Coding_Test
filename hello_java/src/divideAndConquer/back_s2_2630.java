package divideAndConquer;
import java.io.*;
import java.util.*;
public class back_s2_2630 {
	static int N;
	static boolean[][] paper;
	static int true_count = 0;//1
	static int false_count = 0;//0
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			paper[i] = new boolean[N];
			String com[] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				paper[i][j] = (Integer.parseInt(com[j])==0?false:true);
			}
		}
		cutting(0,N-1,0,N-1);
		System.out.println(false_count);
		System.out.println(true_count);
		
//		for(boolean[] eles : paper) {
//			for(boolean ele : eles) {
//				System.out.print(ele + " ");
//			}
//			System.out.println();
//		}
		
	}
	static void cutting(int x_l, int x_r, int y_l, int y_r) {
		//현재 종이가 1칸이거나 모두 파란색 or 하얀색이라면, 
		if(x_r==x_l) {
			if (paper[x_l][y_l]==true) true_count++;
			else false_count++;
			return;
		}
		int flag = check(x_l, x_r, y_l,y_r);
		if(flag !=0) {
			if (flag == 1) false_count++;
			else true_count++;
			return;
		}
		
		int x_mid = (x_l + x_r)/2;
		int y_mid = (y_l + y_r)/2;
		cutting(x_l, x_mid,y_l,y_mid);
		cutting(x_l, x_mid,y_mid+1,y_r);
		cutting(x_mid+1,x_r ,y_l,y_mid);
		cutting(x_mid+1, x_r,y_mid+1,y_r);
		
		
	}
	static int check(int x_l, int x_r, int y_l, int y_r) {
		//만약 모두 true면, 2
		//만약 모두 false면, 1
		//아무것도 아니면 0
		boolean target = paper[x_l][y_l];
		for(int i=y_l;i<=y_r;i++) {
			for(int j=x_l; j<=x_r;j++) {
				if(target!=paper[j][i]) return 0;
			}
		}
		return (target==true?2:1);
	}

}
