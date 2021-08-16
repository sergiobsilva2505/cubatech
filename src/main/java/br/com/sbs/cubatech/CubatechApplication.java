package br.com.sbs.cubatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CubatechApplication {

    public static void main(String[] args)  {
        SpringApplication.run(CubatechApplication.class, args);
    }

}
