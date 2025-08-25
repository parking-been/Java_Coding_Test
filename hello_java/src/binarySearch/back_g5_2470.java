package binarySearch;
import java.io.*;
import java.util.*;
public class back_g5_2470 {
	static int N;
	static List<Long> array = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String[] com = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) {
			array.add(Long.parseLong(com[i]));
		}
		
		Collections.sort(array);
		long best=Long.MAX_VALUE;
		int l=0;
		int r=N-1;
		
		//System.out.println(-Collections.binarySearch(array,(long)1000)-1);
		for(int i=0;i<array.size();i++) {
			long target = -array.get(i);
			int idx = lowerBound(target);
			
			//후보 1 : idx-1;
			int j=idx-1;
			if(j>=0 && j!=i) {
				long abs = Math.abs(array.get(i)+ array.get(j));
				if(abs<best) {best = abs; l=Math.min(i,j); r = Math.max(i,j);}
			}
			//후보 2 : idx
			j=idx;
			if(j<N && j!=i) {
				long abs = Math.abs(array.get(i)+ array.get(j));
				if(abs<best) {best = abs; l=Math.min(i,j); r = Math.max(i,j);}
			}
			
			
			
		}
		
		System.out.println(array.get(l) + " " + array.get(r));
		
	}
	static int lowerBound(long key) { //첫 >=key 위치
		int l=0,r=N;
		while(l<r) {
			int m = (l+r)/2;
			if(array.get(m)>=key) r=m;
			else l=m+1;
		}
		return l;
	}

}
