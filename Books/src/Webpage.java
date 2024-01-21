public class Webpage implements Publication{

  private final String title, url;

  private final int dateDownloaded;


  public Webpage(String title, String url, int dateDownloaded) {
    this.title = title;
    this.url = url;
    this.dateDownloaded = dateDownloaded;
  }

  @Override
  public String citeApa() {
    return "" + title + ". Retrieved " + dateDownloaded + ", from " + url + ".";
  }

  @Override
  public String citeMla() {
    return "\"" + title + ".\" Web. " + dateDownloaded + " <" + url + ">.";
  }
}
