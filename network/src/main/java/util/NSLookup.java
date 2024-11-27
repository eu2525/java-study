package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);		
			String scanner_str = null;
			while (true) {
				scanner_str = scanner.nextLine();
				if(scanner_str.equals("exit")) {
					return;
				}
				InetAddress[] inetAddress = InetAddress.getAllByName(scanner_str);
				for (InetAddress inet : inetAddress) {
					System.out.println(scanner_str + " : " + inet.getHostAddress());
				}	
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
