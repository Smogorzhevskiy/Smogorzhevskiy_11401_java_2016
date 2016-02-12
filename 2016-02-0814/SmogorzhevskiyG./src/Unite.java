interface  Unit{
    String Unit_class=null;
    int health=0;
    int mana=0;
    Race race=null;
    Group group= null;
    Inventory inventory= null;

    public String check_Invent(Inventory inventory,String Unit_class);
    public String check_Accessory(Race race,Group group, String Unit_class);
    public void attack_Enemy(Attack attack);
}
