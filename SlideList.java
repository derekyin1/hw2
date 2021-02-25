public class SlideList{
  private SlideListNode head;
  private SlideListNode tail;
  private SlideListNode cursor;
  private int size;

  public SlideList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public double duration(){
    double duration = 0;
    SlideListNode nodePtr = head;
    while (nodePtr != null){
      duration += nodePtr.getData().getDuration();
      nodePtr = nodePtr.getNext();
    }
    return duration;
  }

  public int numBullets(){
    int numBullets = 0;
    SlideListNode nodePtr = head;
    while (nodePtr != null){
      numBullets += nodePtr.getData().getNumBullets();
      nodePtr = nodePtr.getNext();
    }
    return numBullets;
  }

  public Slide getCursorSlide(){
    return cursor.getData();
  }

  public void resetCursorToHead(){
    cursor = head;
  }

  public void cursorForward() throws EndOfListException{
    if (cursor != tail){
      cursor = cursor.getNext();
    }
  }

  public void cursorBackward() throws EndOfListException{
    if (cursor != head){
      cursor = cursor.getPrev();
    }
  }

  public void insertBeforeCursor(Slide newSlide){
    if (newSlide != null){
      SlideListNode newNode = new SlideListNode(newSlide);
      if (cursor != null){
        if (cursor.getPrev() != null){
          cursor.getPrev().setNext(newNode);
          newNode.setPrev(cursor.getPrev());
          newNode.setNext(cursor);
          cursor.setPrev(newNode);
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

  public void appendToTail(Slide newSlide){
    if (newSlide != null){
      SlideListNode newNode = new SlideListNode(newSlide);
      if (tail != null){
        tail.setNext(newNode);
        newNode.setPrev(tail);
        newNode.setNext(null);
        newNode = tail;
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

  public Slide removeCursor() throws EndOfListException{
    if (cursor != null){
      Slide oldSlide = cursor.getData();
      cursor.getPrev().setNext(cursor.getNext());
      cursor.getNext().setPrev(cursor.getPrev());
      if (cursor != head){
        cursor = cursor.getPrev();
      }
      else cursor = head;

      return oldSlide;
    }
    else throw new EndOfListException("");
  }

  public String toString(){
    String toPrint = "\n=========================================================\n";
    toPrint += String.format("%-10s%-20s%-19s%6s", "Slide", "Title", "Duration", "Bullets");
    toPrint += "\n---------------------------------------------------------\n";
    SlideListNode init = head;
    for (int i = 1; i < size; i++){
      toPrint += String.format("%-10s%-20s%-14s%6s", i, init.getData().getTitle(), init.getData().getDuration(), init.getData().getNumBullets());
      toPrint += "\n";
      init = init.getNext();
    }
    toPrint += "\n=========================================================\n";
    toPrint += "Total: " + size + " slide(s), " + this.duration() + " minute(s), " + this.numBullets() + " bullet(s)";
    toPrint += "\n=========================================================\n";
    return toPrint;
  }

  public static void main(String[] args) {
    SlideList test = new SlideList();
    Slide testSlide = new Slide("Test one", 1.4);
    test.insertBeforeCursor(testSlide);
    test.insertBeforeCursor(testSlide);
    test.insertBeforeCursor(testSlide);
    test.appendToTail(testSlide);
    System.out.println(test.toString());
  }
}
