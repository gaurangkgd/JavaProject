package Model.Tourist;
/**
 * Identification comments:
 *   Name: Shivam Jha
 *    Experiment No: 08
 *    Experiment Title: Implement Exception Handling with User Defined Exception
 *    Experiment Date: 05/03/24
 *  *
 *  * Beginning comments:
 *  * Filename: Tourists.java
 *  * @author: Shivam Jha
 *  * Overview: This is the Tourists class. In this file we have achieved the following
 *  * - Created Attributes
 *  * --- int tr_id
 *  * --- String tr_mob
 *  * --- int tr_count which is declared as static variable
 *  *
 *   Experiment Title: Implementation of Abstract Class and Abstract Methods for the entities of the relationship and Implementing JSON File Handling in Java to store objects data. Reading a json file to objects and writing objects to a json data file.

 * - Created Setters and Getters
 * - Created constructors and overloaded them based on no. of parameters
 * - Created static setters and getters
 * - Made use of single inheritance where Person Class is the base class and Tourists Class is derived class
 * - Accessed methods of base class using the keyword super
 * - Created a Display Function to call the getters and display Instance data
 *
 */

public class Tourists extends Person {
    private static int tr_count = 0;
    int tr_id;
    String tr_mob;
    public static void settr_count(int count)
    {
        tr_count=count;
    }
    public static int gettr_count()
    {
        return tr_count;
    }


    public Tourists()
    {
        settr_count(gettr_count()+1);
        this.settr_id(tr_count);
    }

    public Tourists(String tr_mob, String tr_fname, String tr_lname, String tr_gen, int tr_age)
    {
        super(tr_fname, tr_lname, tr_gen,tr_age);
        settr_count(gettr_count()+1);;
        this.settr_id(tr_count);
        this.settr_mob(tr_mob);
    }

    public Tourists(int tr_id, String tr_fname, String tr_lname, String tr_gen, int tr_age, String tr_mob)
    {
        super(tr_fname, tr_lname, tr_gen, tr_age);
        settr_count(gettr_count()+1);;
        this.settr_id(tr_id);
        this.settr_mob(tr_mob);
    }

    public void settr_id(int id) {
        this.tr_id = id;
    }

    public void settr_mob(String mob) {
        this.tr_mob = mob;
    }

    public int gettr_id() {
        return tr_id;
    }

    public String gettr_mob() {
        return tr_mob;
    }


    public void display()
    {
        System.out.println("Tourist Id: "+gettr_id());
        System.out.println("Tourist Mobile No: "+gettr_mob());
        super.display();
    }

}
