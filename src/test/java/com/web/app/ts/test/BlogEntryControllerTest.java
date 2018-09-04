package com.web.app.ts.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;

import com.web.app.ts.BlogEntryController;
import com.web.app.ts.entites.BlogEntry;
import com.web.app.ts.service.BlogEntryService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


public class BlogEntryControllerTest {
	@InjectMocks
	private BlogEntryController bogEntry;
	
	@Mock
	private BlogEntryService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc=	MockMvcBuilders.standaloneSetup(bogEntry).build();
	}
	
	@Test
	public void test() throws Exception{
		mockMvc.perform(get("/test")).andDo(print());
	}
	
	/**
	 * to test the json file we can use JsonPath which is defined in the pom .xml need 
	 * 
	 * andExpect(jsonPath("$.title", is("Test Blog123Entry")))--here is from matcher api
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		mockMvc.perform(
				
				post("/test")
				.content("{\"title\":\"Test Blog123Entry\"}")
				.contentType(MediaType.APPLICATION_JSON)
				)
		
		.andDo(print());
	}
	
	@Test
	public void getExistingBlogEntry()throws Exception{
		BlogEntry entry=new BlogEntry();
		entry.setId(1L);
		entry.setTitle("test title");
		
		when(service.find(1L)).thenReturn(entry);
		
		mockMvc.perform(get("/rest/blog-entries/1")).andDo(print());
		
	}
	

}
