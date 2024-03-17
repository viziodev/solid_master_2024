package com.example.mapping;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.entities.Employe;

public interface Mapper {
     JSONObject mapEmployeToJSONObject(Employe employe);
     String mapEmployeToJson(JSONArray employeeList);
}
