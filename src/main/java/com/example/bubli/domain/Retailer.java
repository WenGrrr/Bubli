package com.example.bubli.domain;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.UUID;

@Document("retailer")
public class Retailer {
    @Id
    private UUID id;
    @Nullable
    private String name;
    @Nullable
    @DocumentReference
    private User chiefId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getChiefId() {
        return chiefId;
    }

    public void setChiefId(User chiefId) {
        this.chiefId = chiefId;
    }
}