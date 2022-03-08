package training360.gardenservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sv2021JvjbfKepesitovizsgaPotPotApplication {


    public static void main(String[] args) {
        SpringApplication.run(Sv2021JvjbfKepesitovizsgaPotPotApplication.class, args);
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}

