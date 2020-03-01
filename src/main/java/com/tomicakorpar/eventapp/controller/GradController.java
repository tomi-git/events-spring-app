package com.tomicakorpar.eventapp.controller;


import com.tomicakorpar.eventapp.dto.GradDto;
import com.tomicakorpar.eventapp.service.GradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/grad")
public class GradController {

    @Autowired
    GradService gradService;

    @GetMapping(path = "/getAllGrad")
    public ResponseEntity getAllGrad() {
        ResponseEntity response = null;
        try {
            List<GradDto> resultList = gradService.fetchAllGradDto();
            response = new ResponseEntity(resultList, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity((e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
