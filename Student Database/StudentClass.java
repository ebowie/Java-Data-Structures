
/**
 * Class: StudentClass
 * @author (Eric Bowers ) 
 * @version (a version number or a date)
 * This class stores the names,ID's, 5 test scores of students.
 * Using the equal methods and compareto method for average and id of the students.
 */
public class StudentClass
{
    // instance variables - replace the example below with your own
    private String name;
    private String ID;
    private double [] testScores = new double[5];// not sure if i need it or not 
    private double average;
    
    
/** 
*  The no-args constructor sets the name field to "no name","no id", and average to zero
*/  
public StudentClass()
    {
       name = "no name";
       ID= "no id ";
       average=0;
    }
    
    

    /**
     * The name field and the score fields are set to the parameter values with no data validation  
     *  @param String- a string value for the student name
     *  @param int- an integer value for the student current id
     *  @param String- a string value for student 5 test scores
     */
    public StudentClass(String n, String id, double [] testS)
    {
        // initialise instance variables
        name = n;
        ID = id;
        testScores = testS; 
        
    }
    
/** 
* This method compares the invoking student object with the StudentClass the reference
* parameter refers to. The comparison is done on the average field
* @param StudentClass- a Student Class reference is sent in
* @return int value of -1, 0 or 1	
*/public double compareTo(StudentClass inAve)
    {
        if(this.average > inAve.average)
          return 1;
          else
            if(average == inAve.average)
              return 0;
            else 
               return -1;
    }
   
    /** 
* This method compares invoking student object with the StudentClass the reference
* parameter refers to to check for equal values in both fields. 
* @param Object- an Object is the parameter type to override the equals method in the object class
* @return bool- true if the two objects have the same values for both fields, false otherwise
*/
    public boolean equal(Object inParam)
    {
        StudentClass inStudentClass = (StudentClass)inParam;
        return name.equals(inStudentClass.name)&& ID == inStudentClass.ID; // may need to change this?n
        
    }
    

    
/** 
* 	Returns a String representation of a StudentClass object that includes both the values of the
*   name field and the id field and average field
*/
public String toString()
    { 
        
        for(int i = 0; i<5; i++)
        {
        average = testScores[i] + average;
        
        }
         average = average/5;
        return " Name:"+ name + "\n ID:"+ ID +"\n Average:" + average;
        
    }
    
    
}    