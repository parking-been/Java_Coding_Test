package bruteForce;
import java.io.*;
import java.util.*;
public class back_s3_16508 {
	static String T;
	static int bookNum ;
	static int[] prices;
	static String[] titles;
	static int[][] bTuple;
	static int total;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		T = scan.next();
		bookNum = scan.nextInt();
		
		prices = new int[bookNum];
		titles = new String[bookNum];
		
		for(int i=0;i<bookNum;i++) {
			prices[i] = scan.nextInt();
			titles[i] = scan.next();
		}
		
		BinaryTuple();
		String c_string = null;
		int c_price = 0;
		int minprice = Integer.MAX_VALUE;
		for(int i=1;i<total;i++) {
			c_string = null;
			c_price = 0;
			for(int j=0;j<bookNum;j++) {
				if (bTuple[i][j] == 1) {
					c_string = c_string + titles[j];
					c_price = c_price + prices[j];
				}
			}
			if (check(c_string)==1 && c_price <=minprice) {
				minprice = c_price;
			};
			
		}
		if (minprice == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minprice);
		
//		for(int[] ele : bTuple) {
//			for(int e : ele) {
//				System.out.print(e+" ");
//			}
//			System.out.println();
//		}
		
		
		
	}
	
	public static int check(String s) {
		//dictionary »≠
		Map<Character,Integer> c = new HashMap<>();
		for(char e : s.toCharArray()) {
			if (c.containsKey(e)) {
				c.put(e, c.get(e)+1);
			}
			else {
				c.put(e,1);
			}
		}
		//System.out.println(c);
		//title »Æ¿Œ
		for (char e : T.toCharArray()) {
			if(c.containsKey(e)) {
				if (c.get(e)==1){
					c.remove(e);
				}
				else {
					c.put(e,c.get(e)-1);
				}
				
			}
			else {
				return -1;
			}
		}
		return 1;
	}
	
	public static void BinaryTuple() {
		total = 1 << bookNum; //2^N
		bTuple = new int[total][bookNum];
		for(int i=0;i<total;i++) {
			for (int j=0;j<bookNum;j++) {
				bTuple[i][j] = (i >> j) & 1;
			}
		}
	}
	
	

}
