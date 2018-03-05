
public class el {
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
		

		
	 public static el el1(){
		 el el1=new el();
		 el1.name="enemy1";
		 el1.lvl=1;
		 el1.hp=90;
		 el1.hpmax=90;
		 el1.atk=20;
		 el1.def=2;
		 el1.mag=0;
		 el1.res=1;
		 el1.exp=20;
		 
		 
		 return el1;
		 
		 
	 }
	 public static el el2(){
		 el el2=new el();
		 el2.name="enemy2";
		 el2.lvl=1;
		 el2.hp=70;
		 el2.hpmax=70;
		 el2.atk=21;
		 el2.def=1;
		 el2.mag=0;
		 el2.res=1;
		 el2.exp=20;
		
		 
		 return el2;
	 }

	}

