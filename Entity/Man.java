package projects.covidSimulator.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import projects.covidSimulator.PeopleCollection.Colony;
import projects.covidSimulator.Utils.Util;

public class Man extends Entity{
	
	public Man(int x,int y,int width,int height) {
		super(x,y,width,height);
		Random r = new Random();
		//this.speed = 3;
		this.radius = 5;
		this.probOfCovid = 0.5;
		this.recoveryTime = 20;
		this.probOfDeath = 0.15;
		this.probOf2Covid = 0.025;
	}

	@Override
	public void tick() {
		Random r = new Random();
		boolean a  = false;
		switch(r.nextInt(4)) {
		case 0:if(x+speed>=width)x-=speed;else x+=speed;break;
		case 1:if(y+speed>=height)y-=speed;else y+=speed;break;
		case 2:if(x-speed<0)x+=speed;else x-=speed;break;
		case 3:if(y-speed<0)y+=speed;else y-=speed;break;
		}
		if(this.isInfected&&!this.isDead&&!this.isRecovered) {
			for(Entity m:Colony.collect) {
				if(Util.circle(x+radius,y+radius,
					m.getX()+radius,m.getY()+radius,radius,m.getRadius())&& !m.isDead && !m.isInfected) {
					if(m.isRecovered) {
					a = Util.findProb(probOf2Covid);
					}
					else {
					a = Util.findProb(probOfCovid);}
					
					m.setInfected(a);
					m.setRecovered(!a);
				}
			}
			count++;
			if(count==60*this.recoveryTime) {
				if(Util.findProb(1-this.probOfDeath)) {
					this.isRecovered = true;
					
			
					}
				else {
					this.isDead = true;
				
				
					}
				count = 0;}
		
			
		}
		/*else if(!this.isInfected&&!this.isDead&&this.isRecovered) {
			for(Entity m:Colony.collect) {
				if(Util.circle(x+radius,y+radius,
					m.getX()+radius,m.getY()+radius,radius,m.getRadius())) {
					m.setInfected(Util.findProb(probOfCovid));
				}
			}
			count++;
			if(count==60*this.recoveryTime) {
				if(Util.findProb(1-this.probOfDeath)) {
					this.isRecovered = true;
					this.isInfected = false;
			
					}
				else {
					this.isDead = true;
					this.isInfected = false;
				
					}
				count = 0;}
		}*/
	}

	@Override
	public void render(Graphics g) {
		boolean check = false;
		if(this.isRecovered) {
			g.setColor(Color.green);
		}
		else if(this.isDead) {
			g.setColor(Color.red);
			//check = true;
		}
		else if(this.isInfected) {
			g.setColor(Color.blue);
			
		}
		else {
			g.setColor(Color.orange);
		}
		if(!check)
		g.fillOval(x, y, radius*2, radius*2);
	}
}
		
