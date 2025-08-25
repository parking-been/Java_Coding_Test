package binarySearch;
import java.io.*;
import java.util.*;
public class back_s3_11663 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> points = new ArrayList<>();
		String[] com = br.readLine().split(" ");
		N = Integer.parseInt(com[0]);
		M = Integer.parseInt(com[1]);
		
		String[] com2 = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			points.add(Integer.parseInt(com2[i]));
		}
		Collections.sort(points);
		
		for(int i=0;i<M;i++) {
			
			int count=0; // 바로 점 위에 선분의 끝점이 있을 경우
			String[] com3 = br.readLine().split(" ");
			int pm = Math.min(Integer.parseInt(com3[0]),Integer.parseInt(com3[1]));
			int pp = Math.max(Integer.parseInt(com3[0]),Integer.parseInt(com3[1]));
			int left = lowerBound(points, pm);
			int right = upperBound(points, pp);
			//System.out.println(pm+" " + left + " "+ right);
			sb.append(right-left).append('\n');
		}
		System.out.println(sb.toString());
		
		
	}
	//첫번 째로 key이상이 나오는 인덱스
	public static int lowerBound(List<Integer> arr, int key) {
		int l=0; 
		int r=arr.size();
		while(l<r) {
			int m = (l+r)/2;
			if(arr.get(m) >= key) r=m;
			else l = m+1;
		}
		return l;
	}
	// 첫번 째로 key 초과가 나오는 인덱스
	public static int upperBound(List<Integer> arr, int key) {
		int l=0,r=arr.size();
		while(l<r) {
			int m = (l+r)/2;
			if(arr.get(m)>key) r=m;
			else l = m+1;
		}
		return l;
	}

}
