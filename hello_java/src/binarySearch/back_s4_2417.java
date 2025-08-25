package binarySearch;
import java.io.*;
import java.util.*;
public class back_s4_2417 {
	static long N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long start = 0;
		long end = N;
		long result = 0;
		
		while(start <= end ) {
			long mid = (start+end)/2;
			if (mid == 0) { // 0 처리(나눗셈 회피)
		        if (N == 0) { result = 0; break; }
		        start = 1;
		        //System.out.println("안녕하세요1 " + result);
		        continue;
		        
			}

		    // mid*mid >= N 을 오버플로우 없이 검사:  mid >= N / mid  <=>  mid*mid >= N
		    if (mid >= N / mid + (N%mid!=0 && mid == N/mid?1:0)) {
		        result = mid;
		        end = mid - 1;
		        //System.out.println("안녕하세요2 " + result);
		        
		        
		    } else {
		        start = mid + 1;
		        //System.out.println("안녕하세요3 " + result);
		    }
		}
		System.out.println(result);
		
	}

}
