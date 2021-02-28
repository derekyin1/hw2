/** Derek Yin 113251504 Recitation Section 1
*  This class defines the Slide object, which stores a title, duration, and bullet points
*
*  @author Derek Yin
*
*/

public class Slide{
/** MAX_BULLETS represents maximum number of bullets allowed per slide.
*/
  public static final int MAX_BULLETS = 5;
  private String title;
  private String[] bullets = new String[MAX_BULLETS];
  private double duration;
  private int bulCount;
/** This constructor creates a Slide object with duration and bullet count set to 0.
*
*/
  public Slide(){
    duration = 0.0;
    bulCount=0;
  }

/** This constructor creates a Slide object with desired title and duration.
*
*@param newTitle
*Desired title of slide
*
*@param newDuration
*Desired duration of Slide
*
*/
  public Slide(String newTitle, double newDuration){
    title = newTitle;
    duration = newDuration;
    bulCount = 0;
  }

/** This method returns the title of a Slide
*
*@return
*Returns title of Slide
*
*/
  public String getTitle(){
    return title;
  }
/** This method sets the title of a Slide
*
*@param newTitle
*Desired title of a Slide.
*
*@throws
*IllegalArgumentException when newTitle is null.
*
*/
  public void setTitle(String newTitle){
    if (newTitle != null){
      title = newTitle;
    }
    else throw new IllegalArgumentException();
  }
/** This method returns the duration of a slide.
*@return
*returns duration of slide.
*
*/
  public double getDuration(){
    return duration;
  }
/** This method sets the duration of a Slide
*@param newDuration
*Desired duration of slide.
*
*@throws
*IllegalArgumentException when desired duration is less than 0.
*/

  public void setDuration(double newDuration){
    if (newDuration > 0.0){
      duration = newDuration;
    }
    else throw new IllegalArgumentException();
  }
/** This method returns the number of bullets in a Slide.
*
*@return
*num. of bullets in a Slide.
*
*/
  public int getNumBullets(){
    return bulCount;
  }

/** This method returns the bullet at a desired index.
*
*@param i
*Bullet index
*
*@return
*Returns bullet at desired index.
*
*@throws
*IllegalArgumentException when index is invalid.
*
}

*/
  public String getBullet(int i){
    String bullet = null;
    if (i >= 1 && i <= MAX_BULLETS){
      if (bullets[i-1] != null){
        bullet = bullets[i-1];
      }
      return bullet;
    }
    else throw new IllegalArgumentException();
  }
/**This method sets a bullet at a certain index. It can also delete a bullet point.
*@param bullet
*Desired desciption of bullet
*@param i
*Desired bullet index
*
*@throws
*IllegalArgumentException when index is invalid.
*/
  public void setBullet(String bullet, int i){
    if (i >= 1 && i <= MAX_BULLETS){
      if (bullet != null){
        bullets[i-1] = bullet;
        bulCount++;
      }
      if (bullet == null){
        int count = bulCount;
        for (int inc = i; inc <= count; inc++){
          bullets[inc-1] = bullets[inc];
        }
        bullets[count-1] = null;
        if (count > 0){
          bulCount--;
        }
      }
    }
    else throw new IllegalArgumentException();
  }


/** This method deletes the duration of a slide.
*
*
*/
  public void delDuration(){
    duration = 0;

  }

/** This method checks if the Duration of the slide is deleted, that is, if it is 0.
*
*@return
*returns String "Not Set" if duration is 0, and returns Double duration if not 0.
*
*/

  public Object checkDeletion(){
    Object check = null;
    if (this.getDuration() == 0){
      check = "Not set.";
      return (String) check;
    }
    else{
      check = this.getDuration();
      return (double) check;
    }
  }
/**This method formats a Slide in a String form to be printed in the terminal
*
*@return
*Returns formatted String that describes a Slide.
*/
  public String toString(){
    String toPrint = "";
    toPrint += "\n=========================================================\n";
    toPrint += this.getTitle();
    toPrint += "\n=========================================================\n";
    for (int i = 1; i <= MAX_BULLETS; i++){
      if (bullets[i-1] != null){
        toPrint += i + ". " + bullets[i-1];
        toPrint += "\n";
      }
    }
    toPrint += "\n=========================================================\n";
    return toPrint;
  }





}
