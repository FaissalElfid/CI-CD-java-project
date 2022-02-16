package com.devite.department.dao;

import com.devite.department.bean.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement,Long> {
    boolean existsDistinctByLibelle(String libelle);
    Departement findByLibelle(String libelle);
}
