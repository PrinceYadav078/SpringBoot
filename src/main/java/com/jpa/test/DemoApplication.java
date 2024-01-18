package com.jpa.test;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(DemoApplication.class, args);

		UserRepository userRepository= context.getBean(UserRepository.class);

//		User user1= new User();
//		user1.setName("Prince Yadav");
//		user1.setCity("Firozabad");
//		user1.setStatus("I am a Full Stack Developer");
//
//		User user2= new User();
//		user2.setName("Praveen Yadav");
//		user2.setCity("Aligarh");
//		user2.setStatus("I am a Mechanical Engineer");
//
//		List<User> users= List.of(user1,user2);
//		Iterable<User> result= userRepository.saveAll(users);
//
//		result.forEach(user -> {
//			System.out.println(user);
//		});

//		Optional<User> optional= userRepository.findById(1);
//		User user= optional.get();
//
//
//		user.setName("Tushar Satalkar");
//		user.setCity("Pune");
//		user.setStatus("I am a java Developer");
//		User result =userRepository.save(user);
//		System.out.println(result);

		Iterable<User> itr= userRepository.findAll();

//		Iterator<User> iterator= itr.iterator();
//		while (iterator.hasNext()){
//			System.out.println(iterator.next());
//		}

//		itr.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User user) {
//				System.out.println(user);
//			}
//		});

//		itr.forEach(user -> System.out.println(user));

//		userRepository.deleteById(3);

//		List<User> users= userRepository.findByName("prince yadav");
//		users.forEach(user -> System.out.println(user));

//		List<User> users= userRepository.findByNameAndCity("tushar satalkar", "pune");
//		users.forEach(user -> System.out.println(user));

		List<User> getbyalluser= userRepository.getByAllUser();
		getbyalluser.forEach(user -> System.out.println(user));

		System.out.println("------------------------------------------------------");

		List<User> getbyusernameandcity= userRepository.getByNameAndCity("prince yadav", "Firozabad");
		getbyusernameandcity.forEach(user -> System.out.println(user));

		System.out.println("--------------------------by using Native Query means sql query----------------------------");
		userRepository.getAllUsers().forEach(user -> System.out.println(user));
	}

}
