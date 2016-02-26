package Task004;

import Task004.Interface.Inventory;
import Task004.Interface.Potion;
import Task004.Interface.Weapon;

/**
 * Created by User on 24.02.16.
 */
public class PremiumInvent implements Inventory {

    Weapon weapon1;
    Weapon weapon2;
    Potion potion1;
    Potion potion2;

    public PremiumInvent(Weapon weapon1, Weapon weapon2, Potion potion1, Potion potion2) {
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.potion1 = potion1;
        this.potion2 = potion2;
    }
    @Override
    public String getWeapon() {
        weapon1.inf_Weapon();
        return weapon2.inf_Weapon();
    }

    @Override
    public String getPotion() {
        potion2.infPotion();
        return potion2.infPotion();
    }


}
