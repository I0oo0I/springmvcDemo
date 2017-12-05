package springmvcDemo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HomeControllerTest {

	@Test
	public void TestHome() throws Exception {
		HomeController homeController = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
		mockMvc.perform(get("/"))			//执行get请求
			.andExpect(view().name("home")); 	//预期得到的视图
	}
}
