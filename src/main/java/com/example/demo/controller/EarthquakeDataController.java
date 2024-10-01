package com.example.demo.controller;

import com.example.demo.entity.EarthquakeData;
import com.example.demo.service.EarthquakeDataService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/earthquake-data")
public class EarthquakeDataController {

	@Autowired
    private EarthquakeDataService service;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("filePath") String filePath) {
        try {
            service.parseAndSaveData(filePath);
            return "Data parsed and saved successfully.";
        } catch (IOException e) {
            return "Error parsing file: " + e.getMessage();
        }
    }

    @GetMapping("/{eventID}")
    public EarthquakeData getRecordByEventID(@PathVariable String eventID) {
        return service.getRecordByEventID(eventID);
    }
}
