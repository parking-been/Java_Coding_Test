package bruteForce;

import java.io.*;
import java.util.*;

public class back_s5_14721 {
	static int label0 = 0;
	static int label1 = 0;
	static int personNum = -1;
	
	static int A, T, L ;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		A = scan.nextInt();
		T = scan.nextInt();
		L = scan.nextInt();
		
		
		
		int round = 1;
		OUT:
		while(true) {
			
			if(Count(0)) break OUT;
			if(Count(1)) break OUT;
			if(Count(0)) break OUT;
			if(Count(1)) break OUT;
			
			for(int i=0;i<(round+1);i++) {
				if(Count(0)) break OUT;
			}
			for(int i=0;i<(round+1);i++) {
				if(Count(1)) break OUT;
			}
			round +=1;
			
		}
		System.out.println(personNum);
		
		
		
		
	}
	
	//return 1 이면 stop 하기
	public static boolean Count(int label) {
		
		//personNum+=1;
		personNum = (personNum+1)%(A);
		//System.out.println("디버깅중" + personNum);
		
		if (label == 0) label0 +=1;
		else label1 +=1;
		
		if ((L==0 && label0 == T)||(L==1 && label1 == T)) return true;
		
		return false;
		
	}
	
	
}
