package Model.Enrolls;

import Model.City.Cities;
import Model.City.*;
import Model.City.manageCities;
import Model.Displayable;
import Model.Tourist.*;
import Model.Tourist.manageTourists;
import Model.Tourist.Tourists;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import Model.City.Country;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class manageEnrolls extends FileHandlingEnrolls implements Displayable {
    ArrayList<Tourists> tourists = new ArrayList<Tourists>();

    ArrayList<Cities> cities = new ArrayList<Cities>();

    ArrayList<Enrolls> enrollment_data = new ArrayList<Enrolls>();
    ArrayList<Map<String, Object>> handle_data = new ArrayList<>();


    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    Tourists temp_obj = null;
    Cities t_temp_obj = null;

    public manageEnrolls(){
        manageTourists ms1 = new manageTourists();
        tourists = ms1.getTable();
        manageCities mc1 = new manageCities();
        cities = mc1.getTable();
        readEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json");
    }

    @Override
    public ArrayList<Enrolls> readEnrollsJsonFile(String file_path) {
        try {
            enrollment_data.clear();
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for(JsonNode node : rootNode){

                    int temp = node.get("s_temp").asInt();
                    for (Tourists tourists1 : tourists) {
                        if (temp == tourists1.gettr_id()) {
                           temp_obj = tourists1;
                        }
                    }
                    int t_temp = node.get("c_temp").asInt();

                    for (Cities cities1 : cities) {
                        if (t_temp == cities1.getct_id()) {
                            t_temp_obj = cities1;
                        }
                    }
                    String enroll_date = node.get("enroll_date").asText();
                    int city_fees= node.get("city_fees").asInt();
                    enrollment_data.add(new Enrolls(temp_obj,t_temp_obj,enroll_date,city_fees));}
            }
//            for (int i = 0; i < enrollment_data.size(); i++) {
//                HashMap <String, Object> data = new HashMap<>();
//                data.put("s_temp", enrollment_data.get(i).getT_temp().gettr_id());
//                data.put("c_temp", enrollment_data.get(i).getC_temp().getct_id());
//                data.put("enroll_date", enrollment_data.get(i).getEnroll_date());
//                data.put("city_fees", enrollment_data.get(i).getCities_fees());
//                handle_data.add(data);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return enrollment_data;
    }

    @Override
    public void writeEnrollsJsonFile(String file_path, ArrayList<Enrolls> enroll_al) throws IOException {

        ArrayList<Map<String, Object>> enroll_to_be_written = new ArrayList<>();

        for(int i = 0; i < enroll_al.size(); i++)
        {
            HashMap <String, Object> row = new HashMap<>();

            row.put("s_temp", enrollment_data.get(i).getT_temp().gettr_id());
            row.put("c_temp", enrollment_data.get(i).getC_temp().getct_id());
            row.put("enroll_date", enrollment_data.get(i).getEnroll_date());
            row.put("city_fees", enrollment_data.get(i).getCities_fees());


            enroll_to_be_written.add(row);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), enroll_to_be_written);
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();

        headers.add("Tourist ID");
        headers.add("City Id");
        headers.add("Enroll date");
        headers.add("Enroll fees");

        return headers;
    }
    public void Display(){
        for(int i=0; i<enrollment_data.size(); i++){
            System.out.print("\nTourist ID: ");
            System.out.print(enrollment_data.get(i).getT_temp().gettr_id());
            System.out.print("\nCity ID: ");
            System.out.print(enrollment_data.get(i).getC_temp().getct_id());
            System.out.print("\nEnrollment Date ");
            System.out.print(enrollment_data.get(i).getEnroll_date());
            System.out.print("\nCity Tour package: ");
            System.out.print(enrollment_data.get(i).getCities_fees());
            System.out.print("\n-----------------------------------------------------");
        }
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> enrollment_details = new ArrayList<String>();


        enrollment_details.add(String.valueOf(enrollment_data.get(line).getT_temp().gettr_id()));
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getC_temp().getct_id()));
        enrollment_details.add(enrollment_data.get(line).getEnroll_date());
        enrollment_details.add(String.valueOf(enrollment_data.get(line).getCities_fees()));
        return enrollment_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Enrolls_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Enrolls_subset.add(getLine(i));
        }
        return Enrolls_subset;
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

        setLastLineToDisplay(getFirstLineToDisplay()+getLinesBeingDisplayed()-1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
            this.firstLineIndex=firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
            this.highlightedLine=highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex=lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed=numberOfLines;
    }

    public ArrayList<Enrolls> getTable() {
        return enrollment_data;
    }

    public void addNewEnroll( int enroll_t_id,int enroll_c_id, String enroll_date,int enroll_fees) throws IOException {
        readEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json");
        Enrolls temp_en = new Enrolls(tourists.get(enroll_t_id),cities.get(enroll_c_id), enroll_date, enroll_fees);
        enrollment_data.add(temp_en);
        writeEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json",enrollment_data);

    }

    public void editNewEnroll(int edit_enroll_idx,  int enroll_t_id,int enroll_c_id, String enroll_date,int enroll_fees) throws IOException {
        readEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json");

        enrollment_data.get(edit_enroll_idx).setT_temp(tourists.get(enroll_t_id));
        enrollment_data.get(edit_enroll_idx).setC_temp(cities.get(enroll_c_id));
        enrollment_data.get(edit_enroll_idx).setEnroll_date(enroll_date);
        enrollment_data.get(edit_enroll_idx).setCities_fees(enroll_fees);
        writeEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json",enrollment_data);
    }

    public void deleteEnroll(int edit_enroll_idx) throws IOException {
        readEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json");
        enrollment_data.remove(edit_enroll_idx);
        writeEnrollsJsonFile("Exp11/src/Model/Enrolls/Enrolls.json",enrollment_data);
    }
}

