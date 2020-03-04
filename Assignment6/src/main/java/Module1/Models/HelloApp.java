package Module1.Models;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class HelloApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new
                ClassPathXmlApplicationContext("Module1/springconfig.xml");
        Greeting greeting= context.getBean("greetingname",Greeting.class);
        greeting.sayHello();
    }
}
