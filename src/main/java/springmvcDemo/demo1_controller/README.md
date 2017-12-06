开始SpringMVC   流程图 imgs/requestRoute.png

先看一个请求的流程
1. 点击链接或着提交表单，请求开始，就像送快递一样，请求要经过很多的站点
2. 请求离开浏览器，携带URL和用户的信息，到达第一占 DispatcherServlet（前端控制器，dispatcher 本身的意思就是调度员，调度程序，分配器），
        所以  DispatcherServlet 的工作就是，收集请求，并将请求发送到指定的 控制器（Controller，就是我们自己写的 Controller，@RequestMapping）。
3. 要找到正确的控制器，需要匹配，DispatcherServlet 从 Handler Mapping 查找




。。。暂时跳过。。。


Spring的传入参数的几种方式
	1. 查询参数		/home.do?name=111&age=23	参数风格
	2. 表单参数		form的action不写的话，提交到这个页面的Url上
	3. 路径变量		/home.do/111/23				restful风格
	
	javax.Validation.Contraints 注解放在属性中，限制属性的值
	@AssertFalse		所注解的元素必须是Boolean类型，并且值为 false
	@AssertTrue		所注解的元素必须是Boolean类型，并且值为 true
	@DecimalMax		所注解的元素必须是数字，并且它的值要小于或等于给定的BigDecimalString 值
	@DecimalMin		所注解的元素必须是数字，并且它的值要大于或等于给定的BigDecimalString 值
	@Digits			所注解的元素必须是数字，并且它的值必须有指定的位数
	@Future			所注解的元素的值必须是一个将来的日期
	@Max				所注解的元素必须是数字，并且它的值要小于或等于给定的值
	@Min				所注解的元素必须是数字，并且它的值要大于或等于给定的值
	@NotNull			所注解元素的值必须不能为 null
	@Null			所注解元素的值必须为 null
	@Past			所注解的元素的值必须是一个已过去的日期
	@Pattern			所注解的元素的值必须匹配给定的正则表达式
	@Size			所注解的元素的值必须是 String 、集合或数组，并且它的长度要符合给定的范围