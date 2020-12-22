package com.covid.covidmanagement.model;

public class PersonDto {

    private  Integer personId;
    private  String personName;
    private String personAddress;


    public  PersonDto(){

    }

    public  PersonDto(String personName,String personAddress) {

        this.personName = personName;
        this.personAddress = personAddress;

    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }
}
