package Task010;

import Task010.Interface.Inventory;
import Task010.Interface.Potion;
import Task010.Interface.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 12.02.16.
 */

@Component
public class StandartInvent implements Inventory {
    @Autowired
    @Qualifier("sword")
    Weapon weapon;
    @Autowired
    @Qualifier("damagePotion")
    Potion potion;

    @Override
    public String[] getWeapon() {
        String[] temp = new String[1];
        temp[0] = weapon.inf_Weapon();
        return temp;
    }


    @Override
    public String[] getPotion() {
        String[] temp = new String[1];
        temp[0] = potion.infPotion();
        return temp;
    }

    @Override
    public Weapon getWeapon1() {
        return weapon;
    }

    @Override
    public Weapon getWeapon2() {
        return null;
    }

    @Override
    public Potion getPotion1() {
        return potion;
    }

    @Override
    public Potion getPotion2() {
        return null;
    }

}
