package com.example.demo.controller;

import com.example.demo.dao.SuppliersDto;
import com.example.demo.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @GetMapping("/get/all")
    private List<SuppliersDto> getAllSupplie() {
        return suppliersService.getAllSuppliers();
    }

    @GetMapping("/get/by/id/{supplierid}")
    private SuppliersDto getSupplier(@PathVariable("supplierid") int supplierid) {
        return (SuppliersDto) suppliersService.getSupplierbyId(supplierid);
    }

    @DeleteMapping("/delete/by/id/{supplierid}")
    private void deleteSupplier(@PathVariable("supplierid") int supplierid) {
        suppliersService.delete(supplierid);
    }

    @PostMapping("/save")
    private int saveSupplier(@RequestBody SuppliersDto suppliersDto) {
        int id = suppliersService.saveSuppliers(suppliersDto);
        return id;

    }

    @PutMapping("/update")
    private int update(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.update(suppliersDto).getId();
    }


}

