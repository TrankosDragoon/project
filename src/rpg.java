
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class rpg {
	static int x = 14;// posicion f
	static int y = 0;// posicion c
	static Taulell t = new Taulell();
	static Finestra ventana = new Finestra(t);
	static int f = 16;
	static int c = 16;
	static int[][] MapaCaminar;
	static int[][] MapaCombate;
	static Scanner sc = new Scanner(System.in);
	static int memoria = 1;
	static pl pl1 = pl.pl1();
	static pl pl2 = pl.pl2();
	static ArrayList<pl> play = new ArrayList<>();
	static ArrayList<el> ell = new ArrayList<>();
	static ArrayList<magic> Magic = new ArrayList<>();
	static int Random;
	static boolean win;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Map1();

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				doStuff();
			}
		}, 0, 500);

	}

	public static void doStuff() {

		movement();
		t.dibuixa(MapaCaminar);
	}

	private static void Map1() {
		t.setActimatges(true);
		String[] imatges = { "hierba.png", "camino.png", "arbol.png", "Rock.png", "", "cofre.png" };
		t.setImatges(imatges);

		int[][] MapaInit = { // 0= hierba,1=camino,2=arbol,3=roca,4=posicion
								// inicial,5= cofre

				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 2, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 2, 3, 3, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 2, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 2, 0, 0 },
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 2, 0, 0 }, { 0, 3, 0, 0, 0, 0, 1, 0, 0, 3, 3, 0, 2, 2, 0, 0 },
				{ 3, 0, 0, 0, 0, 1, 1, 0, 2, 2, 2, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 0, 0, 0, 2, 2, 0, 3, 3, 0, 0 },
				{ 4, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0, 5, 0, 3, 0, 0 },
				{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, };
		MapaCaminar = MapaInit;
		t.dibuixa(MapaCaminar);
	}

	private static void init() {

		play.add(pl.pl1());

		play.add(pl.pl2());

	}

	private static void combat() {
		// TODO Auto-generated method stub

		// new Sonido().start();
		t.setActimgbackground(true);
		t.setImgbackground("ffcombatforest.png");
		String[] imatges = { "", "Iron_Sword.png", "Iron_Axe.png", "Rock.png", "", "cofre.png" };
		t.setImatges(imatges);
		int CombatMap[][] = { { 0, 0, 0, 0, 0 }, { 0, 3, 0, 1, 0 }, { 0, 5, 0, 2, 0 }, { 0, 0, 0, 0, 0 } };
		MapaCombate = CombatMap;
		t.dibuixa(MapaCombate);

		boolean turno = true;// flag to check player's or enemie's turn

		boolean gameover = false;
		int turn = (int) (Math.random() * 2);

		while (win != true && gameover != true) {

			if (turn == 0) {
				turno = true;
			} else
				turno = false;

			while (win != true && gameover != true) {// TODO condition of
				// /Gameover/win

				if (turno == true) {// player's turn

					for (int j = 0; j < play.size(); j++) {
						combmenu(play.get(j));
					}
					turno = !turno;
					continue;

				} else {
					// enemie's turn
					for (int i = 0; i < ell.size(); i++) {
						int select2 = (int) (Math.random() * 2);
						System.out.println(select2);
						System.out.println((play.get(select2)).name);
						System.out.println("HP of player" + play.get(select2).name + " : " + play.get(select2).hp);
						int newhp = damagedone(ell.get(i).atk, play.get(select2).def, play.get(select2).hp);

						play.get(select2).hp = newhp;

						System.out.println("HP of player" + play.get(select2).name + " : " + play.get(select2).hp);
						if (play.get(select2).hp <= 0) {
							System.out.println(play.get(select2).name + "  ha muerto");
							play.remove(select2);
							if (play.isEmpty()) {
								gameover = true;
								System.out.println("GAMEOVER");
								break;
							}
						}
					}
					turno = !turno;
				}

			}

			// volver a config de imagenes de mapa.
			t.setActimgbackground(false);
			t.dibuixa(MapaCaminar);
			doStuff();

		}
	}

	private static int damagedone(int atk1, Integer def, Integer hp) {
		System.out.println("ha recibido " + (atk1 - def) + " puntos de daño");
		hp = hp - (atk1 - def);

		return hp;
	}

	private static int atkmod1(int j, int b) {// weapon1 ATK modifier player1
		// attributes
		int atkwp1 = 20;
		int atkmod1 = play.get(j).atk + atkwp1;
		return atkmod1;
	}

	private static int atkmod2(int a, int b) {// weapon2 ATK modifier player2
		int atkwp2 = 15;
		int atkmod2 = play.get(1).atk + atkwp2;
		return atkmod2;
	}

	private static int magmod(int j, int b) {// weapon1 MAG modifier player1
		int magwp1 = 13;
		int magmod1 = play.get(0).mag + magwp1;
		return magmod1;
	}

	private static int magmod2(int a, int b) {// weapon2 MAG modifier player2
		int magwp2 = 20;
		int magmod2 = play.get(1).mag + magwp2;
		return magmod2;
	}

	private static int defmod1(int a, int b) {// armor1 DEF modifier player1
		int defarm1 = 20;
		int defmod1 = play.get(0).def + defarm1;
		return defmod1;
	}

	private static int resmod1(int a, int b) {// armor1 RES modifier player1
		int resarm1 = 15;
		int resmod1 = play.get(0).res + resarm1;
		return resmod1;
	}

	private static int defmod2(int a, int b) {// armor2 DEF modifier player2
		int defarm2 = 14;
		int defmod2 = play.get(1).def + defarm2;
		return defmod2;
	}

	private static int resmod2(int a, int b) {// armor1 RES modifier player2
		int resarm2 = 16;
		int resmod2 = play.get(1).res + resarm2;
		return resmod2;
	}

	private static void generaterandomenemies() {

		int nenemies = 1 + (int) (Math.random() * 2);
		for (int i = 0; i < nenemies; i++) {
			int tenemy = 1 + (int) (Math.random() * 2);
			switch (tenemy) {
			case 1:
				ell.add(el.el1());
				break;
			case 2:
				ell.add(el.el2());
				break;

			}
		}

	}

	private static void movement() {

		char opt = ventana.getActualChar();
		switch (opt) {
		case 'w':
			if (MapaCaminar[x - 1][y] == 0 || MapaCaminar[x - 1][y] == 1) {
				MapaCaminar[x][y] = memoria;
				memoria = MapaCaminar[x - 1][y];
				MapaCaminar[x - 1][y] = 4;
				x--;
			}
			Random();
			if (Random == 4 || Random == 8) {
				generaterandomenemies();
				combat();
			}
			break;
		case 's':
			if (MapaCaminar[x + 1][y] == 0 || MapaCaminar[x + 1][y] == 1) {
				MapaCaminar[x][y] = memoria;
				memoria = MapaCaminar[x + 1][y];
				MapaCaminar[x + 1][y] = 4;

				x++;
			}
			Random();
			if (Random == 4 || Random == 8) {
				generaterandomenemies();
				combat();
			}
			break;
		case 'a':
			if (MapaCaminar[x][y - 1] == 0 || MapaCaminar[x - 1][y] == 1) {
				MapaCaminar[x][y] = memoria;
				memoria = MapaCaminar[x][y - 1];
				MapaCaminar[x][y - 1] = 4;

				y--;
			}
			Random();
			if (Random == 4 || Random == 8) {
				generaterandomenemies();
				combat();
			}
			break;
		case 'd':
			if (MapaCaminar[x][y + 1] == 0 || MapaCaminar[x][y + 1] == 1) {
				MapaCaminar[x][y] = memoria;
				memoria = MapaCaminar[x][y + 1];
				MapaCaminar[x][y + 1] = 4;

				y++;
			}
			Random();
			if (Random == 4 || Random == 8) {
				generaterandomenemies();
				combat();
			}
			break;
		}
	}

	private static void Random() {
		// TODO Auto-generated method stub
		Random = (int) (Math.random() * 21);

	}

	private static void combmenu(pl player) {// combat menu
		ventana.getActualChar();
		System.out.println("1.Atacar ,2.Magia ,3.Objetos(pls no le des al 3),4.Huir");
		char opt = 0;
		while ((opt = ventana.getActualChar()) == 0) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		switch (opt) {

		case '1':
			atacar(player);
			break;
		case '2':
			magia(player);
			break;
		case '3':
			objetos(player);
			break;
		case '4':
			Huir(player);
			break;
		default:
			combmenu(player);

		}
		if (ell.isEmpty()) {
			win = true;
		}

	}

	private static void objetos(pl player) {
		// TODO Auto-generated method stub

	}

	private static void magia(pl player) {

		for (int i = 0; i < player.magias.size(); i++) {
			int mag1 = magmod2(0, 0);
			System.out.println(i + player.magias.get(i).name);
		}

		char m;
		
		while ((m = ventana.getActualChar()) == 0) {

		}

		int opmagia = Character.getNumericValue(m);
		
		magic magiasel = player.magias.get(opmagia);

		if (m == 9) {
			System.out.println("que enemigo quieres coger");

			for (int j = 0; j < ell.size(); j++) {
				System.out.println(j + ell.get(j).name);

			}
			int select = sc.nextInt();
			if (select > ell.size()) {
				atacar(player);
			} else {

				System.out.println("HP of monster" + ell.get(select).name + " : " + ell.get(select).hp);
				int newhp = damagedone(magmod(0,0), ell.get(select).res, ell.get(select).hp);
				ell.get(select).hp = newhp;
				System.out.println("HP of monster" + ell.get(select).name + " : " + ell.get(select).hp);
				if (ell.get(select).hp <= 0) {
					ell.remove(select);
					if (ell.isEmpty()) {
						win = true;
						System.out.println("you win");

					}
				}

			}
			
		} else
			for (int j = 0; j < play.size(); j++) {
				System.out.println(j + play.get(j).name);
			}
	}

	private static void atacar(pl player) {
		System.out.println("atacar");
		// TODO Auto-generated method stub
		win = false;
		for (int j = 0; j < play.size(); j++) {
			System.out.println(play.size());
			int atk1 = atkmod1(0, 0);

			System.out.println("que enemigo quieres coger");
			for (int i = 0; i < ell.size(); i++) {
				System.out.println(i + ": monster" + ell.get(i).name);
			}
			int select = sc.nextInt();
			if (select > ell.size()) {
				atacar(player);
			} else {

				System.out.println("HP of monster" + ell.get(select).name + " : " + ell.get(select).hp);
				int newhp = damagedone(atk1, ell.get(select).def, ell.get(select).hp);
				ell.get(select).hp = newhp;
				System.out.println("HP of monster" + ell.get(select).name + " : " + ell.get(select).hp);
				if (ell.get(select).hp <= 0) {
					ell.remove(select);
					if (ell.isEmpty()) {
						win = true;
						System.out.println("you win");

					}
				}

			}

		}

	}

	private static void Huir(pl player) {

		if ((Math.random() * 100 < 50)) {
			System.out.println("No has logrado escapar");
			win = false;
			combmenu(player);

		} else {
			System.out.println("Escapaste!");
			win = true;

		}
	}
}
