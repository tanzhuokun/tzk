package com.mdkj.health;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mdkj.system.SystemInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthPlatformApplicationTests {

	@Test
	public void contextLoads() {
		SystemInfo info = new SystemInfo();
		System.out.print(info.getDefaultIpAddress());
	}

}
