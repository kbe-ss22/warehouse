package com.kbe.warehouse.config;

import com.kbe.warehouse.Domain.csv.CSVLoader;
import com.kbe.warehouse.Domain.csv.CSVLoaderImpl;
import com.kbe.warehouse.Domain.db.DBHandler;
import com.kbe.warehouse.Domain.db.DBHandlerImpl;
import com.kbe.warehouse.Domain.converter.WarehouseToJsonConverter;
import com.kbe.warehouse.Domain.converter.WarehouseToJsonConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public DBHandler dbHandler(){ return new DBHandlerImpl(); }
    @Bean
    public WarehouseToJsonConverter warehouseToJsonConverter(){ return new WarehouseToJsonConverterImpl(); }
    @Bean
    public CSVLoader csvLoader(){ return new CSVLoaderImpl(); }
}
