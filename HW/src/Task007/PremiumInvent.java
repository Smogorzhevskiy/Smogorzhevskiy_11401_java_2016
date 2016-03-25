package Task007;

import Task007.Interface.Inventory;
import Task007.Interface.Potion;
import Task007.Interface.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 24.02.16.
 */
@Component
public class PremiumInvent implements Inventory {
    @Autowired
    @Qualifier("sword")
    Weapon weapon1;
    @Autowired
    @Qualifier("bow")
    Weapon weapon2;
    @Autowired
    @Qualifier("damagePotion")
    Potion potion1;
    @Autowired
    @Qualifier("healthPotion")
    Potion potion2;

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

    @Override
    public String[] getWeapon() {
        String[] temp = new String[2];
        temp[0] = weapon1.inf_Weapon();
        temp[1] = weapon2.inf_Weapon();
        return temp;
    }

    @Override
    public String[] getPotion() {
        String[] temp = new String[2];
        temp[0] = potion1.infPotion();
        temp[1] = potion2.infPotion();
        return temp;
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
