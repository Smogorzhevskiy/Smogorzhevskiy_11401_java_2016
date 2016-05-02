package Lesson3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by User on 04.03.16.
 */
public class Start {

        public static void main(String[] args) {

            ApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
            Human human = context.getBean(Human.class);
            System.out.print(human.say());
        }
}
