package com.etiya.rentACarSpring.businnes.request.BrandRequest;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {

	@NotNull
	@NotBlank(message = "Marka Boş Bırakılamaz.")
	private String brandName;

}
