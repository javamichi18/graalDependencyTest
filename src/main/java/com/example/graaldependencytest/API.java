package com.example.graaldependencytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@Controller
public class API {

    @jakarta.annotation.Resource //--> NPE
    //    @Autowired // --> works
    private TestService service;

    private static final Logger log = LoggerFactory.getLogger( API.class );


    public API() {
        log.info("init API");
    }


    @GetMapping("/foo")
    public ResponseEntity<String> getFoo() {

        log.info("API:foo");
        service.foo("bar");

        return ResponseEntity.ok("foo");
    }


    //@jakarta.annotation.Resource //--> NPE
    public void setService(TestService service) {
        this.service = service;
    }

    /*
    2022-11-30T13:25:30.075+01:00  INFO 19357 --- [           main] c.e.g.GraalDependencyTestApplication     : Started GraalDependencyTestApplication in 0.04 seconds (process running for 0.052)
    2022-11-30T13:25:36.231+01:00  INFO 19357 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
    2022-11-30T13:25:36.231+01:00  INFO 19357 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
    2022-11-30T13:25:36.231+01:00  INFO 19357 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 0 ms
    2022-11-30T13:25:36.232+01:00  INFO 19357 --- [nio-8080-exec-1] com.example.graaldependencytest.API      : API:foo
    2022-11-30T13:25:36.233+01:00 ERROR 19357 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.NullPointerException] with root cause

    java.lang.NullPointerException: null
    	at com.example.graaldependencytest.API.getFoo(API.java:26) ~[gdt:na]
    	at java.base@17.0.5/java.lang.reflect.Method.invoke(Method.java:568) ~[gdt:na]
    	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:207) ~[gdt:6.0.2]
    	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:152) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:884) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1080) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:973) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1003) ~[gdt:6.0.2]
    	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:895) ~[gdt:6.0.2]
    	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:705) ~[gdt:6.0]
    	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:880) ~[gdt:6.0.2]
    	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:814) ~[gdt:6.0]
    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:223) ~[na:na]
    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
    	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[gdt:10.1.1]
    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
    	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[gdt:6.0.2]
    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[gdt:6.0.2]
    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
    	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[gdt:6.0.2]
    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[gdt:6.0.2]
    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
    	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[gdt:6.0.2]
    	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[gdt:6.0.2]
    	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
    	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
    	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[na:na]
    	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[na:na]
    	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) ~[gdt:10.1.1]
    	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:119) ~[na:na]
    	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[gdt:10.1.1]
    	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[na:na]
    	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) ~[na:na]
    	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:400) ~[na:na]
    	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[gdt:10.1.1]
    	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:861) ~[na:na]
    	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1739) ~[na:na]
    	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[gdt:10.1.1]
    	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
    	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
    	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[na:na]
    	at java.base@17.0.5/java.lang.Thread.run(Thread.java:833) ~[gdt:na]
    	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775) ~[gdt:na]
    	at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:203) ~[na:na]
     */
}
