package com.devite.department.service;

import com.devite.department.bean.Departement;
import com.devite.department.dao.DepartementDao;
import com.devite.department.dto.DepartementDto;
import com.devite.department.dto.ResponseDto;
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

    public ResponseDto<DepartementDto> save(DepartementDto departementDto) {
        ResponseDto<DepartementDto> responseDto = new ResponseDto<>();
        if(departementDao.existsDistinctByLibelle(departementDto.getLibelle())){
            responseDto.setCode(-1);
            responseDto.setMessage("libelle already exists");
            responseDto.setPayload(departementDto);
        }else{
            Departement departement = new Departement();
            BeanUtils.copyProperties(departementDto,departement);
            departementDao.save(departement).getId();
            responseDto.setCode(1);
            responseDto.setMessage("department added succefully !!");
            responseDto.setPayload(departementDto);
        }
        return responseDto;
    }
    public List<Departement> findAll() {
        return departementDao.findAll();
    }
    public Departement findByLibelle(String department) {
        return departementDao.findByLibelle(department);
    }
}
