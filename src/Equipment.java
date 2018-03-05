
public class Equipment {
	
	public  String name = "";
	public String element = "";
	public int dmg = 0;
	public int mdmg=0;
	
	public static Equipment sword() {

		Equipment sword = new Equipment();//espada
		sword.name="Espada de mierda";
		sword.dmg = 20;
		sword.element="Normal";
		sword.mdmg=13;
		return sword;

	}

	public static Equipment rod() {// magia de fuego
		Equipment rod = new Equipment();
		rod.name = "Palo";
		rod.element = "Fire";
		rod.dmg = 15;
		rod.mdmg=20;
		return rod;
}}
