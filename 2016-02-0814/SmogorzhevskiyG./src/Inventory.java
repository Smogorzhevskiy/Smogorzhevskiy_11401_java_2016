interface Inventory{
    Weapon weapon=null;
    Potion potion=null;
    Clothes clothes=null;
    int weapon_quantity=0;
    int potion_quantity=0;
    public String check_Type_weapon(Weapon weapon);
    public String check_Type_potion(Potion potion);
    public void clean_inventory(int weapon_quantity, int potion_quantity);





}