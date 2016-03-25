package Task004;

import Task004.Interface.*;

public class HumanGuard implements Unit {
    String Unit_class = "warrior";
    int lvl;
    int health;
    int mana;
    int damage;
    Weapon weapon;
    Potion potion;
    Race race;
    Inventory inventory;

    public  HumanGuard(){
        lvl = 1;
        health = 50;
        mana = 20;
        weapon = new Sword();
        potion = new DamagePotion();
        race = new Human();
        damage = weapon.getWeaponsAttackPower();
        System.out.println(Unit_class);
        inventory = new StandartInvent(weapon, potion);
    }


    @Override
    public String check_Invent() {
        String inf;
        System.out.println( "Weapon: " + inventory.getWeapon());
        System.out.println("Potion: " + inventory.getPotion());
        return  inf = "Weapon: " + inventory.getWeapon() + " " + "Potion: " + inventory.getPotion();


    }


    @Override
    public void lvlUp() {
        lvl ++;
        health += 10;
        mana += 5;
        weapon.upWeapon();
        damage = weapon.getWeaponsAttackPower();


    }

    @Override
    public int useSkill() {
        System.out.println("race's ability");
        System.out.println("initial attack: " + damage);
        damage += race.ability();
        System.out.println("now attack :" + damage);
        return damage;
    }

    @Override
    public String getInformation() {
        String inf = Unit_class + " lvl: " + lvl + " health: " + health + " mana: " + mana + " attack: " + damage ;
        System.out.println(inf);
        return inf;    }
}
