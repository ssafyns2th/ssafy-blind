package com.ssafyns.blind;

import com.ssafyns.blind.model.Nick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlindApplication
implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BlindApplication.class, args);
	}

	@Autowired
	private NickService nickService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		nickService.getNickName();
	}
}
