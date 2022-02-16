package com.devite.department.service;

import com.devite.department.bean.Departement;
import com.devite.department.dao.DepartementDao;
import com.devite.department.dto.DepartementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartementService {
    @Autowired
    DepartementDao departementDao;

    public long save(DepartementDto departementDto) {
        if(departementDao.existsDistinctByLibelle(departementDto.getLibelle())){
            return -1;
        }else{
            Departement departement = new Departement();
            BeanUtils.copyProperties(departementDto,departement);
            return departementDao.save(departement).getId();
        }
    }
    public List<Departement> findAll() {
        return departementDao.findAll();
    }
    public Departement findByLibelle(String department) {
        return departementDao.findByLibelle(department);
    }
}
