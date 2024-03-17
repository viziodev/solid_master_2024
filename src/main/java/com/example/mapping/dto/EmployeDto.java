package com.example.mapping.dto;

import org.json.simple.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {
    private long id;
    private String  nom;
    private String  prenom;
    private long  nbreAbsence;
    public EmployeDto(JSONObject emp) {
        JSONObject employe=(JSONObject )emp.get("employee");
        id=(long)employe.get("id");
        nom=(String)employe.get("nom");
        prenom=(String)employe.get("prenom");
        nbreAbsence=(long)employe.get("nbreAbsence");
    }
    
}