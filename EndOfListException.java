/** Derek Yin 113251504 Recitation Section 1
*This class defines a custom exception, EndOfListException. It is thrown when a method is called that violates the list size
*
*@author Derek Yin
*/

public class EndOfListException extends Exception{

/**
*This is the constructor for the EndOfListException.
*
*@param message
*the error message to be displayed
*
*/
  public EndOfListException(String message){
    super(message);
  }
}
