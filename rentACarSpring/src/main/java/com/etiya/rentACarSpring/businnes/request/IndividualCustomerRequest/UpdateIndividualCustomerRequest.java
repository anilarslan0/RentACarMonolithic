package com.etiya.rentACarSpring.businnes.request.IndividualCustomerRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {
    @NotNull
    private int userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotNull
    @Size(min=11,max=11)
    private String identityNumber;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
