package com.freya.springbean;

import com.freya.springbean.way1.MessageService;
import com.freya.springbean.way1.config.BeanConfig;
import com.freya.springbean.way2.FreyaService;
import com.freya.springbean.way3.EricService;
import com.freya.springbean.way4.NickListener0;
import com.freya.springbean.way4.NickListener1;
import com.freya.springbean.way4.NickListener2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringbootBeanInitDestroyApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootBeanInitDestroyApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);
		context.registerBean("freya", FreyaService.class);
		context.registerBean("eric", EricService.class);
		context.registerBean("nick0", NickListener0.class);
		context.registerBean("nick1", NickListener1.class);
		context.registerBean("nick2", NickListener2.class);

		context.refresh();

		context.start();

		MessageService service = (MessageService) context.getBean("message");
		log.info("Message:【{}】", service);

		FreyaService freyaService = (FreyaService) context.getBean("freya");
		log.info("Freya:【{}】", freyaService);

		EricService ericService = (EricService) context.getBean("eric");
		log.info("Eric:【{}】", ericService);


		context.close();
	}

}
