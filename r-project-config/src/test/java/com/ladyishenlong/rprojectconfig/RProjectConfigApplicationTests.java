package com.ladyishenlong.rprojectconfig;

import com.ladyishenlong.rprojectconfig.mq.MQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RProjectConfigApplicationTests {

	@Autowired
	public MQSender mqSender;

	@Test
	public void contextLoads() {
	}


	@Test
	public void send(){
		mqSender.send();
	}

}
