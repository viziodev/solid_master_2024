package com.example.services;


import org.json.simple.JSONObject;

import com.example.entities.Employe;
import com.example.entities.ModeSave;
import com.example.mapping.Mapper;
import com.example.repository.EmployeDbRepository;
import com.example.repository.EmployeJsonRepository;
//Reponsabilite Offrir des Services
public class EmployeService {
    //Desing Pattern Singleton
  private static EmployeService instance;

     private Mapper mapper;
     private EmployeJsonRepository repository=new EmployeJsonRepository();
     private EmployeDbRepository employeDbRepository=new EmployeDbRepository();
   
    private EmployeService() {
}
    public static EmployeService getInstance(Mapper mapper) {
        if (instance == null) {
            instance = new EmployeService();
            instance.mapper=mapper;
        }
        return instance;
    }
    public void virerSalaire(Employe employe){
        System.out.println("Salaire Virement fait  pour   "+employe.getNom()+" "+employe.getPrenom()  );  
        System.out.println("Salaire Virement fait  en   "+ employe.getModePaiement().name());  
    }

     public void save(Employe employe,ModeSave modeSave){
        //Remplacer par le design pattern Strategy
        if (modeSave==ModeSave.JSON) {
              JSONObject maJsonObject = mapper.mapEmployeToJSONObject(employe);
              repository.saveJson(maJsonObject);
        } else {
            employeDbRepository.saveDb(employe); 
        }
      
     }

     public String getEmployeJson(){
        return mapper.mapEmployeToJson( repository.getEmployeJson());
     }

    
}
