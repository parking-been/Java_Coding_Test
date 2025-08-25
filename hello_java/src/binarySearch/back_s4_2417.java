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
			if (mid == 0) { // 0 ó��(������ ȸ��)
		        if (N == 0) { result = 0; break; }
		        start = 1;
		        //System.out.println("�ȳ��ϼ���1 " + result);
		        continue;
		        
			}

		    // mid*mid >= N �� �����÷ο� ���� �˻�:  mid >= N / mid  <=>  mid*mid >= N
		    if (mid >= N / mid + (N%mid!=0 && mid == N/mid?1:0)) {
		        result = mid;
		        end = mid - 1;
		        //System.out.println("�ȳ��ϼ���2 " + result);
		        
		        
		    } else {
		        start = mid + 1;
		        //System.out.println("�ȳ��ϼ���3 " + result);
		    }
		}
		System.out.println(result);
		
	}

}
