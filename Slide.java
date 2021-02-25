public class Slide{
  public static final int MAX_BULLETS = 5;
  private String title;
  private String[] bullets = new String[MAX_BULLETS];
  private double duration;
  private int bulCount;

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
    return bulCount;
  }

  public String getBullet(int i){
    String bullet = "";
    if (i >= 1 && i <= MAX_BULLETS){
      bullet += bullets[i-1];
      return bullet;
    }
    else throw new IllegalArgumentException();
  }

  public void setBullet(String bullet, int i){
    if (i >= 1 && i <= MAX_BULLETS){
      if (bullet != null){
        bullets[i-1] = bullet;
        bulCount++;
      }
      if (bullet == null){
        int count = this.getNumBullets();
        for (int inc = i; inc < count; inc++){
          bullets[i-1] = bullets[i];
        }
        if (count > 0){
        bulCount--;
      }
      }
    }
    else throw new IllegalArgumentException();
  }

  public String toString(){
    String toPrint = "Slideshow Summary:";
    toPrint += "\n================================================================\n";
    toPrint += this.getTitle();
    toPrint += "\n================================================================\n";
    for (int i = 1; i < bulCount; i++){
      toPrint += i + ". " + this.getBullet(i);
    }
    toPrint += "\n================================================================\n";
    return toPrint;
  }

  public static void main(String[] args) {
    Slide test = new Slide("chicken", 12.4);
  }




}
