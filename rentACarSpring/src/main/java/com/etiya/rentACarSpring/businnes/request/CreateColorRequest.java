package com.etiya.rentACarSpring.businnes.request;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest {

	private String colorName;
}
