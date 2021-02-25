/**Derek Yin 113251504 Recitation Section 1
**
**This class defines the nodes of the doubly linked list of Slide objects.
**
**@author Derek Yin
*/

public class SlideListNode{
  private Slide data;
  private SlideListNode next;
  private SlideListNode prev;

/** This csonstructor creates a SlideListNode with desired Slide.
**
**@param initData
**Associates a Slide to a SlideListNode.
**
*/
  public SlideListNode(Slide initData){
    if (initData != null){
      data = initData;
    }
    else throw new IllegalArgumentException();
  }

/** This method returns the Slide referenced by a SlideListNode.
**@return
**returns Slide referenced by SlideListNode.
*/
  public Slide getData(){
    return data;
  }
/** This method references a new Slide to a SlideListNode.
*
*@param newData
*Slide to be referenced by a SlideListNode.
*
*@throws
*IllegalArgumentException if Slide is null.
*
*/
  public void setData(Slide newData){
    if (newData != null){
      data = newData;
    }
    else throw new IllegalArgumentException();
  }
/** This method gets the SlideListNode that references the next slide in the list.
*
*@return
*Returns SlideListNode that references the next Slide.
*
*/
  public SlideListNode getNext(){
    return next;
  }
/** This method sets a SlideListNode to reference the next Slide in the list.
*
*@param newNext
*new SLideListNode to reference next Slide in the list.
*
*/
  public void setNext(SlideListNode newNext){
    next = newNext;
  }
/** This method gets the SlideListNode that references the previous slide in the list.
*
*@return
*Returns SlideListNode that references the previous Slide.
*
*/
  public SlideListNode getPrev(){
    return prev;
  }
/** This method sets a SlideListNode to reference the previous Slide in the list.
*
*@param newPrev
*new SLideListNode to reference previous Slide in the list.
*
*/
  public void setPrev(SlideListNode newPrev){
    prev = newPrev;
  }

}
