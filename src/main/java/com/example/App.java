package com.example;

import com.example.entities.Employe;
import com.example.entities.ModePaiement;
import com.example.mapping.MapperImpl;
import com.example.services.EmployeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeService employeService=EmployeService.getInstance(new MapperImpl());
       //Vues
       //Desing Pattern Builder
         Employe emp =Employe .builder()
                              .id(1)
                              .nom("Wane")
                              .prenom("Baila")
                              .nbreAbsence(10)
                              .modePaiement(ModePaiement.Espece)
                              .build();
        // employeService.saveJson(emp);
       System.out.println(employeService.getEmployeJson());
    }
}
