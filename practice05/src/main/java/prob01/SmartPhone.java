package prob01;

public class SmartPhone extends MusicPhone {
	
	public void execute(String function) {
		if(function.equals("음악")) {
			playMusic();
		}
		else if(function.equals("통화")) {
			super.execute(function);
		}
		else if(function.equals("앱")) {
			System.out.println("앱실행");
		}
	}
	
	@Override
	public void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
}
