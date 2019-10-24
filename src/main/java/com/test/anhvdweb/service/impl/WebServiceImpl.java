package com.test.anhvdweb.service.impl;

import com.test.anhvdweb.config.datasource.Datasources;
import com.test.anhvdweb.domain.PartnerHolidays;
import com.test.anhvdweb.domain.PartnerHolidays2;
import com.test.anhvdweb.dto.PartnerHolidaysDto;
import com.test.anhvdweb.repository.partnerholidays.PartnerHolidaysRepository;
import com.test.anhvdweb.repository.partnerholidays2.PartnerHolidaysRepository2;
import com.test.anhvdweb.service.WebService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebServiceImpl implements WebService {

    @Autowired
    PartnerHolidaysRepository partnerHolidaysRepository;

    @Autowired
    PartnerHolidaysRepository2 partnerHolidaysRepository2;

    @Override
    @Transactional(Datasources.DATASOURCE1)
    public List<PartnerHolidaysDto> getAllHolidays() {
        List<PartnerHolidays> lstQuery = partnerHolidaysRepository.findAll();
        List<PartnerHolidaysDto> lstResult = new ArrayList<>();
        for(PartnerHolidays p : lstQuery){
            PartnerHolidaysDto dto = new PartnerHolidaysDto();
            BeanUtils.copyProperties(p,dto);
            lstResult.add(dto);
        }
        return lstResult;
    }

    @Override
    @Transactional(Datasources.DATASOURCE2)
    public List<PartnerHolidaysDto> getAllHolidays2() {
        List<PartnerHolidays2> lstQuery = partnerHolidaysRepository2.findAll();
        List<PartnerHolidaysDto> lstResult = new ArrayList<>();
        for(PartnerHolidays2 p : lstQuery){
            PartnerHolidaysDto dto = new PartnerHolidaysDto();
            BeanUtils.copyProperties(p,dto);
            lstResult.add(dto);
        }
        return lstResult;
    }
}
