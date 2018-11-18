/*package com.mdkj.health.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.Server;

@Component
@RabbitListener(queues = "lyhTest1")
public class ServerReceiver extends BaseController{
	
	@RabbitHandler
	public void server() {
		Server server = new Server();
		server.setCpu("20%");
		server.setHdd("50%");
		server.setRam("60%");
		server.setRate("80%");
		serverService.save(server);
			
	}

}
*/