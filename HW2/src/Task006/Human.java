package Task006;

import Task006.Interface.Ability;
import Task006.Interface.Race;

/**
 * Created by User on 24.02.16.
 */
public class Human implements Race {
    int health = 10;
    int mana = 5;

    Ability capacity;
    @Override
    public int ability( ) {
       return capacity.getDescription();

    }

    @Override
    public String getFeature( int health, int mana) {
        System.out.print("Human");
        health += this.health;
        mana +=this.mana;
        String a = "health:" + health + " mana:" + mana;
        return a;
    }

    public void setCapacity(Ability capacity) {
        this.capacity = capacity;
    }
}
