package com.colombo.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.colombo.properties.dto.CreatePropertyRequest;
import com.colombo.properties.dto.Response;
import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
import com.colombo.properties.model.Property;
//import com.colombo.properties.dto.UpdatePropertyDisplayRequest;
import com.colombo.properties.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/create")
	public Response createProperty(
			@RequestBody CreatePropertyRequest request
			) {
		Response response = null;

		try {
			Property property;
//			property = propertyService.saveProperty(request);
			property = propertyService.getProperty(21l);
			response = new Response("Property saved successfully", 201, property.getLocation());

		} catch (Exception e) {

			response = new Response("Error saving propety", 400);
		}

		return response;
	}

	@PutMapping("/update-display")
	public Response updateStatusOfDisplay(@RequestBody UpdatePropertyDisplayRequest request) {
		Response response = null;

		try {
			propertyService.updatePropertyDisplay(request);

			response = new Response("Property display status updated", 200);
		} catch (Exception e) {
			System.out.println(e);
			response = new Response("Error updating property display status", 400);
		}

		return response;

	}

}
