public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}












interface Weapon{
    String name_Weapon=null;
    int damage=0;
    int distance=0;
    String type=null;


}
interface Potion{
    String name_Potion=null;
    String type=null;

}
interface Clothes{
 String name_Clothes=null;


}
interface Capacity{
    String name_Capacity=null;
    String effect=null;
    public void description(String name_Capacity,String effect,int damage);
    public void change_effect(String effect);


}
