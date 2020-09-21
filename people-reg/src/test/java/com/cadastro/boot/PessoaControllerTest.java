package com.cadastro.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cadastro.boot.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PessoaControllerTest.class, secure = false)
public class PessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PersonService pessoaService;

//	Course mockCourse = new Course("Course1", "Spring", "10 Steps",
//			Arrays.asList("Learn Maven", "Import Project", "First Example",
//					"Second Example"));
//	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

//		Mockito.when(pessoaService.retrieveCourse(Mockito.anyString(), Mockito.anyString())).thenReturn(mockCourse);

//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/Student1/courses/Course1").accept(MediaType.APPLICATION_JSON);

//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

//		System.out.println(result.getResponse());
//		String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K
		// Students","steps":["Learn Maven","Import Project","First Example","Second
		// Example"]}

//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
