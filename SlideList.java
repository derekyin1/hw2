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
      SlideListNode newNode = new SlideListNode();
      newNode.setData(newSlide);
      if (cursor != null){
        cursor.getPrev().setNext(newNode);
        newNode.setPrev(cursor.getPrev());
        newNode.setNext(cursor);
        cursor.setPrev(newNode);
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
      SlideListNode newNode = new SlideListNode();
      newNode.setData(newSlide);
      if (tail != null){
        tail.setNext(newNode);
        newNode.setPrev(tail);
        newNode.setNext(null);
        newNode = tail;
      }
      if (tail == null){
        head = newNode;
        tail = newNode;
      }
      size++;
    }
    else throw new IllegalArgumentException();
  }

  public Slide removeCursor(){

  }
}
