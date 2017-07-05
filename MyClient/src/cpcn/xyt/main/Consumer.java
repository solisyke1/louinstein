package cpcn.xyt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cpcn.xyt.domain.User;
import cpcn.xyt.service.IEchoService;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * xuting63      2017年5月26日       TODO
 * </pre>
 */
public class Consumer {  
    
    public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring-dubbo.xml" });
        context.start();
  
        IEchoService echoService = (IEchoService) context.getBean("echoService");
        String hello = echoService.echo("Hello, I'm consumer. ");
        System.out.println(hello);
        
        String user = echoService.echoUser(new User("xuyanting", 30, false));
        System.out.println(user);
        
        System.in.read();
    }
  
}  
