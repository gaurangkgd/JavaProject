package Model.City;
/**
 * Identification comments:
 *   Name: Gaurav
 *   Experiment No: 08
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 05/03/24
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Country.java
 * @author:  Shivam Jha
 * Overview: This is the Country class. In this file we have achieved the following
 * - Created Attributes
 * --- String ct_currency
 * --- String ct_lang
 * --- String ct_country
 *
 * - Created Setters and Getters
 * - Created constructors and overloaded them
 * - Created a Display Function to call the getters and display Instance data
 *
 */

public class Country {
    String ct_country;
    String ct_currency;
    String ct_lang;

    public Country()
    {
        System.out.println("Creating a City");
    }

    public Country(String ct_country, String ct_currency,String ct_lang)
    {
        this.setct_country(ct_country);
        this.setct_currency(ct_currency);
        this.setct_lang(ct_lang);
    }

    public void setct_country(String ct_country) {
        this.ct_country = ct_country;
    }

    public void setct_lang(String lang) {
        this.ct_lang = lang;
    }

    public void setct_currency(String currency ) {
        this.ct_currency = currency;
    }

    public String getct_country() {
        return ct_country;
    }
    public String getct_lang() {
        return ct_lang;
    }
    public String getct_currency() {
        return ct_currency;
    }
    public void display()
    {
        System.out.println("City Country: "+getct_country());
        System.out.println("City Language: "+getct_lang());
        System.out.println("City Currency: "+getct_currency());
    }
}
