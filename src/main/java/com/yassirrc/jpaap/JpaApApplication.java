package com.yassirrc.jpaap;

import com.yassirrc.jpaap.entities.Patient;
import com.yassirrc.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      patientRepository.save(new Patient(null,"hasbula",new Date(),true,54));
        patientRepository.save(new Patient(null,"ahmed",new Date(),false,32));
        patientRepository.save(new Patient(null,"yassir",new Date(),false,24));
     /*   List<Patient> patients=patientRepository.findAll();

        patients.forEach(p->{
            System.out.println("==============================");
            System.out.println(p.getNom()+" "+p.getScore()+" "+p.getDatedenaissance());
            System.out.println("==============================");
        });
        Patient patient=patientRepository.findById(2L).orElse(null);
        if(patient!=null){
            System.out.println("old :"+patient.getNom()+" "+patient.getScore()+" "+patient.getDatedenaissance());
            patient.setScore(323);
            System.out.println("new :"+patient.getNom()+" "+patient.getScore()+" "+patient.getDatedenaissance());
            patientRepository.save(patient);
        }
        patientRepository.deleteById(1L);*/
        for(int i=0;i<=100;i++){
            patientRepository.save(new Patient(null,"ahmdc"+i,new Date(),(i%2==0)?false:true,(int)(Math.random()*230)));
        }


        Page<Patient> patients=patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("============="+patients.getTotalPages()+"=================");
       // List<Patient> content=patients.getContent();
        // List<Patient> byMaladie=patientRepository.findByMalade(false );
       // Page<Patient> byMaladie=patientRepository.findByMalade(false,PageRequest.of(0,4));
       // List<Patient> byMaladie=patientRepository.findByDatedenaissanceBetweenAAndMaladeIsTrue()
        List<Patient> byMaladie=patientRepository.findByScoreLessThan(200);
        byMaladie.forEach(p->{
            System.out.println("============="+patients.getNumber()+"=================");
            System.out.println(p.getNom()+" "+p.getScore()+" "+p.getDatedenaissance()+" is malade :"+p.isMalade());
            System.out.println("==============================");
        });
    }



}
