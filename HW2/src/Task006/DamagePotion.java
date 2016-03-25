package Task006;

import Task006.Interface.Ability;
import Task006.Interface.Potion;

/**
 * Created by User on 23.02.16.
 */
public class DamagePotion implements Potion {
    String name = "PowerGod";
    Ability effect = new Anger();
    int damage;

    @Override
    public String infPotion() {
        damage = effect.getDescription();
        String temp = "name: " + name + " effect: +" + damage + "attack";
        return temp;
    }

    public void setEffect(Ability effect) {
        this.effect = effect;
    }
}
