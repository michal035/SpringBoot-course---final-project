// package com.backend.project;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.hamcrest.Matchers.containsString;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.web.servlet.MockMvc;


// @SpringBootTest
// @AutoConfigureMockMvc
// class ProjectApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// 	@Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void testDefaultMessage() throws Exception {
//         this.mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk())
//                 .andExpect(content().string(containsString("Get short url")));
//     }

// }
