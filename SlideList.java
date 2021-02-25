/** Derek Yin 113251504 Recitation Section 1
  This class defines a doubly linked list of Slide objects.

  @author Derek Yin
*/

public class SlideList{
  private SlideListNode head;
  private SlideListNode tail;
  private SlideListNode cursor;
  private int size;

/** This is a constructor that creates a new SlideList with a size of 0.

*/
  public SlideList(){
    size = 0;
  }

/** This is a method that returns the size of the SlideList.
@return
returns amount of Slides of SlideList.
*/
  public int size(){
    return size;
  }
/** This method returns the total duration of all the Slides in a SlideList.
@return
returns total duration of SlideList
*/
  public double duration(){
    double duration = 0;
    SlideListNode nodePtr = head;
    while (nodePtr != null){
      duration += nodePtr.getData().getDuration();
      nodePtr = nodePtr.getNext();
    }
    return duration;
  }
/** This method returns the total number of bullets in a SlideList.

@return
returns total bullets in a SlideList.
*/
  public int numBullets(){
    int numBullets = 0;
    SlideListNode nodePtr = head;
    while (nodePtr != null){
      numBullets += nodePtr.getData().getNumBullets();
      nodePtr = nodePtr.getNext();
    }
    return numBullets;
  }
/** This method returns the slide currently at the cursor position.

@return
returns slide at cursor position.
*/
  public Slide getCursorSlide(){
    if (cursor == null){
      return null;
    }
    else return cursor.getData();
  }
/** This method resets the cursor position to the beginning of the SlideList.
*/
  public void resetCursorToHead(){
    cursor = head;
  }
/** This method moves the cursor forward one index.

@throws
throws EndOfListException if reached end of list.
*/
  public void cursorForward() throws EndOfListException {
    if (cursor != tail){
      cursor = cursor.getNext();
    }
    else throw new EndOfListException("");
  }
/** This method moves the cursor backward one index.

@throws
throws EndOfListException if reached end of list.
*/
  public void cursorBackward() throws EndOfListException {
    if (cursor != head){
      cursor = cursor.getPrev();
    }
    else throw new EndOfListException("");
  }
/** This method inserts a Slide one index before the cursor.

@param newSlide
the new slide to be added

@throws
throws IllegalArgumentException if slide is null.

*/
  public void insertBeforeCursor(Slide newSlide){
    if (newSlide != null){
      SlideListNode newNode = new SlideListNode(newSlide);
      if (cursor != null){
        if (cursor.getPrev() != null){
          cursor.getPrev().setNext(newNode);
          newNode.setPrev(cursor.getPrev());
          newNode.setNext(cursor);
          cursor.setPrev(newNode);
          cursor = newNode;
        }
        if (cursor.getPrev() == null){
          newNode.setNext(cursor);
          cursor.setPrev(newNode);
          head = newNode;
        }

      }
      if (cursor == null){
        head = newNode;
        tail = newNode;
      }
      cursor = newNode;
      size++;
    }
    else throw new IllegalArgumentException();
  }
/** This method adds a new slide to the end of the SlideList.

@param newSlide
the slide to be added

@throws
throws IllegalArgumentException if slide is null.

*/
  public void appendToTail(Slide newSlide){
    if (newSlide != null){
      SlideListNode newNode = new SlideListNode(newSlide);
      if (tail != null){
        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;
      }
      if (tail == null){
        head = newNode;
        tail = newNode;
        cursor = newNode;
      }
      size++;
    }
    else throw new IllegalArgumentException();
  }

/** This method removes the slide at the cursor position

@return
returns the removed Slides

@throws
throws EndOfListException if cursor is null
*/
  public Slide removeCursor() throws EndOfListException{
    if (cursor != null){
      Slide oldSlide = cursor.getData();
      if (head == cursor && cursor.getNext() != null){
        head = cursor.getNext();
        cursor = head;
      }
      else if (tail == cursor && cursor.getPrev() != null){
        tail = cursor.getPrev();
        cursor = tail;
      }
      else if (cursor.getNext() != null && cursor.getPrev() != null){
        cursor.getNext().setPrev(cursor.getPrev());
        cursor.getPrev().setNext(cursor.getNext());
        cursor = cursor.getPrev();
      }
      else if (tail == cursor && head == cursor){
        head = null;
        tail = null;
        cursor = null;
      }
      size--;
      return oldSlide;
    }
    else{
      throw new EndOfListException("");
    }
  /*  else{
      throw new IllegalArgumentException("");
    } */
  }

/** This method creates a formatted string to be printed in the terminal.

@return
Returns the formatted Slide description in string form, including title, duration, and number of bullets

*/
  public String toString(){
    String toPrint = "Slideshow Summary:";
    toPrint += "\n=========================================================\n";
    toPrint += String.format("%-11s%-20s%-19s%6s", " Slide", "Title", "Duration", "Bullets");
    toPrint += "\n---------------------------------------------------------\n";
    SlideListNode init = head;
    for (int i = 1; i <= size; i++){
      if (cursor == init){
        toPrint += String.format("%-11s%-20s%-14s%6s", "-> " + i, init.getData().getTitle(), init.getData().getDuration(), init.getData().getNumBullets());
      }
      else{
        toPrint += String.format("%-11s%-20s%-14s%6s", "   " + i, init.getData().getTitle(), init.getData().getDuration(), init.getData().getNumBullets());
      }
      toPrint += "\n";
      init = init.getNext();
    }
    toPrint += "\n=========================================================\n";
    toPrint += "Total: " + size + " slide(s), " + this.duration() + " minute(s), " + this.numBullets() + " bullet(s)";
    toPrint += "\n=========================================================\n";
    return toPrint;
  }


}
