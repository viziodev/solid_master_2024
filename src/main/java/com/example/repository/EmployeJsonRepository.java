package com.example.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class EmployeJsonRepository {
    //Responsabilite : Acces aux Donnees(Save et get )
    private final String FILENAME="data/employe.json";
    public JSONArray getEmployeJson(){
        JSONArray employeeList=null;
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(FILENAME))
        {
            Object obj;
            try {
                //Recupere la donne dans le fichier Json
                obj = jsonParser.parse(reader);
                 employeeList = (JSONArray) obj;
            } catch (ParseException e) {
                e.printStackTrace();
            }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    public void saveJson(JSONObject employe){
        JSONArray employeeList = getEmployeJson();
        employeeList.add(employe);
        //R2 : Persitence 
        try (FileWriter file = new FileWriter(FILENAME)) {
            file.write(employeeList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

   

}
