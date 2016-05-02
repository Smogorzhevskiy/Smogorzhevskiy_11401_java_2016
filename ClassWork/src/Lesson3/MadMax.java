package Lesson3;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

/**
 * Created by User on 04.03.16.
 */
public class MadMax implements Human {

//    private ApplicationContext context;
//
//    @Required //  избежание NullPointerException  свойство бина должно было быть установлено на момент конфигурирования
//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }
@Value("Max")
    String name;

    MadMax(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String say() {
        return "Walhall!!!";
    }
}
