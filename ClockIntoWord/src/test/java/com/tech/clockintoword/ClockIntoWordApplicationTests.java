package com.tech.clockintoword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ClockIntoWordApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mock;

	@BeforeEach
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void timeToWordTest() throws Exception {
		MvcResult result = mock.perform(get("/timeToWord/08:35"))
			//.andDo(print())
			.andExpect(content().contentType("text/plain;charset=UTF-8"))
			.andExpect(status().isOk())
			.andReturn();
		assertEquals("eight thirty five", result.getResponse().getContentAsString());
	}

	@Test
	void midDayTest() throws Exception {
		MvcResult result = mock.perform(get("/midDay/12:00"))
			//.andDo(print())
			.andExpect(content().contentType("text/plain;charset=UTF-8"))
			.andExpect(status().isOk())
			.andReturn();
		assertEquals("It's Midday", result.getResponse().getContentAsString());
	}

	@Test
	void midnightTest() throws Exception {
		MvcResult result = mock.perform(get("/midNight/00:00"))
			//.andDo(print())
			.andExpect(content().contentType("text/plain;charset=UTF-8"))
			.andExpect(status().isOk())
			.andReturn();
		assertEquals("It's Midnight", result.getResponse().getContentAsString());
	}

}
