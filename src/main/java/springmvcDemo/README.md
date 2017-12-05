开始SpringMVC   流程图 imgs/requestRoute.png

先看一个请求的流程
1. 点击链接或着提交表单，请求开始，就像送快递一样，请求要经过很多的站点
2. 请求离开浏览器，携带URL和用户的信息，到达第一占 DispatcherServlet（前端控制器，dispatcher 本身的意思就是调度员，调度程序，分配器），
        所以  DispatcherServlet 的工作就是，收集请求，并将请求发送到指定的 控制器（Controller，就是我们自己写的 Controller，@RequestMapping）。
3. 要找到正确的控制器，需要匹配，DispatcherServlet 从 Handler Mapping 查找




。。。暂时跳过。。。

