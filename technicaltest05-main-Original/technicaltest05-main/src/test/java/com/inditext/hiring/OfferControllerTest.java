package com.inditext.hiring;


import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inditex.hiring.application.OfferService;
import com.inditex.hiring.application.dto.OfferDto;
import com.inditex.hiring.application.rest.OfferController;
import com.inditex.hiring.infraestructure.repository.Offer;

class OfferControllerTest {
    private MockMvc mockMvc;

    @Mock
    private OfferService offerService;

    @InjectMocks
    private OfferController offerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(offerController).build();
    }

    @Test
    void testCreateOffer() throws Exception {
        // Mock data
        OfferDto mockOfferDto = new OfferDto();
        mockOfferDto.setOfferId(1L);
        mockOfferDto.setBrandId(1);
        mockOfferDto.setStartDate("2020-06-14T00:00:00Z");
        mockOfferDto.setEndDate("2020-12-31T23:59:59Z");
        mockOfferDto.setPriceListId(1L);
        mockOfferDto.setProductPartnumber("000100233");
        mockOfferDto.setPriority(0);
        mockOfferDto.setPrice(new BigDecimal("35.50"));
        mockOfferDto.setCurrencyIso("EUR");

        // Perform the request
        mockMvc.perform(MockMvcRequestBuilders.post("/offer")
                .contentType(MediaType.APPLICATION_JSON)
                //.content("{\"offerId\": 1, \"brandId\": 1, \"startDate\": \"2020-06-14\", \"endDate\": \"2020-12-31\", \"priceListId\": 1, \"productPartnumber\": \"000100233\", \"priority\": 0, \"price\": 35.50, \"currencyIso\": \"EUR\"}"))
                .content("{\"offerId\":1, \"brandId\": 1, \"startDate\": \"2020-06-14T00:00:00Z\", \"endDate\": \"2020-12-31T23:59:59Z\", \"priceListId\": 5, \"productPartnumber\": \"000100444\", \"priority\": 0, \"price\": 40, \"currencyIso\": \"EUR\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.offerId").value("Mock Offer"));

        // Verify that the service method was called
        verify(offerService, times(1)).save(any(Offer.class));
    }
    
    @Test
    void testDeleteById() {
        offerService.deleteById(1L);
        // We can add verification here if needed
    }

    @Test
    void testDeleteAllOffers() {
        offerService.deleteAllOffers();
        // We can add verification here if needed
    }
}
