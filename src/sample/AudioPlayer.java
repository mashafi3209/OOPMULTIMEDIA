package sample;

public class AudioPlayer extends Product implements MultimediaControl {

  private String audioSpecification ;
  private String mediaType ;

  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer, mediaType);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  @Override
  public void play() {
    System.out.println("Playing");

  }

  @Override
  public void stop() {
    System.out.println("Stopped");


  }

  @Override
  public void previous() {
    System.out.println("Previous");

  }

  @Override
  public void next() {
    System.out.println("next");

  }
  public void ToString()
  {
    System.out.print(super.toString());
    System.out.print("\n Audio specification: "+this.audioSpecification+" \n Media Type: "+this.mediaType);
  }

}
