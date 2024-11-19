package prob05;

public class Sol05 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			String number = String.valueOf(i);
			int cnt = 0;
			for(int j = 0; j <number.length(); j++) {
				if(number.charAt(j) == '3' || number.charAt(j) == '6' || number.charAt(j) == '9')
					cnt += 1;
			}
			
			if (cnt != 0){
				System.out.print(number + " ");
				for(int k = 0; k < cnt; k++) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}
}
