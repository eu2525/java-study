package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
	
	// 생성자 오버로딩 예시
	public Song(String artist, String title) {
		// 반복 작업 줄이기 -> 밑에 있는 생성자가 불림.
		// 유지보수가 쉬워짐 이전 처럼 생성자마다 print 구문을 고치려면 힘들지만 
		// 생성자에서는 this를 통해서 하나의 생성자를 부르고, 그 생성자를 고치는 방향으로 코딩.
		this("", artist, title, "", 0, 0);

//		this.title = title;
//		this.artist = artist;		
//		System.out.println("some code1");
//		System.out.println("some code2");
//		System.out.println("some code3");
//		System.out.println("some code4");
	}
	
	public Song(String album, String artist, String title, String composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;

		System.out.println("some code1");
		System.out.println("some code2");
		System.out.println("some code3");
		System.out.println("some code4");
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	
	public void show() {
		System.out.println(
			artist + " " + 
			title + "(" +
			album + ", " + year + ", " + track + "번 track, " + composer + " 작곡)"
		);
	}
	
}
