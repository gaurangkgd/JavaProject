package Model.Tourist;
import Model.City.Cities;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Displayable;

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
 * Overview: This is the manageTourists class. In this file we have achieved the following
 * - Created Attributes
 * --- private int linesBeingDisplayed;
 * --- private int firstLineIndex;
 * --- int lastLineIndex;
 * --- int highlightedLine;
 *
 * - manageTourists Class extends abstract class FileHandlingTourists and implements Interface Displayable
 * - Created constructors and overloaded them based on no. of parameters
 * - Created body for abstract class methods
 * - Created method body for the Displayable Interface
 * - The class reads and writes into the Tourists.json file by reading and writing it
 * - Created Table for Tourists
 */
public class manageTourists extends FileHandlingTourists implements Displayable {

    ArrayList<Tourists> tourists = new ArrayList<Tourists>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageTourists(){
        readTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json");
    }
    public ArrayList<Tourists> readTouristsJsonFile(String file_path)
    {
        try {
            tourists.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int tr_id = node.get("tr_id").asInt();
                    String fname = node.get("fname").asText();
                    String lname = node.get("lname").asText();
                    String gender = node.get("gender").asText();
                    int tr_age = node.get("age").asInt();
                    String tr_mob = node.get("tr_mob").asText();
                    Tourists tour = new Tourists(tr_id, fname, lname, gender,tr_age,tr_mob);
                    tourists.add(tour);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tourists;
    }
    public void writeTouristsJsonFile(String file_path, ArrayList<Tourists> tourists) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Tourists/tourists.json").toFile(), tourists);
        objectMapper.writeValue(Paths.get(file_path).toFile(), tourists);
    }

    public void setTouristsTable(ArrayList<Tourists> tourists) {
        this.tourists = tourists;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Gender");
        headers.add("Age");
        headers.add("Mobile");

        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> tourist_details = new ArrayList<String>();

        tourist_details.add(String.valueOf(tourists.get(line).gettr_id()));
        tourist_details.add(tourists.get(line).getFname());
        tourist_details.add(tourists.get(line).getLname());
        tourist_details.add(tourists.get(line).getgender());
        tourist_details.add(String.valueOf(tourists.get(line).getage()));
        tourist_details.add(tourists.get(line).gettr_mob());

        return tourist_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> tourists_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            tourists_subset.add(getLine(i));
        }
        return tourists_subset;
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

    public ArrayList<Tourists> getTable() {
        return tourists;
    }

    public void addNewTourist(int tourist_id, String tourist_f_name,String tourist_l_name, String tourist_gender, int tourist_age,String tourist_mob) throws IOException {
        readTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json");
        Tourists temp_stud = new Tourists(tourist_id, tourist_f_name,tourist_l_name, tourist_gender, tourist_age,tourist_mob);
        tourists.add(temp_stud);
        writeTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json",tourists);

    }

    public void editNewTourist(int edit_tourist_idx, int tourist_id, String tourist_f_name,String tourist_l_name, String tourist_gender, int tourist_age,String tourist_mob) throws IOException {
        readTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json");
        tourists.get(edit_tourist_idx).settr_id(tourist_id);
        tourists.get(edit_tourist_idx).setFname(tourist_f_name);
        tourists.get(edit_tourist_idx).setLname(tourist_l_name);
        tourists.get(edit_tourist_idx).setgender(tourist_gender);
        tourists.get(edit_tourist_idx).setage(tourist_age);
        tourists.get(edit_tourist_idx).settr_mob(tourist_mob);
        writeTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json",tourists);
    }

    public void deleteTourist(int edit_tourist_idx) throws IOException {
        readTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json");
        tourists.remove(edit_tourist_idx);
        writeTouristsJsonFile("Exp11/src/Model/Tourist/Tourists.json",tourists);
    }
}
