package com.HumanCloud.todolist.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Size(min = 2,message = "Name should contain at-least 2 characters, Please enter the correct name")
    private String firstName;


    private String lastName;

    @Size(min = 10, message = "Please enter the valid number.")
    private String phoneNumber;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "assignedBy")
    List<Task> tasks;

}
