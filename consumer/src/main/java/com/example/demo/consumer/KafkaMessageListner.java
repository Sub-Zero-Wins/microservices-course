package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListner 
{
	Logger log = LoggerFactory.getLogger(KafkaMessageListner.class);
	
	
	@KafkaListener(topics = "demo" ,groupId="x-group-1")
	public void consumer1(String message)
	{
		log.info("consumer 1 consumed the message {}",message);
	}

}
