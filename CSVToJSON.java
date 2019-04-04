package com.ap.csv;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVToJSON {
  public static void main(String[] args) throws IOException {
	
	  File file = new File("F:\\sample.csv");
	  ObjectMapper om = new ObjectMapper();
	  CsvMapper mapper = new CsvMapper();
	  CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
	  MappingIterator<Map<String,String>> it = mapper.readerFor(Map.class)
	     .with(schema)
	     .readValues(file);
	  while (it.hasNext()) {
	    Map<String,String> rowAsMap = it.next();
	    System.out.println(om.writeValueAsString(rowAsMap));
	   
	  }
}
}
