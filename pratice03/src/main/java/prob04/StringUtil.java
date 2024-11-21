package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String resultString  = "";
		
		for(int i = 0; i < strArr.length; i++) {
			resultString += strArr[i];
		}
	
		return resultString;
	}
}
