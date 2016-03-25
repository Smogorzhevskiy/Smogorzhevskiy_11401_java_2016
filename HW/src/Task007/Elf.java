package Task007;

import Task007.Interface.Ability;
import Task007.Interface.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */
@Component
public class Elf implements Race {
    int health = 5;
    int mana = 10;

    @Autowired
    @Qualifier("treatment")
    Ability capacity;

    @Override
    public int ability() {
        return capacity.getDescription();

    }

    @Override
    public String getFeature(int health, int mana) {
        System.out.print("Elf");
        health += this.health;
        mana += this.mana;
        String a = "health:" + health + " mana:" + mana;
        return a;
    }


}
