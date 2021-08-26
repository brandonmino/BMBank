package com.bm.bank.models;

//User Model
public class UserRequestDTO {
    private Long id;
    private String firstName;
    private String lastName;

    public UserRequestDTO() {}

    public UserRequestDTO(Long id) {
        this.id = id;
    }

    public UserRequestDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
