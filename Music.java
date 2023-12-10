public class Music {
  String title;
  String artist;
  int year;

  public Music(String title, String artist, int year) {
    this.title = title;
    this.artist = artist;
    this.year = year;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return this.artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}