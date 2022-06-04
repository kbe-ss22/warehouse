package com.kbe.warehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadComponentCSV implements ReadInput{

    static final String FILEPATH = "src/main/resources/HardwareComponents.csv";

    @Override
    public List<HardwareComponent> getHardwareComponentsFromFile() {

        List<HardwareComponent> hardwareComponentList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILEPATH))) {

            br.readLine();
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
        String description = formatComponentDescription(metadata[1]);
        float price = Float.parseFloat(metadata[2]);
        int stock = Integer.parseInt(metadata[3]);
        HardwareComponentType productType = HardwareComponentType.valueOf(metadata[4].toUpperCase());

        return new HardwareComponent(name, description, price, stock, productType);
    }

    private static String formatComponentDescription(String str)
    {
        String newStr = str.replaceAll("\"","");

        return String.join(" ",newStr.split("\""));
    }
}
