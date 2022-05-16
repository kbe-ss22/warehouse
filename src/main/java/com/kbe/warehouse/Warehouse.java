package com.kbe.warehouse;

import java.util.List;

public interface Warehouse {
    List<HardwareComponent> getAllHardwareComponents();
    List<HardwareComponent> getHardwareComponentsOfType(HardwareComponentType type);
}
