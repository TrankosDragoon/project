package RPG;

import java.util.ArrayList;
import java.util.Scanner;
import java.applet.*;
	import java.awt.*;
	import java.awt.event.*;
public class rpg {
	static int x = 15;// posicion f
	static int y = 0;// posicion c
	static Taulell t = new Taulell();
	static Finestra ventana = new Finestra(t);
	static int f = 16;
	static int c = 16;
	static int[][] MapaCaminar;
	static Scanner sc = new Scanner(System.in);
	static int memoria=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map1();
		
		System.out.println(pl.hp);
		while(sc.nextLine()!="q")movement();
		
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
private static void movement() {

		
		String opt = sc.nextLine();
		switch (opt) {
		case "w":
			if(MapaCaminar[x-1][y]==0 || MapaCaminar[x-1][y]==1) {
				MapaCaminar[x][y]=memoria;
				memoria = MapaCaminar [x-1][y];
				MapaCaminar [x-1][y]=4;
				x--;
			}
		case "s":
			if(MapaCaminar[x+1][y]==0 || MapaCaminar[x+1][y]==1) {
				MapaCaminar[x][y]=memoria;
				memoria = MapaCaminar [x+1][y];
				MapaCaminar [x+1][y]=4;
				
				x++;
			}
		case "a":
			if(MapaCaminar[x][y-1]==0 || MapaCaminar[x-1][y]==1) {
				MapaCaminar[x][y]=memoria;
				memoria = MapaCaminar [x][y-1];
				MapaCaminar [x][y-1]=4;
				
				y--;
			}
		case "d":
			if(MapaCaminar[x][y+1]==0 || MapaCaminar[x][y+1]==1) {
				MapaCaminar[x][y]=memoria;
				memoria = MapaCaminar [x][y+1];
				MapaCaminar [x][y+1]=4;
				
				y++;
			}	
		}
	}
	
}
