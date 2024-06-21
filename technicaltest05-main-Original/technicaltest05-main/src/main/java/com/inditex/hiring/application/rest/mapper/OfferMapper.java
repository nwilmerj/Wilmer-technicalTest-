package com.inditex.hiring.application.rest.mapper;


import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.inditex.hiring.application.dto.OfferDto;
import com.inditex.hiring.infraestructure.repository.Offer;

public class OfferMapper {

    public static OfferDto toDTO(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setOfferId(offer.getOfferId());
        dto.setBrandId(offer.getBrandId());
        dto.setStartDate(offer.getStartDate().toString());
        dto.setEndDate(offer.getEndDate().toString());
        dto.setPriceListId(offer.getPriceListId().longValue());
        dto.setProductPartnumber(offer.getSize() + offer.getModel() + offer.getQuality());
        dto.setPrice(offer.getPrice());
        dto.setCurrencyIso(offer.getCurrencyIso());
        dto.setPriority(offer.getPriority());
        return dto;
    }

    public static Offer toEntity(OfferDto dto) {

        Offer offer = new Offer();
        offer.setOfferId(dto.getOfferId());
        offer.setBrandId(dto.getBrandId());
        
        offer.setStartDate(convertDate(dto.getStartDate()));            
        offer.setEndDate(convertDate(dto.getEndDate()));        

        offer.setPriceListId(dto.getPriceListId().intValue()); 
          
        // Splitting productPartnumber
        String productPartnumber = dto.getProductPartnumber();
        offer.setSize(productPartnumber.substring(0, 2));
        offer.setModel(productPartnumber.substring(2, 6));
        offer.setQuality(productPartnumber.substring(6, 9));

        offer.setPrice(dto.getPrice());
        offer.setCurrencyIso(dto.getCurrencyIso());
        offer.setPriority(dto.getPriority());
        offer.setProductPartnumber(productPartnumber);
        return offer;
    }

    //Convert StringDate to Timestamp
    public static Timestamp convertDate(String dateTime){
         ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, 
            DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Instant instant = zonedDateTime.toInstant();
        return Timestamp.from(instant);
    }

}
