package projects.covidSimulator.PeopleCollection;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import projects.covidSimulator.Entity.Entity;
import projects.covidSimulator.Entity.Man;
import projects.covidSimulator.Utils.Util;

public class Colony {
	public static Entity[] collect;
	private int frames = 0,frame2,graphX = 5;;
	public static int countOfDead = 0;
	private int width,height,length,frames2 = 0;
	public Colony(int width,int height,int length) {
		collect = new Man[length];
		this.height = height;
		this.width = width;
		this.length = length;
		setColony();
	}
   public void setColony() {
	   Random rand = new Random();
	   for(int i=0;i<length;i++) {
		   if(i==length/2) {
			   collect[i] = new Man(width/2,height/2,width,height);
			   collect[i].setInfected(true);
			   collect[i].setSpeed(3);}
			   else {
		   collect[i] = new Man(rand.nextInt(width),rand.nextInt(height),width,height);
		   collect[i].setSpeed(3);
		   }
	   }
   }
   public void tick() {
	   for(int i=0;i<length;i++) {
		   collect[i].tick();
		   if(collect[i].isInfected()&&!collect[i].lock) {
			   Colony.countOfDead++;
			   collect[i].lock = true;
		   }
		   if(collect[i].isDead()||collect[i].isRecovered()
				   &&collect[i].lock) {
			   Colony.countOfDead--;
			   collect[i].lock = false;
		   }
	   }
   }
   public void render(Graphics g,Graphics g2) {
	   Util.drawGraph(frames2, countOfDead, width, height, g2);
	
	   for(int i=0;i<length;i++) {
		   collect[i].render(g);
	   }
	   if(frames == 60) {
		   frames2++;
		   frames = 0;}
	   frames++;
   }
}
