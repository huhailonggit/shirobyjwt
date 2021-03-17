package vip.huhailong.shirobyjwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("vip.huhailong.shirobyjwt.mapper")
@SpringBootApplication
public class ShirobyjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirobyjwtApplication.class, args);
	}

}
