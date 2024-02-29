package com.sudhir.controllers;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.services.PointCalculatorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/point-service")
@Slf4j
public class PointCalculatorController {
	Logger logger = LoggerFactory.getLogger(PointCalculatorController.class);
	
	@Autowired
	private PointCalculatorService pointCalculatorService;

	@GetMapping("/rewards")
	public ResponseEntity<String> getRewardPoints(@RequestParam(name = "ID", required = true) Long id) {
		try {
			if (id <= 0) {
				new ServiceException("ID can't be negative or Zero");
			}
			return new ResponseEntity<>(""+pointCalculatorService.getRewardPoints(id), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Error in PointCalculatorController {} ", ex);
		}
		return null;

	}

}
