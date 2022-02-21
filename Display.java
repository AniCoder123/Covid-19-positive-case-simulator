package projects.covidSimulator;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Display {
	private int width = 800,height = 600;
	private String title,title1;
	private JFrame frame,graph;
	private Canvas canvas;
	private Canvas graphC;
  public Display(String title,String title1){
	  this.title = title;
	  this.title1 = title1;
	  showDisplay();
  }
  public void showDisplay() {
	  graph = new JFrame(title1);
	  graph.setSize(new Dimension(1200,600));
	  graph.setLocationRelativeTo(null);
	  graph.setResizable(false);
	  graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  graph.setVisible(true);
	  
	  graphC = new Canvas();
	  graphC.setPreferredSize(new Dimension(1200,600));
	  graphC.setMaximumSize(new Dimension(1200,600));
	  graphC.setMinimumSize(new Dimension(1200,600));
	  graphC.setFocusable(false);
	  
	  frame = new JFrame(title);
	  frame.setSize(new Dimension(width,height));
	  frame.setLocationRelativeTo(null);
	  frame.setResizable(false);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  
	  canvas = new Canvas();
	  canvas.setPreferredSize(new Dimension(width,height));
	  canvas.setMaximumSize(new Dimension(width,height));
	  canvas.setMinimumSize(new Dimension(width,height));
	  canvas.setFocusable(false);
	  
	  frame.add(canvas);
	  graph.add(graphC);
	  frame.pack();
	  graph.pack();
  }
  public int getWidth() {
	return width;
}
public Canvas getGraphC() {
	return graphC;
}
public void setGraphC(Canvas graphC) {
	this.graphC = graphC;
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
public Canvas getCanvas() {
	  return canvas;
  }
}
