package com.devite.department.controller;

import com.devite.department.bean.Departement;
import com.devite.department.dto.DepartementDto;
import com.devite.department.service.DepartementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
@Slf4j
public class DepartementController {

    @Autowired
    private DepartementService departmentService;

    @GetMapping("/{libelle}")
    public Departement findByLibelle(@RequestParam("libelle") String department) {
        return departmentService.findByLibelle(department);
    }
    @GetMapping("/")
    public List<Departement> findAll(){
        return departmentService.findAll();
    }

    @PostMapping("/")
    public long save(@RequestBody DepartementDto departementDto){
        return departmentService.save(departementDto);
    }

}
