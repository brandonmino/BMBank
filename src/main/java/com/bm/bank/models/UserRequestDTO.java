package com.bm.bank.models;

//User Model for making a request
public class UserRequestDTO {
    private String firstName;
    private String lastName;

    public UserRequestDTO() {}

    public UserRequestDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
