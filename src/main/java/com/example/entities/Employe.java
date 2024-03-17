package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Reponsabilite Description des Donnees 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employe {
      private long id;
      private String  nom;
      private String  prenom;
      private double  salaire;
      private long  nbreAbsence;
      private ModePaiement modePaiement;
      private double  retenu;
      private double  prime;
      private double  salaireBrut;
   
    
    
      
}
