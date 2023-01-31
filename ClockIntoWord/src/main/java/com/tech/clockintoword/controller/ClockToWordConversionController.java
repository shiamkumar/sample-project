package com.tech.clockintoword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tech.clockintoword.service.WordConversionService;

@RestController
public class ClockToWordConversionController {

	@Autowired
	public WordConversionService service;

	@GetMapping("/dummy")
	public String dummyRequest() {
		return "this is a dummy request";
	}

	@GetMapping("/timeToWord/{time}")
	public String timeToWord(@PathVariable("time") String time) {

		String[] inputArray = time.split(":");
		int hr = Integer.parseInt(inputArray[0]);
		int min = Integer.parseInt(inputArray[1]);

		String responseHR = "";
		String responseMIN = "";
		try {
			responseHR = service.generateHourToWord(hr);
			responseMIN = service.generateMinuteToWord(min);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String response = responseHR + " " + responseMIN;
		return response;
	}

	@GetMapping("/midDay/{time}")
	public String midDay(@PathVariable("time") String time) {
		String[] inputArray = time.split(":");
		int hr = Integer.parseInt(inputArray[0]);
		int min = Integer.parseInt(inputArray[1]);
		String midDay = service.generateMidDay(hr, min);
		return midDay;
	}

	@GetMapping("/midNight/{time}")
	public String midNight(@PathVariable("time") String time) {
		String[] inputArray = time.split(":");
		int hr = Integer.parseInt(inputArray[0]);
		int min = Integer.parseInt(inputArray[1]);
		String midNight = service.generateMidNight(hr, min);
		return midNight;
	}

}
