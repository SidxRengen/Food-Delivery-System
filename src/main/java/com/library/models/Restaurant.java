package main.java.com.library.models;

import java.time.LocalDateTime;

public class Restaurant extends BaseEntry {
    private String name;
    private String description ;
    private String address ;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;

    public Restaurant(String name, String description , String address , LocalDateTime openTime, LocalDateTime closeTime){
        this.address = address;
        this.description = description;
        this.closeTime = closeTime;
        this.name = name;
        this.openTime = openTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    @Override
    public String toString(){
        return "Restaurant{id= "+getId() +", name= "+name+", description= "+description+", openTime= "+openTime+", closeTime= "+closeTime+", address= "+address+"}";
    }
}
