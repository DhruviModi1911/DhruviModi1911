package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "earthquake_data")
public class EarthquakeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eventID", unique = true)
    private String eventID;

    private LocalDateTime datetime;
    private Double latitude;
    private Double longitude;
    private Double magnitude;
    private String mag_type;
    private Double depth;
    private Integer phasecount;
    private Double azimuth_gap;
    private String location;
    private String agency;
    private LocalDateTime datetimeFM;
    private Double latFM;
    private Double lonFM;
    private Double magFM;
    private String magTypeFM;
    private Double depthFM;
    private Integer phasecountFM;
    private Double scalarMoment;
    private Double Mrr;
    private Double Mtt;
    private Double Mpp;
    private Double Mrt;
    private Double Mrp;
    private Double Mtp;
    private Double varianceReduction;
    private Double doubleCouple;
    private Double clvd;
    private Integer strikeNP1;
    private Integer dipNP1;
    private Integer rakeNP1;
    private Integer strikeNP2;
    private Integer dipNP2;
    private Integer rakeNP2;

    @Column(name = "az_gapfm") // Change to the actual column name in your DB
    private Double azgapFM; // Change variable name if necessary

    private Double misfit;

   


	public EarthquakeData(Long id, String eventID, LocalDateTime datetime, Double latitude, Double longitude,
			Double magnitude, String mag_type, Double depth, Integer phasecount, Double azimuth_gap, String location,
			String agency, LocalDateTime datetimeFM, Double latFM, Double lonFM, Double magFM, String magTypeFM,
			Double depthFM, Integer phasecountFM, Double azGapFM, Double scalarMoment, Double mrr, Double mtt,
			Double mpp, Double mrt, Double mrp, Double mtp, Double varianceReduction, Double doubleCouple, Double clvd,
			Integer strikeNP1, Integer dipNP1, Integer rakeNP1, Integer strikeNP2, Integer dipNP2, Integer rakeNP2,
			Double azgapFM2, Double misfit) {
		super();
		this.id = id;
		this.eventID = eventID;
		this.datetime = datetime;
		this.latitude = latitude;
		this.longitude = longitude;
		this.magnitude = magnitude;
		this.mag_type = mag_type;
		this.depth = depth;
		this.phasecount = phasecount;
		this.azimuth_gap = azimuth_gap;
		this.location = location;
		this.agency = agency;
		this.datetimeFM = datetimeFM;
		this.latFM = latFM;
		this.lonFM = lonFM;
		this.magFM = magFM;
		this.magTypeFM = magTypeFM;
		this.depthFM = depthFM;
		this.phasecountFM = phasecountFM;
		AzGapFM = azGapFM;
		this.scalarMoment = scalarMoment;
		Mrr = mrr;
		Mtt = mtt;
		Mpp = mpp;
		Mrt = mrt;
		Mrp = mrp;
		Mtp = mtp;
		this.varianceReduction = varianceReduction;
		this.doubleCouple = doubleCouple;
		this.clvd = clvd;
		this.strikeNP1 = strikeNP1;
		this.dipNP1 = dipNP1;
		this.rakeNP1 = rakeNP1;
		this.strikeNP2 = strikeNP2;
		this.dipNP2 = dipNP2;
		this.rakeNP2 = rakeNP2;
		azgapFM = azgapFM2;
		this.misfit = misfit;
	}
	public EarthquakeData() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
