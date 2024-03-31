package Model.City;

import java.io.IOException;
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
 * Filename: FileHandlingCities.java
 * @author:  Shivam Jha
 * Overview: This is the FileHandlingCities Abstract class. In this file we have achieved the following
 *
 * - Created protected Abstract Methods for Array List of Cities by passing parameters
 * - Methods created for the abstract class read and write the Cities.json file
 */
public abstract class FileHandlingCities {
    protected abstract ArrayList<Cities> readCitiesJsonFile(String file_path);
    protected abstract void writeCitiesJsonFile(String file_path, ArrayList<Cities> cities) throws IOException;
}
