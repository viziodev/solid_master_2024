package com.example.mapping;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.entities.Employe;
import com.example.mapping.dto.EmployeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
   //Reponsabilite de Mapping
public class MapperImpl implements Mapper {
 
   
    @SuppressWarnings("unchecked")
    public  JSONObject mapEmployeToJSONObject(Employe employe){
        //R1 :Mapping entre un Employe et JSONObject
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("id", employe.getId());
        employeeDetails.put("nom",employe.getNom());
        employeeDetails.put("prenom", employe.getPrenom());
        employeeDetails.put("salaire",employe.getSalaire());
        employeeDetails.put("nbreAbsence",employe.getNbreAbsence());
        employeeDetails.put("modePaiement", employe.getModePaiement().name());
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
        return employeeObject;
    }

    public  String mapEmployeToJson(JSONArray employeeList){
        String json=null;
          //Responsabilite Mapping
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
         
            List<EmployeDto> employeesDto=new ArrayList<>();
            for (Object emp  : employeeList) {
                JSONObject empJsonObject=  (JSONObject) emp;
                employeesDto.add(new EmployeDto(empJsonObject));
            }
            json = ow.writeValueAsString(employeesDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
