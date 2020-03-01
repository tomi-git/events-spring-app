package com.tomicakorpar.eventapp.controller;


import com.tomicakorpar.eventapp.dto.DogadajDto;
import com.tomicakorpar.eventapp.dto.DogadajDtoInput;
import com.tomicakorpar.eventapp.dto.DogadajFilterDto;
import com.tomicakorpar.eventapp.service.DogadajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/dogadaj")
public class DogadajController {

    @Autowired
    DogadajService dogadajService;

    @PostMapping(path = "/", produces = "application/json;charset=UTF-8")
    public ResponseEntity create(@RequestBody DogadajDtoInput dogadajDtoInput) {
        ResponseEntity response = null;
        try {
            DogadajDto result = dogadajService.createDogadaj(dogadajDtoInput);
            if (result.getValid()) {
                response = new ResponseEntity("Događaj je kreiran pod šifrom " + result.getSifraDogadaja(), HttpStatus.CREATED);
            } else {
                response = new ResponseEntity(result.getErrorMessages(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response = new ResponseEntity((e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping(path = "/getFilterList", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ResponseEntity getFilterList(@RequestBody DogadajFilterDto dogadajFilterDto) {
        ResponseEntity response = null;
        try {
            List<DogadajDto> resultList = dogadajService.getFilterDogadajList(dogadajFilterDto);
            response = new ResponseEntity(resultList, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity((e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


    @PostMapping(path = "/getDogadaj", produces = "application/json;charset=UTF-8")
    public DogadajDtoInput create() {
        DogadajDtoInput dogadajDto = new DogadajDtoInput("dog1", 114, LocalDateTime.now(), LocalDateTime.now(), true);


        return dogadajDto;
    }
}
