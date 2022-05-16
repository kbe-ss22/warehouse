package com.kbe.warehouse;

import java.util.List;

public class WarehouseImpl implements Warehouse{

    private ReadInput readInput;
    private DataStorage dataStorage;

    public WarehouseImpl(ReadInput readInput, DataStorage dataStorage){
        this.readInput = readInput;
        this.dataStorage = dataStorage;
        readAndSaveData();
    }

    private void readAndSaveData(){
        dataStorage.saveHardwareComponents(readInput.getHardwareComponentsFromFile());
    }

    @Override
    public List<HardwareComponent> getAllHardwareComponents() {
        return dataStorage.getAllHardwareComponents();
    }

    @Override
    public List<HardwareComponent> getHardwareComponentsOfType(HardwareComponentType type) {
        return dataStorage.getHardwareComponentsOfType(type);
    }
}
