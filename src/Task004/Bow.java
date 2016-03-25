package Task004;

import Task004.Interface.Weapon;

/**
 * Created by User on 24.02.16.
 */
public class Bow implements Weapon {
    String name = "BigBow";
    String type = "two-handed";
    int damage = 10;
    @Override
    public String inf_Weapon() {
        String temp = "name" + name+" type: "+type+" damage: "+damage;
        return temp;
    }

    @Override
    public void upWeapon() {
damage += 6 ;
    }

    @Override
    public int getWeaponsAttackPower() {
        return damage;
    }


}
