public class Slide{
  public static final int MAX_BULLETS = 5;
  private String title;
  private double duration;

  public Slide(){
    duration = 0.0;
  }

  public Slide(String newTitle, double newDuration){
    title = newTitle;
    duration = newDuration;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String newTitle){
    if (newTitle != null){
      title = newTitle;
    }
    else throw new IllegalArgumentException();
  }

  public double getDuration(){
    return duration;
  }

  public void setDuration(double newDuration){
    if (newDuration > 0.0){
      duration = newDuration;
    }
    else throw new IllegalArgumentException();
  }

  public int getNumBullets(){

  }

  public String getBullet(int i){

  }

  public void setBullet(String bullet, int i){

  }

  
}
