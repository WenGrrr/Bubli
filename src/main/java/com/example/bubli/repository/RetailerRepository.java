package com.example.bubli.repository;

import com.example.bubli.domain.Retailer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RetailerRepository  extends MongoRepository<Retailer, String> {
}
