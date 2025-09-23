package graphTraversal;
import java.io.*;
import java.util.*;
public class back_s1_16918 {
	static int R,C,N;
	static char[][] map;
	static int[][] count;
	static boolean[][] visited;
	static int[][] move = {{0,0},{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] com = br.readLine().split(" ");
		R = Integer.parseInt(com[0]);
		C = Integer.parseInt(com[1]);
		N = Integer.parseInt(com[2]);
		map = new char[R][C];
		count = new int[R][C];
		
		for(int i=0;i<R;i++) {
			String com2 = br.readLine();
			for(int j=0;j<C;j++) {
				char x = com2.charAt(j);
				map[i][j] = x;
				if (x=='O') {
					count[i][j]=2;
				}
				else count[i][j] = 0;
			}
		}
		
		for(int i=2;i<=N;i++){
			if (i%2==0) {
				//폭탄놓기
				setBomb();
			}
			else {
				//터뜨리기
				outBomb();
			}
			
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//System.out.print(count[i][j] + " ");
				sb.append(count[i][j]!=0?"O":".");
			}
			//System.out.println();
			sb.append("\n");
		}
		
		//System.out.println();
		System.out.println(sb);
		
		
		
	}
	static void setBomb() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++)
				count[i][j]++;
		}
	}
	static void outBomb() {
		//일단 터뜨리기
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(count[i][j]==3) {
					for(int[] e: move) {
						int c_x = i + e[0];
						int c_y = j + e[1];
						if(c_x<0 || c_y<0 || c_x>=R || c_y >=C)continue;
						visited[c_x][c_y]=true;
					}
				}
			}
		}
		//0이 아닌 살아남은 부분은 ++ 해주기
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(visited[i][j]==true)count[i][j]=0;
				else count[i][j]++;
			}
		}
		
	}

}
