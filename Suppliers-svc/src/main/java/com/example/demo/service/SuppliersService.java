package com.example.demo.service;

import com.example.demo.dao.SuppliersDto;
import com.example.demo.entity.Suppliers;
import com.example.demo.repo.SuppliersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class SuppliersService {
    @Autowired
     SuppliersRepo suppliersRepo;

   public List<SuppliersDto> getAllSuppliers(){
        List<SuppliersDto> suppliersDtos = new ArrayList<>();
        for (Suppliers suppliers :suppliersRepo.findAll()){
            SuppliersDto suppliersDto = new SuppliersDto();
            suppliersDto.setId(suppliers.getId());
            suppliersDto.setCity(suppliers.getCity());
            suppliersDto.setAddress(suppliers.getAddress());
            suppliersDto.setFax(suppliers.getFax());
            suppliersDto.setCountry(suppliers.getCountry());
            suppliersDto.setPhone(suppliers.getPhone());
            suppliersDto.setHomepage(suppliers.getHomepage());
            suppliersDto.setRegion(suppliers.getRegion());
            suppliersDto.setContactName(suppliers.getContactName());
            suppliersDto.setCompanyName(suppliers.getCompanyName());
            suppliersDto.setContactTitle(suppliers.getContactTitle());
            suppliersDto.setPostalCode(suppliers.getPostalCode());

            suppliersDtos.add(suppliersDto);

        }
        return suppliersDtos;
    }
        public int saveSuppliers(SuppliersDto suppliersDto){
        SuppliersDto suppliersDtos = new SuppliersDto();
        Suppliers suppliers =new Suppliers();
        suppliers.setId(suppliersDto.getId());
        suppliers.setCountry(suppliersDto.getCountry());
        suppliers.setAddress(suppliersDto.getAddress());
        suppliers.setContactTitle(suppliersDto.getContactTitle());
        suppliers.setCompanyName(suppliersDto.getCompanyName());
        suppliers.setCity(suppliersDto.getCity());
        suppliers.setHomepage(suppliersDto.getHomepage());
        suppliers.setPhone(suppliersDto.getPhone());
        suppliers.setRegion(suppliersDto.getRegion());
        suppliers.setContactName(suppliersDto.getContactName());
        suppliers.setFax(suppliersDto.getFax());
        suppliers.setPostalCode(suppliersDto.getPostalCode());
            Suppliers save = suppliersRepo.save(suppliers);
            suppliersDtos.setId(save.getId());

            return suppliersDtos.getId();
        }

    public SuppliersDto getSupplierbyId(Integer Id){
        Optional<Suppliers> suppliers =suppliersRepo.findById(Id);

        SuppliersDto suppliersDto = new SuppliersDto();

        if (!suppliers.isPresent()){
            throw new RuntimeException("given Id is not Persent");
        }
        suppliersDto.setId(suppliers.get().getId());
       suppliersDto.setFax(suppliers.get().getFax());
       suppliersDto.setCity(suppliers.get().getCity());
       suppliersDto.setPhone(suppliers.get().getPhone());
       suppliersDto.setCountry(suppliers.get().getCountry());
       suppliersDto.setRegion(suppliers.get().getRegion());
       suppliersDto.setAddress(suppliers.get().getAddress());
       suppliersDto.setHomepage(suppliers.get().getHomepage());
       suppliersDto.setContactTitle(suppliers.get().getContactTitle());
       suppliersDto.setCompanyName(suppliers.get().getCompanyName());
       suppliersDto.setPostalCode(suppliers.get().getPostalCode());
       suppliersDto.setContactName(suppliers.get().getContactName());
        return suppliersDto ;
    }


    public SuppliersDto update(SuppliersDto suppliersDto) {
        Optional<Suppliers> optionalSuppliers = suppliersRepo.findById(suppliersDto.getId());
        SuppliersDto dto =new SuppliersDto();
        Suppliers suppliers = new Suppliers();
        if (optionalSuppliers.isPresent()) {
            suppliers .setId(suppliersDto.getId());
           suppliers.setPostalCode(suppliersDto.getPostalCode());
           suppliers.setCountry(suppliersDto.getCountry());
           suppliers.setAddress(suppliersDto.getAddress());
           suppliers.setRegion(suppliersDto.getRegion());
           suppliers.setCity(suppliersDto.getCity());
           suppliers.setFax(suppliersDto.getFax());
           suppliers.setHomepage(suppliersDto.getHomepage());
           suppliers.setPhone(suppliersDto.getPhone());
           suppliers.setContactTitle(suppliersDto.getContactTitle());
           suppliers.setContactName(suppliersDto.getContactName());
           suppliers.setCompanyName(suppliersDto.getCompanyName());
            Suppliers saveOrders=suppliersRepo.save(suppliers);
            dto.setId(saveOrders.getId());

        } else {
            throw new RuntimeException("supplier Not Present");
        }
        return dto;
    }

    public void delete(Integer id){
        Optional<Suppliers> suppliers = suppliersRepo.findById(id);
        if (suppliers.isPresent()){
            suppliersRepo.deleteById(id);

        }else
        {
            throw new RuntimeException("given id is not persent");
        }



}}
