package com.example.demo.service;

import com.example.demo.entity.EarthquakeData;
import com.example.demo.repository.EarthquakeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EarthquakeDataService {

    @Autowired
    private EarthquakeDataRepository repository;

    public void parseAndSaveData(String filePath) throws IOException {
        List<EarthquakeData> earthquakeDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                
                if (fields.length >= 33) {  // Ensure all fields are present
                    EarthquakeData data = new EarthquakeData();
                    data.setEventID(fields[0]);
                    data.setDatetime(parseDateTime(fields[1]));
                    data.setLatitude(parseDouble(fields[2]));
                    data.setLongitude(parseDouble(fields[3]));
                    data.setMagnitude(parseDouble(fields[4]));
                    data.setMag_type(fields[5]);
                    data.setDepth(parseDouble(fields[6]));
                    data.setPhasecount(parseInteger(fields[7]));
                    data.setAzimuth_gap(parseDouble(fields[8]));
                    data.setLocation(fields[9]);
                    data.setAgency(fields[10]);
                    data.setDatetimeFM(parseDateTime(fields[11]));
                    data.setLatFM(parseDouble(fields[12]));
                    data.setLonFM(parseDouble(fields[13]));
                    data.setMagFM(parseDouble(fields[14]));
                    data.setMagTypeFM(fields[15]);
                    data.setDepthFM(parseDouble(fields[16]));
                    data.setPhasecountFM(parseInteger(fields[17]));
                    data.setAzGapFM(parseDouble(fields[18]));
                    data.setScalarMoment(parseDouble(fields[19]));
                    data.setMrr(parseDouble(fields[20]));
                    data.setMtt(parseDouble(fields[21]));
                    data.setMpp(parseDouble(fields[22]));
                    data.setMrt(parseDouble(fields[23]));
                    data.setMrp(parseDouble(fields[24]));
                    data.setMtp(parseDouble(fields[25]));
                    data.setVarianceReduction(parseDouble(fields[26]));
                    data.setDoubleCouple(parseDouble(fields[27]));
                    data.setClvd(parseDouble(fields[28]));
                    data.setStrikeNP1(parseInteger(fields[29]));
                    data.setDipNP1(parseInteger(fields[30]));
                    data.setRakeNP1(parseInteger(fields[31]));
                    data.setStrikeNP2(parseInteger(fields[32]));
                    data.setDipNP2(parseInteger(fields[33]));
                    data.setRakeNP2(parseInteger(fields[34]));
                    data.setAzgapFM(parseDouble(fields[35]));
                    data.setMisfit(parseDouble(fields[36]));

                    earthquakeDataList.add(data); }
            }
        }
        repository.saveAll(earthquakeDataList);
    }

    public EarthquakeData getRecordByEventID(String eventID) {
        return repository.findByEventID(eventID).orElse(null);
    }
}
