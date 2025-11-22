package com.example.spring1;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class MyAPI {

    //pour simplifier et aller plus vite on declare nos objets au lieu de se connecter a une BDD
    public static ArrayList<Etudiant> liste = new ArrayList<>();

    static {
        liste.add(new Etudiant(0, "Killua", 17));
        liste.add(new Etudiant(1, "Bernard", 10));
        liste.add(new Etudiant(2, "Saada", 19));
        liste.add(new Etudiant(3, "Karim", 15));
    }


    @GetMapping(value = "/etudiants")
    public ArrayList<Etudiant> getAllStudents(){
        return (ArrayList<Etudiant>) liste;
    }

    @GetMapping(value = "/bonjour")
    public String bonjour(){
        return "Bonjour, ceci est ma premiere API !";
    }

    @GetMapping(value = "/bonsoir")
    public String bonsoir(){
        return "Bonsoir !";
    }

    @GetMapping(value = "/test")
    public Etudiant getEtudiant(){
        return new Etudiant(1, "Samy", 19);
    }

    @GetMapping(value = "/somme")
    public double somme(double a, double b){
        return a+b;
    }

    @GetMapping(value = "/etudiant")
    public Etudiant getParticularStudent(int id){
        return liste.get(id);
    }

    @PostMapping(value = "/ajouterEtudiant")
    public Etudiant addStudent(Etudiant student){
        liste.add(student);
        return student;
    }

    @DeleteMapping(value = "/supprimerEtudiant")
    public Etudiant supprimerEtudiant(int id){
        return liste.remove(id);
    }

    @PutMapping(value = "/modifierEtudiant")
    public Etudiant modifierEtudiant(int id, String nom){
        liste.get(id).setNom(nom);
        return liste.get(id);
    }


}
