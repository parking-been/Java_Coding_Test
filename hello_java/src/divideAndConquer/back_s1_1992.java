package divideAndConquer;
import java.io.*;
import java.util.*;
public class back_s1_1992 {
	static int N;
	static boolean[][] picture;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		picture = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			picture[i] = new boolean[N];
			String[] com1 = br.readLine().split("");
			for(int j=0;j<N;j++) {
				picture[i][j] = (Integer.parseInt(com1[j])==0?false:true);
				//System.out.print(picture[i][j] + " ");
			}
			//System.out.println();
		}
		quadTree(0,N-1,0,N-1);
		System.out.println(sb.toString());
		
		
	}
	public static void quadTree(int x_r, int x_l, int y_r, int y_l) {
		if(x_r == x_l) {
			sb.append((picture[x_r][y_r]==true?1:0));
			return;
		}
		
		boolean tmp = picture[x_r][y_r];
		
		for(int i=x_r;i<=x_l;i++) {
			for(int j=y_r;j<=y_l;j++) {
				if(tmp!=picture[i][j]) {
					//다시 돌리기
					sb.append("(");
					int x_mid = (x_r+x_l)/2;
					int y_mid = (y_r + y_l)/2;
					quadTree(x_r,x_mid,y_r,y_mid);
					quadTree(x_r,x_mid,y_mid+1,y_l);
					quadTree(x_mid+1,x_l,y_r,y_mid);
					quadTree(x_mid+1,x_l,y_mid+1,y_l);
					
					sb.append(")");
					return;
				}
			}
		}
		sb.append((tmp==true?1:0));
		
	}

}
