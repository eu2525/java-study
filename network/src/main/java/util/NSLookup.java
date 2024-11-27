package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
//			Scanner scanner = new Scanner(System.in);			
			InetAddress[] inetAddress = InetAddress.getAllByName("www.poscodx.com");
			for (InetAddress inet : inetAddress) {
				System.out.println(inet.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
