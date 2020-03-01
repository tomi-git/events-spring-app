package com.tomicakorpar.eventapp.controller;


import com.tomicakorpar.eventapp.dto.OrganizacijskaJedinicaDto;
import com.tomicakorpar.eventapp.service.OrganizacijskaJedinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/organizacijskaJedinica")
public class OrganizacijskaJedinicaController {

    @Autowired
    OrganizacijskaJedinicaService organizacijskaJedinicaService;

    @GetMapping(path = "/getAllOrganizacijskaJedinica")
    public ResponseEntity getAllOrganizacijskaJedinica() {
        ResponseEntity response = null;
        try {
            List<OrganizacijskaJedinicaDto> resultList = organizacijskaJedinicaService.fetchAllOrganizacijskaJedinicaDto();
            response = new ResponseEntity(resultList, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity((e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
