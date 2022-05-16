package com.kbe.warehouse;

import java.util.LinkedList;
import java.util.List;

public class DataStorageImpl implements DataStorage{

    private List<HardwareComponent> hardwareComponentList;

    public DataStorageImpl(){
        hardwareComponentList = new LinkedList<>();
    }

    @Override
    public void saveHardwareComponents(List<HardwareComponent> hardwareComponents) {
        hardwareComponentList.addAll(hardwareComponents);
    }

    @Override
    public List<HardwareComponent> getAllHardwareComponents() {
        return new LinkedList<>(hardwareComponentList);
    }

    @Override
    public List<HardwareComponent> getHardwareComponentsOfType(HardwareComponentType type) {
        List<HardwareComponent> outputList = new LinkedList<>();
        if(type == null) return outputList;
        for (HardwareComponent listItem: hardwareComponentList) {
            if(listItem.getProductType().equals(type)) outputList.add(listItem);
        }
        return outputList;
    }
}
