package com.example.bubli.repository;

import com.example.bubli.domain.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {
}
