/*
 * Copyright (c) 2020 Gigaset Communications GmbH
 */

package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringSleuthApplication {

    @Autowired
    public AppSpringSleuthApplication(){
    }

    public static void main(String[] args) {
        SpringApplication.run(AppSpringSleuthApplication.class, args);
    }


}
