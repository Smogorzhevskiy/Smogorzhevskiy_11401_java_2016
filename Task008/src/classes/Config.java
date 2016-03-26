package classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 26.03.16.
 */
@Configuration
@ComponentScan
public class Config {

    @Bean
    public Server server() {
        return new Server();
    }


    @Bean
    public Client client() {
        return new Client();
    }

    @Bean
    public Gamer gamer() {
        return new Gamer();
    }

    @Bean
    public ServerSocket serverSocket() throws IOException {

        return new ServerSocket(4022);

    }
}
