package Task004;

import Task004.Interface.Ability;
import Task004.Interface.Potion;

/**
 * Created by User on 24.02.16.
 */
public class HealthPotion implements Potion {
    String name = "HealthPotion";
    Ability effect = new Treatment();
    int health;

    @Override
    public String infPotion() {
        health = effect.getDescription();
        String temp = "name: " + name + " effect: +" + health + " health";
        return temp;
    }
}
