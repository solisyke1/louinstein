package cpcn.xyt.main;

import java.util.concurrent.ExecutionException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Reference;

import cpcn.xyt.domain.Person;
import cpcn.xyt.interf.SearchNotify;
import cpcn.xyt.service.IRecallService;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * xuting63      2017年6月21日       TODO
 * </pre>
 */
@Component
public class DubboClient {
    
    @Reference
    private IRecallService recallService;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        run();
    }
    
    private static void run() throws InterruptedException, ExecutionException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo-client.xml" });  
        context.start();
        IRecallService recallService2 = (IRecallService) context.getBean("recallService");  
        //调用后立即返回null  

        /* System.out.println("调用开始时间：" + System.nanoTime());
        Person person = recallService2.getPerson("xuyanting", 30);
        System.out.println("调用返回时间：" + System.nanoTime());
        
        System.out.println("立即返回:" + person);
        
       Future<Person> pFuture = RpcContext.getContext().getFuture();
        person = pFuture.get();
        System.out.println("异步调用返回：" + person);*/
        
        
        // 异步回调
        SearchNotify searchNotify = (SearchNotify) context.getBean("searchNotify");
        int requestId = 2;
        Person person2 = recallService2.get(requestId);
        System.out.println("立即调用:" + person2);
        for (int i = 0; i < 10; i++) {
            if (!searchNotify.ret.containsKey(requestId)) {
                Thread.sleep(200);
            } else {
                break;
            }
        }
        System.out.println(searchNotify.ret.get(requestId));
    }  
     
}

