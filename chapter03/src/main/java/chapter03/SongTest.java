package chapter03;

public class SongTest {

	public static void main(String[] args) {
		// Song을 하고 나서 Setting 을 하는게 너무 많음
		// 생성자에다가 바로 넣게 만들수도 있음.
//		Song song = new Song();
//		song.setAlbum("Real");
//		song.setArtist("아이유");
//		song.setTitle("좋은날");
//		song.setComposer("이민수");		
//		song.setYear(2010);
//		song.setTrack(3);
		Song song = new Song("Real", "아이유", "좋은날", "이민수", 2010, 3);
		
		song.show();
		
		//생성자 오버로딩
		Song song2 =new Song("New Jeans", "Ditto");
		
		song2.show();
		
		
	}
}
