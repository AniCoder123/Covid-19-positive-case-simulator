package projects.covidSimulator.Entity;

import java.awt.Graphics;

public abstract class Entity{
	protected int x,y,speed,count = 0;
	protected int width,height;
	protected boolean isVaccinated;
	protected double recoveryTime,probOfCovid,probOf2Covid,probOfDeath;
	protected boolean isRecovered;
	protected boolean isDead,isInfected;
	protected int radius;
	public boolean lock;

	public Entity(int x,int y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public boolean isInfected() {
		return isInfected;
	}
	public void setInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isVaccinated() {
		return isVaccinated;
	}
	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}
	public double getRecoveryTime() {
		return recoveryTime;
	}
	public void setRecoveryTime(double recoveryTime) {
		this.recoveryTime = recoveryTime;
	}
	public double getProbOfCovid() {
		return probOfCovid;
	}
	public void setProbOfCovid(double probOfCovid) {
		this.probOfCovid = probOfCovid;
	}
	public boolean isRecovered() {
		return isRecovered;
	}
	public void setRecovered(boolean isRecovered) {
		this.isRecovered = isRecovered;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
}