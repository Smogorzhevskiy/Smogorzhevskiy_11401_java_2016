package Task004;

import Task004.Interface.Inventory;
import Task004.Interface.Potion;
import Task004.Interface.Weapon;

/**
 * Created by User on 12.02.16.
 */
public class StandartInvent implements Inventory {

    Weapon weapon;
    Potion potion;

    public StandartInvent(Weapon weapon, Potion potion) {
       this.weapon = weapon;
        this.potion = potion;
    }

    @Override
    public String getWeapon() {
        return weapon.inf_Weapon();
    }


    @Override
    public String getPotion() {
        return potion.infPotion();
    }

}
