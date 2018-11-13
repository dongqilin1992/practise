package user;

import com.smart.mq.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:activeMq.xml")
public class TestQueueSender {
	/*@Autowired
	private QueueProducer queueProducer;*/
	@Autowired
	private TopicProducer queueProducer;
	
	@Test
	public void testSend(){
		queueProducer.sendTextMessage("spring JMS 发布订阅");
		
	}
	
}
