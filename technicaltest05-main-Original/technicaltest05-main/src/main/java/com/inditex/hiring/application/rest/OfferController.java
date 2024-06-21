package com.inditex.hiring.application.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.hiring.application.OfferService;
import com.inditex.hiring.application.dto.OfferDto;
import com.inditex.hiring.application.rest.exception.NoSuchResourceFoundException;
import com.inditex.hiring.application.rest.mapper.OfferMapper;
import com.inditex.hiring.infraestructure.repository.Offer;


	@RestController
	public class OfferController {

		//ADD WILMER 
		private final OfferService offerService;

		public OfferController(OfferService offerServiceParam){
			this.offerService = offerServiceParam;
		}
		//FIN ADD WILMER
		
		//Crear
		@RequestMapping(value="/offer", method = RequestMethod.POST)
		@ResponseStatus(HttpStatus.OK)
		public OfferDto createOffer(@RequestBody @Valid OfferDto offerdto){
			OfferDto salida = null;
			try {
				Offer offer = OfferMapper.toEntity(offerdto);
				salida = OfferMapper.toDTO(offerService.save(offer));
				System.out.println("¡saving the offer correct!");
			} catch (Exception e) {
				throw new RuntimeException("Error saving the offer: " + e.getCause());
			}
			return salida;
		}

		//Borrar por id
		@RequestMapping(value="/offer/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.OK)
		public void deleteOfferById(@PathVariable("id") Long id){
			try {
				offerService.deleteById(id);
			} catch (Exception e) {
				throw new RuntimeException("Error deleting the offer with id: " + id);
			}
		}

		//Obtener por id
		@RequestMapping(value="/offer/{id}", method = RequestMethod.GET)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
			return offerService.findById(id)
					.map(ResponseEntity::ok)
					.orElseThrow(() -> new NoSuchResourceFoundException("Offer not found with id: " + id));
					//.orElse(ResponseEntity.notFound().build());
		}

		//Eliminar todas las ofertas
		@RequestMapping(value = "/offer", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.OK)
		public void deleteAllOffers() {	
			try {
				offerService.deleteAllOffers();
			} catch (Exception e) {
				throw new RuntimeException("Error deleting all offers");
			}
		}
		
		//Endopint para optener todas las ofertas
		@RequestMapping(value = "/offer", method = RequestMethod.GET)
		@ResponseStatus(HttpStatus.OK)
		public List<Offer> getAllOffers() {
			try {
				return offerService.findAll();
			} catch (Exception e) {
				throw new RuntimeException("Error retrieving all offers");
			}
		}
		
	}