package com.papasani.learnings.csvtojson;

import java.io.File;
import java.util.List;
import java.util.Map;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
 
public class CsvToJson {
 
    public static void main(String[] args) throws Exception {
        
  
    	File input = new File("C:\\Users\\ravitejapapasani\\Desktop\\Boot\\csv-json\\src\\main\\java\\com\\papasani\\learnings\\data\\mydata.csv");
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
 
        // Reading the data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
 
        ObjectMapper mapper = new ObjectMapper();
 
        // Writing the JSON formated data to mydata.json file
        File output = new File("C:\\Users\\ravitejapapasani\\Desktop\\Boot\\csv-json\\src\\main\\java\\com\\papasani\\learnings\\data\\mydata.json");
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
        
        // Writing the JSON formated data to output console
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll));
        
    }
}