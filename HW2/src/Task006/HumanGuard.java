package Task006;

import Task006.Interface.*;

public class HumanGuard implements Unit {
    String Unit_class = "warrior";
    int lvl;
    int health;
    int mana;
    Race race;
    Inventory inventory;

    public HumanGuard() {
        lvl = 1;
        health = 50;
        mana = 20;
        System.out.println(Unit_class);
    }


    @Override
    public String check_Invent() {
        String inf;
        System.out.println("Weapon: " + inventory.getWeapon());
        System.out.println("Potion: " + inventory.getPotion());
        return inf = "Weapon: " + inventory.getWeapon() + " " + "Potion: " + inventory.getPotion();
    }


    @Override
    public void lvlUp() {
        lvl++;
        health += 10;
        mana += 5;
        inventory.getWeapon1().upWeapon();



    }

    @Override
    public int useSkill() {
        System.out.println("race's ability");
        System.out.println("initial attack: " + inventory.getWeapon1().getWeaponsAttackPower());
        int damage = inventory.getWeapon1().getWeaponsAttackPower();
        damage += race.ability();
        System.out.println("now attack :" + damage);
        return damage;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String getInformation() {
        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + inventory.getWeapon1().getWeaponsAttackPower();
        System.out.println(inf);
        return inf;
    }
}
