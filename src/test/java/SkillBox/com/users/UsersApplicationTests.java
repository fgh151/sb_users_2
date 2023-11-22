package SkillBox.com.users;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = {PostgreSQLInitializer.class})
class UsersApplicationTests {

	@Test
	void contextLoads() {
	}

}
