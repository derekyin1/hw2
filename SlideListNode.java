public class SlideListNode{
  private Slide data;
  private SlideListNode next;
  private SlideListNode prev;

  public SlideListNode(Slide initData){
    if (initData != null){
      data = initData;
    }
    else throw new IllegalArgumentException();
  }

  public Slide getData(){
    return data;
  }

  public void setData(Slide newData){
    if (newData != null){
      data = newData;
    }
    else throw new IllegalArgumentException();
  }

  public SlideListNode getNext(){
    return next;
  }

  public void setNext(SlideListNode newNext){
    next = newNext;
  }

  public SlideListNode getPrev(){
    return prev;
  }

  public void setPrev(SlideListNode newPrev){
    prev = newPrev;
  }

}
