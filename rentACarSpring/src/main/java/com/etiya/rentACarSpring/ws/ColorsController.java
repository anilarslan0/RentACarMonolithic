package com.etiya.rentACarSpring.ws;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACarSpring.businnes.abstracts.ColorService;
import com.etiya.rentACarSpring.businnes.request.CreateColorRequest;
import com.etiya.rentACarSpring.businnes.request.DeleteColorRequest;
import com.etiya.rentACarSpring.businnes.request.UpdateColorRequest;
import com.etiya.rentACarSpring.entities.Color;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
	private ColorService colorService;

	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping("all")
	public List<Color> getAll() {
		List<Color> colors = new ArrayList<Color>();
		colors.add(new Color(1,"Siyah"));
		colors.add(new Color(2,"Mavi"));
		colors.add(new Color(3,"Kırmızı"));

		return colors;
	}
	
	@PostMapping("add")
	public void add(@RequestBody CreateColorRequest createColorRequest) {
		this.colorService.save(createColorRequest);
	}
	
	@PutMapping("update")
	public void update(@RequestBody UpdateColorRequest updateColorRequest) {
		this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("delete")
	public void delete(@RequestBody DeleteColorRequest deleteColorRequest) {
		this.colorService.delete(deleteColorRequest);
	}
}
