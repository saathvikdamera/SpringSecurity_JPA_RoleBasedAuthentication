package in.sta.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.sta.entity.UserEntity;
import in.sta.repository.UserRepository;

@Component
public class Dataloader implements ApplicationRunner {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		UserEntity user = new UserEntity();
		user.setUsername("shrehi");
		user.setPassword("damera");
		user.setRole("ADMIN");
		user.setEnabled(true);
		
		UserEntity user2 = new UserEntity();
		user2.setUsername("saathvik");
		user2.setPassword("damera");
		user2.setRole("USER");
		user2.setEnabled(true);
		
		repo.saveAll(Arrays.asList(user,user2));
	}

}
