package classes;

/**
 * Was taken semester project of Ruben Akhmadiev
 */

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
@Component
public class Server {

    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    public void run() {

        ServerSocket serverSocket = (ServerSocket) context.getBean("serverSocket");
//	Массив слов
        ArrayList<String> words = new ArrayList();

        try {
//	Порт

//	Заполняем массив слов
            words = readFromFile();
            while (true) {
                System.out.println("Ожидание игроков...");

//	Подключение Игрока(Client)
                Socket server = serverSocket.accept();
                System.out.println("Игрок подключился! ");
//	Создание оьдельного потока(Class-a) для каждого Игрока
                Gamer gamer = (Gamer) context.getBean("gamer");
                gamer.createGamer(server,words);
                gamer.start();
//                new Gamer(server, words).start();
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //	Записываем слова из файла в Массив
    private ArrayList<String> readFromFile() {
        ArrayList<String> words = new ArrayList();
        try {
            Scanner in = new Scanner(new FileReader("/Users/User/Desktop/Work/Programming/Smogorzhevskiy_11401_java_2016/Tasks2k_4s_2016/Task008/src/resource/words"));
            while (in.hasNext()) {
                words.add(in.next().toLowerCase());
            }
            in.close();
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return words;
    }

    public static void main(String[] args) {
//	Запускаем сервер
        Server server= (Server) context.getBean("server");
        server.run();
    }
}
