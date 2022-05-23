package com.kbe.warehouse;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadComponentFanCSV implements ReadInput{

    static final String FILEPATH = "";


    @Override
    public List<HardwareComponent> getHardwareComponentsFromFile() {

        List<HardwareComponent> hardwareComponentList = new ArrayList<>();
        Path pathToFile = Paths.get(FILEPATH);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");
                HardwareComponent fanComponent = createComponent(attributes);
                hardwareComponentList.add(fanComponent);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return hardwareComponentList;
    }


    private static HardwareComponent createComponent(String[] metadata) {

        String name = metadata[0];
        String description = metadata[1];
        Float price = Float.parseFloat(metadata[2]);
        String location = metadata[3];
        int stock = Integer.parseInt(metadata[4]);
        HardwareComponentType productType = HardwareComponentType.valueOf(metadata[5]);
        String additionalAttributes = metadata[6];

        return new HardwareComponent(name, description, price, location, stock, productType, additionalAttributes);
    }
}
