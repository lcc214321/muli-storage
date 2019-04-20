package tv.muli.mulistorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MuliStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuliStorageApplication.class, args);
    }

}
