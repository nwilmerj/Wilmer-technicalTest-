package com.inditex.hiring.infraestructure.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Offer")
public class Offer {

	@Id	
	@Column(name = "OFFER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;

	@Column(name = "BRAND_ID")
	private Integer brandId;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceListId;

	@Column(name = "PARTNUMBER")
	private String productPartnumber;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String currencyIso;

	//ADD WILMER
	@Column(name = "SIZE")
    private String size;	

	@Column(name = "MODEL")
    private String model;


	@Column(name = "QUALITY")
    private String quality;
	//FIN ADD WILMER

	public Offer() {
	}

	public Offer(long l, long m, LocalDateTime now, LocalDateTime plusDays, long n, String string, int i, double d,
            String string2) {
        //TODO Auto-generated constructor stub
    }

	

    public Offer(Long offerId, Integer brandId, Timestamp startDate, Timestamp endDate, Integer priceListId,
			String productPartnumber, Integer priority, BigDecimal price, String currencyIso, String size, String model,
			String quality) {
		this.offerId = offerId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceListId = priceListId;
		this.productPartnumber = productPartnumber;
		this.priority = priority;
		this.price = price;
		this.currencyIso = currencyIso;
		this.size = size;
		this.model = model;
		this.quality = quality;
	}

    public Offer(Integer brandId, String currencyIso, Timestamp endDate, Long offerId, BigDecimal price, Integer priceListId, Integer priority, String productPartnumber, Timestamp startDate) {
        this.brandId = brandId;
        this.currencyIso = currencyIso;
        this.endDate = endDate;
        this.offerId = offerId;
        this.price = price;
        this.priceListId = priceListId;
        this.priority = priority;
        this.productPartnumber = productPartnumber;
        this.startDate = startDate;
    }

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Integer priceListId) {
		this.priceListId = priceListId;
	}

	public String getProductPartnumber() {
		return productPartnumber;
	}

	public void setProductPartnumber(String productPartnumber) {
		this.productPartnumber = productPartnumber;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrencyIso() {
		return currencyIso;
	}

	public void setCurrencyIso(String currencyIso) {
		this.currencyIso = currencyIso;
	}

	//ADD WILMER
	public String getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public String getQuality() {
        return quality;
    }
	
	public void setSize(String size) {
        this.size = size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }   
	//FIN ADD WILMER     
		
}
