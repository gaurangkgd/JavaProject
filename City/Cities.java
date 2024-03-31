package Model.City;

/**
 * Identification comments:
 *   Name: Gaurav Khutwal
 *   Experiment No: 08
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 05/03/24
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Cities.java
 * @author:  Gaurav Khutwal
 * Overview: This is the Cities class. In this file we have achieved the following
 * - Created Attributes
 * --- int ct_id
 * --- String ct_country
 * --- int ct_count which is declared as static variable
 *
 * - Created Setters and Getters
 * - Created constructors and overloaded them based on no. of parameters
 * - Created static setters and getters
 * - Made use of single inheritance where Country Class is the base class and Cities Class is derived class
 * - Accessed methods of base class using the keyword super
 * - Created a Display Function to call the getters and display Instance data
 *
 */

public class Cities extends Country {
    private static int ct_count = 0;
    int ct_id;
    String ct_name;

    public static void setct_count(int c_ount) {
        ct_count = c_ount;
    }

    public static int getct_count() {
        return ct_count;
    }

    public Cities() {
        setct_count(getct_count() + 1);
        this.setct_id(ct_count);
    }

   /* public Cities(String ct_name, String ct_country, String ct_currency, String ct_lang) {
        super(ct_country, ct_currency, ct_lang); // Updated parameter order
        setct_count(getct_count() + 1);
        this.setct_id(ct_count);
        this.setct_name(ct_name);
    }*/


   public Cities(int ct_id, String ct_name, String ct_country, String ct_lang, String ct_currency) {
        super(ct_country,  ct_currency,ct_lang);
        setct_count(getct_count() + 1);
        this.setct_id(ct_id);
        this.setct_name(ct_name);
    }

    public void setct_id(int ct_id) {
        this.ct_id = ct_id;
    }

    public void setct_name(String ct_name) {
        this.ct_name = ct_name;
    }

    public int getct_id() {
        return ct_id;
    }

    public String getct_name() {
        return ct_name;
    }


    public void display() {
        System.out.println("City Id: " + getct_id());
        System.out.println("City Name: " + getct_name());
        super.display();
    }

}
