package binarySearch;
import java.io.*;
import java.util.*;
public class back_s2_2512 {
	static int N;
	static int M;
	static List<Integer> array = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] com = br.readLine().split(" ");
		int max = 0;
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(com[i]);
			array.add(n);
			if(max < n) max = n;
		}
		
		M = Integer.parseInt(br.readLine());
		
		int l = 1;
		int r = max+1;
		while(l<r) {
			int mid = (l+r)/2;
			int semi = cal(mid); // 계산한 값
			if(semi<=M) { // 아직 다 차지 않으면 
				l = mid+1;
			}
			else {
				r=mid;
			}
		}
		
		System.out.println(l-1);
		
		
		
	}
	
	public static int cal(int upper) {
		int result = 0;
		for(Integer ele : array) {
			if (ele <= upper) result +=ele;
			else result +=upper;
		}
		return result;
	}

}
