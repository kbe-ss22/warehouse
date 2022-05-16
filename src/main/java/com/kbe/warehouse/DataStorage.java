package com.kbe.warehouse;

import java.util.List;

public interface DataStorage {
    void saveHardwareComponents(List<HardwareComponent> hardwareComponents);
    List<HardwareComponent> getAllHardwareComponents();
    List<HardwareComponent> getHardwareComponentsOfType(HardwareComponentType type);
}
