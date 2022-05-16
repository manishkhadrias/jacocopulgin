/**
 * 
 */
package com.khadrias.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.khadrias.api.request.PortfolioRequest;
import com.khadrias.services.PortfolioService;

/**
 * @author mkhadria
 *
 */
@RestController
public class PortfolioController {

	@Autowired
	PortfolioService portfolioService;

	@Value("${token}")
	String token;

	@PostMapping("/portfolios")
	public ResponseEntity<String> findOpenPositionProtfolioOfPreviousDay(@RequestHeader String authorization,
			@Valid @RequestBody PortfolioRequest portfolioRequest) {
		if (!authorization.substring(7).equals(token))
			return new ResponseEntity<>("Token is not valid", HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(portfolioService.findOpenPositionProtfolioOfPreviousDay(portfolioRequest),
				HttpStatus.OK);

	}

}
