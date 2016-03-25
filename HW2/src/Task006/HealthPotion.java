package Task006;

import Task006.Interface.Ability;
import Task006.Interface.Potion;

/**
 * Created by User on 24.02.16.
 */
public class HealthPotion implements Potion {
    String name = "HealthPotion";
    Ability effect;
    int health;

    @Override
    public String infPotion() {
        health = effect.getDescription();
        String temp = "name: " + name + " effect: +" + health + " health";
        return temp;
    }

    public void setEffect(Ability effect) {
        this.effect = effect;
    }
}
