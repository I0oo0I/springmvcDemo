package springmvcDemo.demo1_controller.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import springmvcDemo.demo1_controller.data.InputDataValid;
import springmvcDemo.demo1_controller.data.RequestUploadFile;
import springmvcDemo.demo1_controller.exception_handler.SystemException;

@Controller
@RequestMapping("api/home")
public class HomeController {

	/**
	 * restful风格
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/home/{name}/{age}", method=RequestMethod.GET)
	public String home(@PathVariable String name, @PathVariable Integer age) {
		System.out.println("name：" + name + " age：" + age);
		return "myHome";
	}
	
	/**
	 * @RequestParam 不写也可以接收到, defaultValue="ccc" 当value没有值时，可以设置默认值，当然也可以不写
	 * @param name1
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/home2", method=RequestMethod.GET)
	public String home2(@RequestParam(value="name", defaultValue="ccc") String name1, Integer age) {
		System.out.println("name：" + name1 + " age：" + age);
		return "myHome";
	}
	
	@RequestMapping(value="/home3")
	@ResponseBody
	public String home3() {
		return "success";
	}
	
	@RequestMapping(value="/home4")
	public String home4() {
		System.out.println("name：");
		return "myHome";
	}
	
	@RequestMapping(value="/home5")
	@ResponseBody
	public String testInputValid(@Valid InputDataValid data) {
		return "success";
	}
	
	@RequestMapping("/uploadFile")
	public void uploadFile(RequestUploadFile uploadFile) {
		System.out.println(uploadFile.getUsername());
		MultipartFile file = uploadFile.getUploadFile();
		if(null != file) {
			System.out.println(file.getOriginalFilename());
		}
	}
	
	@RequestMapping("/exceptionHandler")
	@ResponseBody
	public String testExceptionHandler() throws SystemException {
		throw new SystemException("抛出异常");
	}
	
}
