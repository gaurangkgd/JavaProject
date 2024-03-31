package Model.City;


import Model.Displayable;
import Model.City.FileHandlingCities;
import Model.City.Cities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
 * Filename: manageCities.java
 * @author:  Shivam Jha
 * Overview: This is the manageCities class. In this file we have achieved the following
 * - Created Attributes
 * --- private int linesBeingDisplayed;
 * --- private int firstLineIndex;
 * --- int lastLineIndex;
 * --- int highlightedLine;
 *
 * - manageCities Class extends abstract class FileHandlingCities and implements Interface Displayable
 * - Created constructors and overloaded them based on no. of parameters
 * - Created body for abstract class methods
 * - Created method body for the Displayable Interface
 * - The class reads and writes into the Cities.json file by reading and writing it
 * - Created Table for Cities
 */
public class manageCities extends FileHandlingCities implements Displayable {
    ArrayList<Cities> cities = new ArrayList<Cities>();
    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageCities(){
        readCitiesJsonFile("Exp11/src/Model/City/Cities.json");
    }
    public ArrayList<Cities> readCitiesJsonFile(String file_path)
    {
        try {
            cities.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int ct_id = node.get("ct_id").asInt();
                    String ct_name = node.get("ct_name").asText();
                    String ct_lang = node.get("ct_lang").asText();
                    String ct_currency = node.get("ct_currency").asText();
                    String ct_country = node.get("ct_country").asText();
                    Cities city = new Cities(ct_id, ct_name,ct_country,ct_lang, ct_currency);
                    cities.add(city);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
    public void writeCitiesJsonFile(String file_path, ArrayList<Cities> cities) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Cities/cities.json").toFile(), cities);
        objectMapper.writeValue(Paths.get(file_path).toFile(), cities);
    }

    public void setCitiesTable(ArrayList<Cities> cities) {
        this.cities = cities;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Country");
        headers.add("Language");
        headers.add("Currency");

        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> cities_details = new ArrayList<String>();

        cities_details.add(String.valueOf(cities.get(line).getct_id()));
        cities_details.add(cities.get(line).getct_name());
        cities_details.add(cities.get(line).getct_country());
        cities_details.add(cities.get(line).getct_lang());
        cities_details.add(cities.get(line).getct_currency());

        return cities_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> cities_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            cities_subset.add(getLine(i));
        }
        return cities_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Cities> getTable() {
        return cities;
    }

    public void addNewCity(int city_id, String city_name, String city_country, String city_language,String city_currency) throws IOException {
        readCitiesJsonFile("Exp11/src/Model/City/Cities.json");
        Cities temp_stud = new Cities(city_id, city_name, city_country, city_language,city_currency);
        cities.add(temp_stud);
        writeCitiesJsonFile("Exp11/src/Model/City/Cities.json",cities);

    }

    public void editNewCity(int edit_city_idx, int city_id, String city_name, String city_country, String city_language,String city_currency) throws IOException {
        readCitiesJsonFile("Exp11/src/Model/City/Cities.json");
        cities.get(edit_city_idx).setct_id(city_id);
        cities.get(edit_city_idx).setct_name(city_name);
        cities.get(edit_city_idx).setct_country(city_country);
        cities.get(edit_city_idx).setct_lang(city_language);
        cities.get(edit_city_idx).setct_currency(city_currency);
        writeCitiesJsonFile("Exp11/src/Model/City/Cities.json",cities);
    }

    public void deleteCity(int edit_course_idx) throws IOException {
        readCitiesJsonFile("Exp11/src/Model/City/Cities.json");
        cities.remove(edit_course_idx);
        writeCitiesJsonFile("Exp11/src/Model/City/Cities.json",cities);
    }
}
