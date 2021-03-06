package com.khadrias.controller;

import java.net.URI;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.khadrias.api.request.PortfolioRequest;

/**
 * @author mkhadria
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PortfolioControllerRestTemplateIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	private String baseUrl = "http://localhost:";
	private String baseUri = "/portfolios/";

	private String token = "Bearer bWFuaXNoLmtoYWRyaWFAYmxhY2tyb2NrLmNvbQ==";

	private String authorization = "Authorization";

	@Test
	public void findOpenPositionProtfolioOfPreviousDayTest() {
		try {
			baseUrl = baseUrl + randomServerPort + baseUri;
			URI uri = new URI(baseUrl);
			PortfolioRequest portfolioRequest = new PortfolioRequest();
			portfolioRequest.setDay(5);
			portfolioRequest.setMonth(11);
			portfolioRequest.setYear(2022);
			portfolioRequest.setNames(Arrays.asList("AC-005"));

			HttpHeaders headers = new HttpHeaders();
			headers.add(authorization, token);

			HttpEntity<PortfolioRequest> request = new HttpEntity<>(portfolioRequest, headers);

			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals("AC-005 : 31298WTP8 ", result.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findOpenPositionProtfolioOfPreviousDayBlankTest() {
		try {
			baseUrl = baseUrl + randomServerPort + baseUri;
			URI uri = new URI(baseUrl);
			PortfolioRequest portfolioRequest = new PortfolioRequest();
			portfolioRequest.setDay(5);
			portfolioRequest.setMonth(11);
			portfolioRequest.setYear(2022);
			portfolioRequest.setNames(Arrays.asList("AC-006"));

			HttpHeaders headers = new HttpHeaders();
			headers.add(authorization, token);

			HttpEntity<PortfolioRequest> request = new HttpEntity<>(portfolioRequest, headers);

			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(null, result.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findOpenPositionNoProtfolioOfPreviousDayTest() {
		try {
			baseUrl = baseUrl + randomServerPort + baseUri;
			URI uri = new URI(baseUrl);
			PortfolioRequest portfolioRequest = new PortfolioRequest();
			portfolioRequest.setDay(5);
			portfolioRequest.setMonth(11);
			portfolioRequest.setYear(2022);
			portfolioRequest.setNames(Arrays.asList("AC-007"));

			HttpHeaders headers = new HttpHeaders();
			headers.add(authorization, token);

			HttpEntity<PortfolioRequest> request = new HttpEntity<>(portfolioRequest, headers);

			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

			// Verify request succeed
			Assert.assertEquals(200, result.getStatusCodeValue());
			Assert.assertEquals(null, result.getBody());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
