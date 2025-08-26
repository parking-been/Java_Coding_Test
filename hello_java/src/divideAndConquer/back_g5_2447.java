package divideAndConquer;
import java.io.*;
import java.util.*;
public class back_g5_2447 {
	static int N;
	static int[][] faces = {{0,0},{0,1},{0,2},
							{1,0},{1,2},
							{2,0},{2,1},{2,2}};
	static char[][] stars;
	public static void main (String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		for(int i=0;i<N;i++) {
			//stars[i] = new char[N];
			Arrays.fill(stars[i], ' '); //빠른 초기화 
		}
		star(0,N-1,0,N-1);
		//빠른 출력
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) sb.append(stars[i]).append("\n");
		
		System.out.println(sb);
		
		
	}
	public static void star(int x_l, int x_r, int y_l, int y_r) {
		//n은 한변의 길이
		if(x_r==x_l ) {stars[x_r][y_r] = '*'; return;} 
		
		int size = x_r - x_l +1;
		int m_size = size/3;
		
		for(int[] ele : faces) {
			int n_x_l = x_l + m_size*ele[0];
			int n_x_r = n_x_l + m_size-1;
			int n_y_l = y_l + m_size*ele[1];
			int n_y_r = n_y_l + m_size-1;
			star(n_x_l, n_x_r, n_y_l, n_y_r);
		}
		
	}

}
