package Task006;

import Task006.Interface.Inventory;
import Task006.Interface.Potion;
import Task006.Interface.Weapon;

/**
 * Created by User on 24.02.16.
 */
public class PremiumInvent implements Inventory {
    Weapon weapon1;
    Weapon weapon2;
    Potion potion1;
    Potion potion2;

    @Override
    public String[] getWeapon() {
        String[] temp = new String[2];
        temp[0] = weapon1.inf_Weapon();
        temp[1] = weapon2.inf_Weapon();
        return  temp;
    }

    @Override
    public String[] getPotion() {
        String[] temp = new String[2];
        temp[0] = potion1.infPotion();
        temp[1] = potion2.infPotion();
        return  temp;
    }

    @Override
    public Weapon getWeapon1() {
        return weapon1;
    }

    @Override
    public Weapon getWeapon2() {
        return weapon2;
    }

    @Override
    public Potion getPotion1() {
        return potion1;
    }

    @Override
    public Potion getPotion2() {
        return potion2;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    public void setPotion1(Potion potion1) {
        this.potion1 = potion1;
    }

    public void setPotion2(Potion potion2) {
        this.potion2 = potion2;
    }
}
