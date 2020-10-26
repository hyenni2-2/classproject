package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StringReader {

	public static void main(String[] args) throws IOException {
		
		// 문자 기반 기본 스트림 인스턴스 생성
		Reader reader = new FileReader("String.txt");
		// 필터 스트림 BufferedReader는 기본 스트림이 필요
		BufferedReader in = new BufferedReader(reader);
		
		// 한 행의 문자열을 담을 변수, 지역변수이므로 null해주는게 좋음.
		String str = null;
		while(true) {
			// 한 줄을 읽어 문자열을 반환 : 반환할 문자열이 없으면 null 반환
			str=in.readLine();
			if(str==null) {  //마지막 라인이라면 : 더 이상 가져올 문자열이 없다.
				break;
			}
			System.out.println(str);
		}
		in.close();
	}

}
