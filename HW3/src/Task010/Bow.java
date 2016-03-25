package Task010;

import Task010.Interface.Weapon;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */

@Component
public class Bow implements Weapon {
    String name = "BigBow";
    String type = "two-handed";
    int damage = 10;

    @Override
    public String inf_Weapon() {
        String temp = "name: " + name + " type: " + type + " damage: " + damage;
        return temp;
    }

    @Override
    public void upWeapon() {
        damage += 6;
    }

    @Override
    public int getWeaponsAttackPower() {
        return damage;
    }


}
