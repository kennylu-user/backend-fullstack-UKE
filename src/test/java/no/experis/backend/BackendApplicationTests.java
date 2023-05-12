package no.experis.backend;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@BeforeEach
	void contextLoads() {
		setUp();
	}
	@Test
	public void getConvertedNrList() throws Exception {
		String uri = "http://localhost:8080/api/v1/convertednr";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	@Test
	public void getLogs() throws Exception{
		String uri = "http://localhost:8080/api/v1/logs";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}
	@Test
	public void getConvertedNrById_X() throws Exception{
		String uri = "http://localhost:8080/api/v1/convertednr/X";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		String str = mvcResult.getResponse().getContentAsString();

		JSONObject jsonObject = new JSONObject(str);
		String actual = jsonObject.get("id").toString();
		assertEquals("X", actual);
		int actual2 = (int) jsonObject.get("converted");
		assertEquals(10,actual2);

	}
	@Test
	public void getConvertedNrById_IV() throws Exception{
		String uri = "http://localhost:8080/api/v1/convertednr/IV";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		String str = mvcResult.getResponse().getContentAsString();

		JSONObject jsonObject = new JSONObject(str);
		String actual = jsonObject.get("id").toString();
		assertEquals("IV", actual);
		int actual2 = (int) jsonObject.get("converted");
		assertEquals(4,actual2);

	}
	@Test
	public void getConvertedNrById_CCCXLVI() throws Exception{
		String uri = "http://localhost:8080/api/v1/convertednr/CCCXLVI";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		String str = mvcResult.getResponse().getContentAsString();

		JSONObject jsonObject = new JSONObject(str);
		String actual = jsonObject.get("id").toString();

		assertEquals("CCCXLVI", actual);
		int actual2 = (int) jsonObject.get("converted");
		assertEquals(346,actual2);

	}





}
