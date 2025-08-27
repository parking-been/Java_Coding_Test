package dynamicProgramming1;
import java.io.*;
import java.util.*;
public class back_b2_10870 {
	static int N;
	static Map<Integer, Long> ffi = new HashMap<>();
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		//재귀로 풀어보자 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ffi.put(0,(long)0);
		ffi.put(1,(long)1);
		
		long result = fibo(N);
		System.out.println(result);
	}
	
	public static long fibo(int n) {
		if(ffi.containsKey(n))return ffi.get(n);
		long result = (ffi.containsKey(n-2)?ffi.get(n-2):fibo(n-2)) + (ffi.containsKey(n-1)?ffi.get(n-1):fibo(n-1));
		ffi.put(n, result);
		return result;
	}

}
