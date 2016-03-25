package Task006;

import Task006.Interface.Inventory;
import Task006.Interface.Potion;
import Task006.Interface.Weapon;

/**
 * Created by User on 12.02.16.
 */
public class StandartInvent implements Inventory {

    Weapon weapon;
    Potion potion;


    @Override
    public String []getWeapon() {
        String[] temp = new String[1];
        temp[0]= weapon.inf_Weapon();
        return temp;
    }


    @Override
    public String []getPotion() {
        String[] temp = new String[1];
        temp[0]= potion.infPotion();
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
