package springmvcDemo.demo1_controller.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 注意：Spring4，javax.servlet-api 版本要在3以上，如果还用2.5版本，这里测试会报错
 * @author Administrator
 *
 */
public class HomeControllerTest {

	
	@Test
	public void testHome() throws Exception {
		HomeController home = new HomeController();
		MockMvc mvc = MockMvcBuilders.standaloneSetup(home).build();
		mvc.perform(get("/api/home/home/aaa/25"));
//		
//		mvc.perform(get("/home2?name=bbb&age=23"));
		
		//mvc.perform(get("/home5?name=aa&id=1&age=10&email=1"));
	}
}
