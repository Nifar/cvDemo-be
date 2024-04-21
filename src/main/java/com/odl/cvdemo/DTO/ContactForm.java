package com.odl.cvdemo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContactForm {

    @NotNull
    @NotBlank
    String name;

    @NotNull
    @NotBlank
    @Email
    String email;

    @NotNull
    @NotBlank
    String message;
}
