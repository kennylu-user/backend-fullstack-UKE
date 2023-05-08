package no.experis.backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.experis.backend.models.ConvertedNr;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BackendApplicationTests {
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@BeforeEach
	void contextLoads() {
		setUp();
	}
	@Test
	public void getConvertedNrList() throws Exception {
		setUp();
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
