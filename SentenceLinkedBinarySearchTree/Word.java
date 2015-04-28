
/**
 * this class is able to take  words from the sentence and put each one in a object and increment each one if needed if they are a duplicate 
 * 
 * @author (Eric Bowers  ) 
 * @version (06/18/2013)
 */
public class Word implements Comparable
{
    // instance variables - replace the example below with your own
    private int count=1;
    protected String letters;

    /**
     * Constructor for objects of class Word
     */
    public Word()
    {
       count =1;
       letters = null;
        
    }

    /**
     * This constructor takes in a word from the driver and puts it in letters 
     * 
     * @param  will take in a string 
     *      
     */
    public Word(String w)
    { 
     
        letters =w;
       
        
    }
        
    /**
     *this method takes in a word and puts it in letters 
     * 
     * @param  takes in a string 
     *     
     */public void setWord(String w)
    {
       letters=w;
    
    }
  /**
     * this will return the letters of the word 
     * 
     *   
     * @return  a string type     
     */ public String getWord()
   {
      return letters; 
       
   }
   
   /**
     * This decrement for any occurences from the words
     * 
     *   
     */public void setDetally()
   {
     count--;
     
    }
    /**
     * this return the count 
     *
     *  
     * @return take in a number       
     */public int getDetally()
    {
     return count;
    }
     
    
   
   /**
     *this will increment how many words are the same word 
     * 
     *      
     */public void setTally()
   {
      count++;
   }
   
   /**
     * this return the incremented number 
     * 
     *   
     * @return a increments number    
     */public int getTally()
   {
       return count;
    }
    
    /**
     * this does a compare method with two objects to see which is greater 
     * 
     * @param  object word 
     * @return   a number back    
     */public int compareTo(Object inWord)
    {   
        Word outWord = (Word) inWord;

        
        if(letters.compareTo(outWord.letters)>0)
            return 1;
          else
            if(letters == outWord.letters)
              return 0;
            else 
               return -1;
            
     }
     
     /**
     * if the objects are equal together or not 
     * 
     * @param  taking in a objec 
     * @return if it is true or false      
     */public boolean equals(Object inParam)
     {
         Word inWord = (Word)inParam;
         return letters.equals(inWord.letters);
         
         
      }
      
      /**
     * displaying the words in the to string 
     * 
     * 
     * @return a string     
     */public String toString()
      {
          return letters + " \n";
          
        }
      
}
