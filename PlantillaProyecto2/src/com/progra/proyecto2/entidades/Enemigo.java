package com.progra.proyecto2.entidades;

import java.util.Vector;

import java.util.Random;

public class Enemigo extends Tanque implements Runnable{
	int bulletTimeInterval;
	Vector<Enemigo> enemies = new Vector<Enemigo>();
	private Vector<Bala> enemyBullets = new Vector<Bala>();
	int select;
	String[] direccionSet = {"Norte","Oeste","Sur","Este"};
	Random random = new Random();
	//constructor
	public Enemigo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			
			
			//aleatorio para seleccionar direccion del tanque
			select = random.nextInt(direccionSet.length);
			this.direccion = direccionSet[select];
			//if the enemy tanks are destroyed then get out the thread
			if(this.getIsLive() == false){
				break;
			}
		}
	}
	
}
