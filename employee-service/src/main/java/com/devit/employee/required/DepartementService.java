package com.devit.employee.required;

import com.devit.employee.dto.DepartementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartementService {
    @GetMapping("/api/v1/departement-service/departement")
    DepartementDto findDepartementByLibelle(@RequestParam("libelle") String department);
}
