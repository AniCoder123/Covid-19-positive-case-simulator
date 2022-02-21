package projects.covidSimulator.Utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Util {
	public static ArrayList<Integer> graphX = new ArrayList<Integer>(0);
	public static ArrayList <Integer>graphY = new ArrayList<Integer>(0);
	 public static boolean circle(int x1, int y1, int x2,
             int y2, int r1, int r2)
    {
       int distSq = (x1 - x2) * (x1 - x2) +
            (y1 - y2) * (y1 - y2);
       int radSumSq = (r1 + r2) * (r1 + r2);
       if (distSq == radSumSq)
    	   return true;
    	else if (distSq > radSumSq)
    	   return false;
    	else
    	   return true;
    	}
	 public static boolean findProb(double prob) {
		 Random rand = new Random();
		 if(rand.nextDouble()<=prob)
			 return true;
		 else
			 return false;
	 }
	 private static void printLines(int n) {
		 for(int i=0;i<n;i++) {
			 System.out.println();
		 }
	 }
	
	 public static void  drawGraph(int pointX,int pointY,
			 int width,int height,Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
		 g2d.setColor(Color.blue);
		 graphX.add(pointX);
		 graphY.add(pointY);
		 int[] arrX = new int[graphX.size()];
		 int[] arrY = new int[graphX.size()];
		 
	    for(int i=0;i<graphX.size();i++) {
			 arrX[i] = graphX.get(i);
			 arrY[i] =(int) height-graphY.get(i)/10;
			
		 }
       g.drawPolyline(arrX, arrY, graphX.size());
		 
	 }
}
