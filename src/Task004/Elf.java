package Task004;

import Task004.Interface.Ability;
import Task004.Interface.Race;

/**
 * Created by User on 24.02.16.
 */
public class Elf implements Race {
    int health = 5;
    int mana = 10;

    Ability capacity = new Treatment();

    @Override
    public int ability( ) {
        return capacity.getDescription();

    }

    @Override
    public String getFeature( int health, int mana) {
        System.out.print("Elf");
        health += this.health;
        mana +=this.mana;
        String a = "health:" + health + " mana:" + mana;
        return a;
    }


}
