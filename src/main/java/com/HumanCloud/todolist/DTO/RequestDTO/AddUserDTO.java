package com.HumanCloud.todolist.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserDTO {

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
