package test;
import java.io.*;
import java.util.*;

public class bufferedReader_test {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine(); // ������ ���ڿ� ��ȯ 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ���� �б�. 
		
	}
}
