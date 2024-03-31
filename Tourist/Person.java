package Model.Tourist;
/**
 * Identification comments:
 *   Name: Shivam Jha
 *   Experiment No: 08
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 05/03/24
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Person.java
 * @author: Shivam Jha
 * Overview: This is the Person class. In this file we have achieved the following
 * - Created Attributes
 * --- String fname
 * --- String lname
 * --- String gender
 * --- int age
 *
 * - Created Setters and Getters
 * - Created constructors and overloaded them
 * - Created a Display Function to call the getters and display Instance data
 *
 */

public class Person {
    String fname;
    String lname;
    String gender;
    int age;

    public Person()
    {
        System.out.println("Creating a Tourist");
    }

    public Person(String fname, String lname, String gender, int age)
    {
        this.setFname(fname);
        this.setLname(lname);
        this.setgender(gender);
        this.setage(age);
    }

    public void setFname(String f_name) {
        this.fname = f_name;
    }

    public void setLname(String l_name) {
        this.lname = l_name;
    }

    public void setgender(String gen) {
        this.gender = gen;
    }



    public void setage(int age) {
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getgender() {
        return gender;
    }

    public int getage() {
        return age;
    }

    public void display()
    {
        System.out.println("Tourist First Name: "+getFname());
        System.out.println("Tourist Last Name: "+getLname());
        System.out.println("Tourist Gender: "+getgender());
        System.out.println("Tourist age: "+getage());
    }
}
