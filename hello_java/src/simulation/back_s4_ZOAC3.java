package simulation;
import java.io.*;
import java.util.*;

//dp 를 써야할듯하다. 시간이 초과됨 
public class back_s4_ZOAC3 {
	static Map<Character,int[]> keyboard = new HashMap<>();
	static Character s_l, s_r;
	static String target;
	static int t_len;
	//static int depth = 0;
	static int c_price = 0;
	//static int min_price = Integer.MAX_VALUE;
	//static int[][][] dp; //dp[현재 인덱스][왼손 위치][오른손 위치]
	public static void main(String[] args) {
		
		String[] keyb1 = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		for(int i=0;i<keyb1.length;i++) {
			char[] keyb2 = keyb1[i].toCharArray(); // 새로운 메소드기억하자
			for(int j=0;j<keyb2.length;j++) {
				keyboard.put(keyb2[j],new int[] {i,j});
			}
		}
		
//		for(Character c : keyboard.keySet()) {
//			System.out.println(c+"+"+keyboard.get(c)[0]+","+keyboard.get(c)[1]);
//		}
		
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		s_l = scan.next().charAt(0); // string에서 인덱스 사용법 기억
		s_r = scan.next().charAt(0);
		target = scan.next();
		t_len = target.length();
		
		String left = "qwertasdfgzxcv";
		for(int i=0;i<t_len;i++) {
			char c = target.charAt(i);
			
			if (left.indexOf(c)!=-1) {
				//left
				c_price +=distance(c,s_l)+1;
				s_l = c;
				
			}else {
				c_price +=distance(c,s_r)+1;
				s_r = c;
			}
			
		}
		System.out.println(c_price);
		
		
	}
	
	public static int distance(char a, char b) {
		int [] p = keyboard.get(a);
		int [] n = keyboard.get(b);
		
		return Math.abs(p[0]-n[0])+Math.abs(p[1]-n[1]);
	}

}
