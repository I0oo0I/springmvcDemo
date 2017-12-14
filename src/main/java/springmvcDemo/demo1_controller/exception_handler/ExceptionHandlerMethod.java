package springmvcDemo.demo1_controller.exception_handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerMethod {

    //空指针异常
    @ExceptionHandler(NullPointerException.class)  
    @ResponseBody  
    public String nullPointerExceptionHandler(NullPointerException ex) {  
        ex.printStackTrace();
        return null;
    }
    
    
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public String systemException2(SystemException ex) {
    	ex.printStackTrace();
    	return ex.getMessage();
    }
    
    //运行时异常
    @ExceptionHandler(RuntimeException.class)  
    @ResponseBody  
    public String runtimeExceptionHandler(RuntimeException runtimeException) {  
        return null;
    }  
}
