package test;
import java.io.*;
import java.util.*;

public class bufferedReader_test {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine(); // 무조건 문자열 반환 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 한줄 읽기. 
		
	}
}
