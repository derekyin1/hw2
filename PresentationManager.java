import java.util.Scanner;
public class PresentationManager{

  public static void main(String[] args) {
    SlideList newList = new SlideList();
    System.out.println("Welcome to PresentationManager!");
    boolean isRunning = true;

    while(isRunning){
      System.out.print("\nPlease select an option: \n F) Move cursor forward. \n B) Move cursor backward. \n D) Display cursor slide. \n E) Edit cursor slide. \n P) Print presentation summary. \n A) Append new slide to tail. \n I) Insert new slide before cursor. \n R) Remove slide at cursor. \n H) Reset cursor to head. \n Q) Quit. \n");
      Scanner in = new Scanner(System.in);
      String s = in.nextLine();
      if (s.equals("Q") || s.equals("q")){
        System.out.println("Program terminating normally...");
        isRunning = false;
      }
      if (s.equals("F") || s.equals("f")){
        newList.cursorForward();
        System.out.println("The cursor moved forward to slide " + newList.getCursorSlide().getTitle());
      }
      if (s.equals("B") || s.equals("b")){
        newList.cursorBackward();
        System.out.println("The cursor moved backward to slide " + newList.getCursorSlide().getTitle());
      }
      if (s.equals("D") || s.equals("d")){
        System.out.println(newList.getCursorSlide().toString());
      }
      if (s.equals("E") || s.equals("e")){
        System.out.println("Edit title, duration, or bullets? (t/d/b)");
        String choice = in.nextLine();
        if (choice.equals("t")){
          System.out.println("Delete or edit? (d/e)");
          String or = in.nextLine();
          if (or.equals("d")){
            newList.getCursorSlide().setTitle("");
            System.out.println("Title deleted.");
          }
          if (or.equals("e")){
            System.out.println("New title:");
            String newTitle = in.nextLine();
            newList.getCursorSlide().setTitle(newTitle);
            System.out.println("Set new title.");
          }
          if (!or.equals("e") && !or.equals("d")){
            System.out.println("Invalid input.");
            isRunning = false;
            isRunning = true;
          }
        }
        if (choice.equals("d")){
          System.out.println("Delete or edit? (d/e)");
          String or = in.nextLine();
          if (or.equals("d")){
            newList.getCursorSlide().setDuration(-1);
            System.out.println("Duration deleted.");
          }
          if (or.equals("e")){
            System.out.println("New duration:");
            if (in.hasNextDouble()){
              double newDuration = in.nextDouble();
              newList.getCursorSlide().setDuration(newDuration);
              System.out.println("New duration set to " + newDuration + " minutes.");
            }
            else{
              System.out.println("Invalid input.");
              isRunning = false;
              isRunning = true;
            }
          }
          if (!or.equals("e") && !or.equals("d")){
            System.out.println("Invalid input.");
            isRunning = false;
            isRunning = true;
          }
        }
        if (choice.equals("b")){
          System.out.println("Bullet index:");
          if (in.hasNextInt()){
            int index = in.nextInt();
            if (index > 0 && index <= newList.getCursorSlide().getNumBullets()){
              System.out.println("Delete or edit? (d/e)");
              in.nextLine();
              String or = in.nextLine();
              if (or.equals("d")){
                newList.getCursorSlide().setBullet(null, index);
                System.out.println("Deleted bullet " + index);
              }
              if (or.equals("e")){
                System.out.println("Bullet " + index);
                String newBullet = in.nextLine();
                newList.getCursorSlide().setBullet(newBullet, index);
                System.out.println("Bullet " + index + " edited.");
              }
              if (!or.equals("e") && !or.equals("d")){
                System.out.println("Invalid input.");
                isRunning = false;
                isRunning = true;
              }
            }
            else{
              System.out.println("Invalid input.");
              isRunning = false;
              isRunning = true;
            }
          }
          else{
            System.out.println("Invalid input.");
            isRunning = false;
            isRunning = true;
          }
        }
        if (!choice.equals("t") && !choice.equals("d") && !choice.equals("b")){
          System.out.println("Invalid input.");
          isRunning = false;
          isRunning = true;
        }
      }
      if (s.equals("P") || s.equals("p")){
        System.out.println(newList.toString());
      }
      if (s.equals("A") || s.equals("a")){
        System.out.println("Enter the slide title: ");
        String title = in.nextLine();
        System.out.println("Enter the slide duration:");
        if (in.hasNextDouble()){
          double duration = in.nextDouble();
          Slide newSlide = new Slide(title, duration);
          in.nextLine();
          for (int i =1; i <= 5; i++){
            System.out.println("Bullet " + i + ": ");
            String bul = in.nextLine();
            newSlide.setBullet(bul, i);
            if (i < 5){
              System.out.println("Add another bullet point? (y/n)");
              String choice = in.nextLine();
              if (choice.equals("n")){
                i+= 10;
                newList.appendToTail(newSlide);
                System.out.println("Slide " + title + " added to presentation.");

              }
              if (!choice.equals("n")&& !choice.equals("y")){
                i+= 10;
                System.out.println("Invalid input.");
                isRunning = false;
                isRunning = true;
              }
            }
            if (i == 5){
              i+= 10;
              newList.appendToTail(newSlide);
              System.out.println("No more bullets allowed. Slide is full.");
              System.out.println("Slide " + title + " added to presentation.");
            }
          }
        }
        else {
          System.out.println("Invalid input.");
          isRunning = false;
          isRunning = true;
        }
      /*  System.out.println("Enter the slide title: ");
        String title = in.nextLine();
        System.out.println("Enter the slide duration:");
        if (in.hasNextDouble()){
          double duration = in.nextDouble();
          Slide newSlide = new Slide(title, duration);
          String bullet1 = "";
          String bullet2 = "";
          String bullet3 = "";
          String bullet4 = "";
          String bullet5 = "";
          System.out.println("Bullet 1:");
          in.nextLine();
          bullet1 = in.nextLine();
          System.out.println("Add another bullet point? (y/n)");
          String choice1 = in.nextLine();
          if (choice1.equals("y")){
            System.out.println("Bullet 2:");
            bullet2 = in.nextLine();
            System.out.println("Add another bullet point? (y/n)");
            String choice2 = in.nextLine();
            if (choice2.equals("y")){
              System.out.println("Bullet 3:");
              bullet3 = in.nextLine();
              System.out.println("Add another bullet point? (y/n)");
              String choice3 = in.nextLine();
              if (choice3.equals("y")){
                System.out.println("Bullet 4:");
                bullet4 = in.nextLine();
                System.out.println("Add another bullet point? (y/n)");
                String choice4 = in.nextLine();
                if (choice4.equals("y")){
                  System.out.println("Bullet 5:");
                  bullet5 = in.nextLine();
                  newSlide.setBullet(bullet1, 1);
                  newSlide.setBullet(bullet2, 2);
                  newSlide.setBullet(bullet3, 3);
                  newSlide.setBullet(bullet4, 4);
                  newSlide.setBullet(bullet5, 5);
                  newList.appendToTail(newSlide);
                  System.out.println("Slide " + title + " added to presentation.");
                }
                if (choice4.equals("n")){
                  newSlide.setBullet(bullet1, 1);
                  newSlide.setBullet(bullet2, 2);
                  newSlide.setBullet(bullet3, 3);
                  newSlide.setBullet(bullet4, 4);
                  newList.appendToTail(newSlide);
                }

              }
              if (choice3.equals("n")){
                newSlide.setBullet(bullet1, 1);
                newSlide.setBullet(bullet2, 2);
                newSlide.setBullet(bullet3, 3);
                newList.appendToTail(newSlide);
                System.out.println("Slide " + title + " added to presentation.");
              }
            }
            if (choice2.equals("n")){
              newSlide.setBullet(bullet1, 1);
              newSlide.setBullet(bullet2, 2);
              newList.appendToTail(newSlide);
              System.out.println("Slide " + title + " added to presentation.");
            }
          }
          if (choice1.equals("n")){
            newSlide.setBullet(bullet1, 1);
            newList.appendToTail(newSlide);
            System.out.println("Slide " + title + " added to presentation." );
          }
        }
        else{
          System.out.println("Invalid input.");
          isRunning = false;
          isRunning = true;
        } */

      }

      if (s.equals("I") || s.equals("i")){
        System.out.println("Enter the slide title: ");
        String title = in.nextLine();
        System.out.println("Enter the slide duration:");
        if (in.hasNextDouble()){
          double duration = in.nextDouble();
          Slide newSlide = new Slide(title, duration);
          in.nextLine();
          for (int i =1; i <= 5; i++){
            System.out.println("Bullet " + i + ": ");
            String bul = in.nextLine();
            newSlide.setBullet(bul, i);
            if (i < 5){
              System.out.println("Add another bullet point? (y/n)");
              String choice = in.nextLine();
              if (choice.equals("n")){
                i+= 10;
                newList.insertBeforeCursor(newSlide);
                System.out.println("Slide " + title + " added to presentation.");

              }
              if (!choice.equals("n")&& !choice.equals("y")){
                i+= 10;
                System.out.println("Invalid input.");
                isRunning = false;
                isRunning = true;
              }
            }
            if (i == 5){
              i+= 10;
              newList.insertBeforeCursor(newSlide);
              System.out.println("No more bullets allowed. Slide is full.");
              System.out.println("Slide " + title + " added to presentation.");
            }
          }
        }
        else {
          System.out.println("Invalid input.");
          isRunning = false;
          isRunning = true;
        }
      }

      if (s.equals("R") || s.equals("r")){
        if (newList.getCursorSlide() != null){
          try{
            String title = newList.getCursorSlide().getTitle();
            newList.removeCursor();
            System.out.println("Slide " + title + " has been removed.");
          }
          catch (EndOfListException e){

          }
        }
        else{
          System.out.println("Cursor is empty.");
          isRunning = false;
          isRunning = true;
        }
      }

      if (s.equals("H") || s.equals("h")){
        newList.resetCursorToHead();
        System.out.println("Cursor reset to head.");
      }



    }

  }
}
