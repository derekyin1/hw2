import java.util.Scanner;
public class PresentationManager{

  public static void main(String[] args) {
    SlideList newList = new SlideList();
    System.out.println("Welcome to PresentationManager!");
    boolean isRunning = true;

    //while(isRunning){
      System.out.print("\nPlease select an option: \n F) Move cursor forward. \n B) Move cursor backward. \n D) Display cursor slide. \n E) Edit cursor slide. \n P) Print presentation summary. \n A) Append new slide to tail. \n I) Insert new slide before cursor. \n R) Remove slide at cursor. \n H) Reset cursor to head. \n Q) Quit. \n");
      Scanner in = new Scanner(System.in);
      String s = in.nextLine();
      if (s.equals("Q") || s.equals("q")){
        System.out.println("Program terminating normally...");
        isRunning = false;
      }
      if (s.equals("F") || s.equals("f")){

      }
    //}

  }
}
