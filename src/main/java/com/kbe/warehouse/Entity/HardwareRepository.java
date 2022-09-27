package com.kbe.warehouse.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends CrudRepository<Hardware, Integer> {
}
