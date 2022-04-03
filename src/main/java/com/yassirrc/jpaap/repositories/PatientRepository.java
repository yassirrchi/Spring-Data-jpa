package com.yassirrc.jpaap.repositories;

import com.yassirrc.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

 public List<Patient> findByMalade(boolean a);
 //public Page<Patient> findByMalade(boolean a,Pageable pageable);
 //public List<Patient> findByDatedenaissanceBetweenAAndMaladeIsTrue(Date d1, Date d2);
 public List<Patient> findByScoreLessThan(int sc);

}
