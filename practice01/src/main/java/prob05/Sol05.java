package prob05;

public class Sol05 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			// 문자열로 치환 후 길이 구해서 한 자리씩 구함
			String number = String.valueOf(i);
			
			System.out.println(number.length());
			// 얘는 \n 없이 같은 line에 출력하려면 print \n 하려면 println
			System.out.print(i);
			System.out.print(" ");
		}
		
		char c = '6';
		
		if(c == '6') {
			System.out.println("진짜다");
		}
			
	}
}
