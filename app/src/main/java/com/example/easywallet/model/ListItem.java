package com.example.easywallet.model;

/**
 * Created by Admin on 10/12/2560.
 */

public class ListItem {
    public final int id;
    public final String details;
    public final int amount;
    public final String picture;

    public ListItem(int id, String details, int amount, String picture) {
        this.id = id;
        this.details = details;
        this.amount = amount;
        this.picture = picture;
    }
}
