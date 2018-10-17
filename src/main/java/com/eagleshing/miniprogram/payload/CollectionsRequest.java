package com.eagleshing.miniprogram.payload;

import java.util.HashSet;
import java.util.Set;

public class CollectionsRequest {

    Set<CollectionRequest> collections = new HashSet<>();

    public Set<CollectionRequest> getCollections() {
        return collections;
    }

    public void setCollections(Set<CollectionRequest> collections) {
        this.collections = collections;
    }
}
