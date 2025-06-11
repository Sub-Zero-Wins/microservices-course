package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher
{
	@Autowired
	private KafkaTemplate<String,Object> template;
	
	public void sendMessageToTopic(String message)
	{
	  CompletableFuture<SendResult<String,Object>> future= template.send("demo",message);
	  future.whenComplete((result,ex)->{
	  if(ex==null) {
		  System.out.println("sent message=[" +message+ "] with offset ["+ result.getRecordMetadata().offset()+ "]");
	  }
	  else
	  {
		  System.out.println("unable to send message [" +message + "] due  to : "+ex.getMessage());
	  }
	  });
	}

}
