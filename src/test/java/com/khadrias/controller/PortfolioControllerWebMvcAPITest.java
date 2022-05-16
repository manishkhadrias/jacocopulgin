package com.khadrias.controller;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.khadrias.controllers.PortfolioController;
import com.khadrias.services.PortfolioService;

/**
 * @author mkhadria
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioControllerWebMvcAPITest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PortfolioService portfolioService;

	private final String URI = "/portfolios";

	@Test
	public void findOpenPositionProtfolioOfPreviousDayTest() throws Exception {

		Mockito.when(portfolioService.findOpenPositionProtfolioOfPreviousDay(any())).thenReturn("AC-005 : 31298WTP8 ");
		mvc.perform(MockMvcRequestBuilders.post(URI)
				.content("{\"names\":[\"AC-005\"],\"year\":2022,\"month\":11,\"day\":5}")
				.header("Authorization", "Bearer bWFuaXNoLmtoYWRyaWFAYmxhY2tyb2NrLmNvbQ==")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("AC-005 : 31298WTP8 "));
	}

	@Test
	public void findOpenPositionProtfolioOfPreviousDayUnauthorizedTest() throws Exception {

		Mockito.when(portfolioService.findOpenPositionProtfolioOfPreviousDay(any())).thenReturn("");
		mvc.perform(MockMvcRequestBuilders.post(URI)
				.content("{\"names\":[\"AC-005\"],\"year\":2022,\"month\":11,\"day\":5}")
				.header("Authorization", "Bearer bWFuaXNoLmtoYWRyaWFAYmxhY2tyb2NrLmNvbQ=")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isUnauthorized());

	}

	@Test
	public void findOpenPositionProtfolioOfPreviousDayBadRequestTest() throws Exception {

		Mockito.when(portfolioService.findOpenPositionProtfolioOfPreviousDay(any())).thenReturn("");
		mvc.perform(MockMvcRequestBuilders.post(URI).content("").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
