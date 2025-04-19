package de.schaeferd.sample.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SampleServerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SampleServerApplication.class, args);
	}
}
