
public class magic {

	public String name = "";
	public String element = "";
	public int dmg = 0;

	public static magic ice() {

		magic ice = new magic();// magia de hielo
		ice.name = "Hielo";
		ice.element = "Ice";
		ice.dmg = 4;
		return ice;

	}

	public static magic fire() {// magia de fuego
		magic fire = new magic();
		fire.name = "Fuego";
		fire.element = "Fire";
		fire.dmg = 4;
		return fire;
	}

	public static magic Lightning() {// magia de rayo
		magic lightning = new magic();
		lightning.name = "Rayo";
		lightning.element = "Lightning";
		lightning.dmg = 4;
		return lightning;
	}

	public static magic Heal() {// magia curativa
		magic heal = new magic();
		heal.name = "Cura";
		heal.element = "Holy";
		heal.dmg = -2;
		return heal;
	}
}