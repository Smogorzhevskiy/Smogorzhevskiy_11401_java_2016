package Task010;

import Task010.Interface.Ability;
import Task010.Interface.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */

@Component
public class Human implements Race {
    int health = 10;
    int mana = 5;

    @Autowired
    @Qualifier("anger")
    Ability capacity;

    @Override
    public int ability() {
        return capacity.getDescription();

    }

    @Override
    public String getFeature(int health, int mana) {
        System.out.print("Human");
        health += this.health;
        mana += this.mana;
        String a = "health:" + health + " mana:" + mana;
        return a;
    }
}
