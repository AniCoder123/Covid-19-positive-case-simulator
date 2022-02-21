package projects.covidSimulator.simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import projects.covidSimulator.Display;
import projects.covidSimulator.Entity.Entity;
import projects.covidSimulator.Entity.Man;
import projects.covidSimulator.PeopleCollection.Colony;

public class Simulator implements Runnable{
	private Display display;
	private Graphics g,graph;
	private Thread thread;
    private boolean running;
    private BufferStrategy bs,bs2;
    private int width,height;
    private Entity man;
    private Colony c; 
  public Simulator(){
	  display = new Display("Covid","Graph");
	  width = display.getWidth();
	  height = display.getHeight();
  }
  public void init() {
	  this.man = new Man(50,50,width,height);
	  this.c = new Colony(width,height,1000);
  }
  public void tick() {
	  c.tick();
  }
  public void render() {
	  bs = display.getCanvas().getBufferStrategy();
	  bs2 = display.getGraphC().getBufferStrategy();
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		if(bs2 == null) {
			display.getGraphC().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0,0, width, height);
		graph = bs2.getDrawGraphics();
		//graph.clearRect(0,0, 600,600);
		//DRAW HERE
	
		c.render(g,graph);//,graph);
	   
		
		//END HERE
		bs.show();
		bs2.show();
		g.dispose();
		graph.dispose();
  }
  @Override
  public void run() {
	     init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		double now;
		double lastTime = System.nanoTime();
	    int i=0;
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			lastTime = now;
			if(delta>=1) {
			tick();
			render();
			delta --;
			}
			
		}
		stop();
	}

  public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
  }
 
  public synchronized void stop() {
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  }
}
