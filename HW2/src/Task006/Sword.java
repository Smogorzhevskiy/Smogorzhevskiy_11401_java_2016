package Task006;

import Task006.Interface.Weapon;

/**
 * Created by User on 12.02.16.
 */
public class Sword implements Weapon {
    String name;
    String type;
    int damage;

    public Sword() {
        this.name = "Gladius";
        this.type = "one-handed";
        this.damage = 10;
    }

    @Override
    public String inf_Weapon() {
        return "name: " + name + " type: " + type + " damage: " + damage;
    }

    @Override
    public void upWeapon() {
        damage += 5;
    }

    @Override
    public int getWeaponsAttackPower() {
        return this.damage;
    }

}
