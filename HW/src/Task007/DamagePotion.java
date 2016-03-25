package Task007;

import Task007.Interface.Ability;
import Task007.Interface.Potion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 23.02.16.
 */
@Component
public class DamagePotion implements Potion {
    String name = "PowerGod";
    @Autowired
    @Qualifier("anger")
    Ability effect;

    int damage;

    @Override
    public String infPotion() {
        damage = effect.getDescription();
        String temp = "name: " + name + " effect: +" + damage + "attack";
        return temp;
    }
}
