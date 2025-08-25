package bruteForce;
import java.io.*;
import java.util.*;

public class back_s2_14620 {
	static int N;
	static int[][] yard;
	static int[][] yardsPrices;
	static List<int[]> positions = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		
		yard = new int[N][N];
		yardsPrices = new int[N-2][N-2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				yard[i][j] = scan.nextInt();
			}
		}
		
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<N-2;j++) {
				positions.add(new int[] {i,j});
			}
		}
		
//		System.out.println(positions);
//		System.out.println(positions.size());
//		//디버깅용
//		for(int[] row : yard) {
//			for(int ele : row) {
//				System.out.print(ele + " ");
//			}
//			System.out.println();
//		}
		int minPrice = Integer.MAX_VALUE;
		int c_price = 0;
		//미리 가격 계산해두기. 
		int[][] pre = {{1,0},{0,1},{1,1},{2,1},{1,2}};
		int c_p = 0;
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<N-2;j++) {
				c_p=0;
				for (int[] ele : pre) {
					c_p+=yard[i+ele[0]][j+ele[1]];
				}
				yardsPrices[i][j] = c_p; 
			}
		}
		
		for(int i=0;i<positions.size()-2;i++) {
			
			for(int j=i+1;j<positions.size()-1;j++) {
				if(!CalLength(positions.get(i),positions.get(j))) continue;  // get(i) 까먹지 말자
				for(int k=j+1;k<positions.size();k++) {
					if(!CalLength(positions.get(i),positions.get(k)) || !CalLength(positions.get(k),positions.get(j))) continue;
					c_p = 0;
					int[] a = positions.get(i);
					int[] b = positions.get(j);
					int[] c = positions.get(k);
					c_p = yardsPrices[a[0]][a[1]] + yardsPrices[b[0]][b[1]] + yardsPrices[c[0]][c[1]];
					if (minPrice > c_p) minPrice = c_p;
				}
			}
		}
		
		System.out.println(minPrice);
		
		//디버깅용
//		for(int[] row : yardsPrices) {
//			for(int ele : row) {
//				System.out.print(ele + " ");
//			}
//			System.out.println();
//		}
//		
		
		
		
	}
	
	public static boolean CalLength(int[] a, int[] b) {
		double result = Math.sqrt(Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2));
		if (result <=2) return false;
		else return true;
		
	}

}
