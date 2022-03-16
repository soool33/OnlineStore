package com.mycompany.onlinestore.backend.entity;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {
    private Set<Work> items = new HashSet<>();

    public ShoppingCart() {
    }

    public Set<Work> getItems() {
        return items;
    }

    public void setItems(Set<Work> items) {
        this.items = items;
    }
}
