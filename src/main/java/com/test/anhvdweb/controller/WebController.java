package com.test.anhvdweb.controller;

import com.test.anhvdweb.dto.PartnerHolidaysDto;
import com.test.anhvdweb.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/web")
public class WebController {
    @Autowired
    WebService webService;

    @RequestMapping(value = "/partner-holidays",  method = RequestMethod.GET)
    public List<PartnerHolidaysDto> getAllPartnerHolidays(){
        return webService.getAllHolidays();
    }

    @RequestMapping(value = "/partner-holidays2",  method = RequestMethod.GET)
    public List<PartnerHolidaysDto> getAllPartnerHolidays2(){
        return webService.getAllHolidays2();
    }
}
