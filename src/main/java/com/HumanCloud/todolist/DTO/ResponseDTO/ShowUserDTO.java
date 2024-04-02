package com.HumanCloud.todolist.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowUserDTO {
    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Integer numberOfTasks;
}
