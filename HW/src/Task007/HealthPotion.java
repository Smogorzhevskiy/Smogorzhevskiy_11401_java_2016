package Task007;

import Task007.Interface.Ability;
import Task007.Interface.Potion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */
@Component
public class HealthPotion implements Potion {
    String name = "HealthPotion";
    @Autowired
    @Qualifier("treatment")
    Ability effect;
    int health;

    @Override
    public String infPotion() {
        health = effect.getDescription();
        String temp = "name: " + name + " effect: +" + health + " health";
        return temp;
    }
}
