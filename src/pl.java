import java.util.ArrayList;

public class pl {
	
	
	public String name="";
	public int lvl=0;
	public int hp=0;
	public int hpmax=0;
	public int atk=0;
	public int def=0;
	public int mag=0;
	public int res=0;
	public int exp=0;
	public int expmax=0;
	public ArrayList<magic> magias = new ArrayList<magic>();
	public ArrayList<Equipment> equipo = new ArrayList<Equipment>();
	

	
 public static pl pl1(){
	 pl pl1=new pl();
	 pl1.name="player1";
	 pl1.lvl=1;
	 pl1.hp=45;
	 pl1.hpmax=45;
	 pl1.atk=20;
	 pl1.def=18;
	 pl1.mag=10;
	 pl1.res=15;
	 pl1.exp=0;
	 pl1.expmax=100;
	 pl1.magias.add(magic.ice());
	 pl1.equipo.add(Equipment.sword());
	 
	 return pl1;
	 
	 
 }
 public static pl pl2(){
	 pl pl2=new pl();
	 pl2.name="player2";
	 pl2.lvl=1;
	 pl2.hp=35;
	 pl2.hpmax=35;
	 pl2.atk=10;
	 pl2.def=15;
	 pl2.mag=20;
	 pl2.res=18;
	 pl2.exp=0;
	 pl2.expmax=100;
	 pl2.magias.add(magic.fire());
	 pl2.magias.add(magic.Heal());
	 pl2.equipo.add(Equipment.rod());
	 return pl2;
 }

}
