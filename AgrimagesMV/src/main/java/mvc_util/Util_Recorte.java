/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import org.opencv.core.Point;
import org.opencv.core.Rect;

/**
 *
 * @author david
 */
public class Util_Recorte extends javax.swing.JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean irregular;
	private boolean regular;
    private List<Point> pontos;
    private Rect roi;
    
    private int maxX = 0;
    private int maxY = 0;

    public List<Point> getPontos() {
        return pontos;
    }

    public void removerpontos(){
        pontos.removeAll(pontos);
    }
    public boolean isIrregular() {
        return irregular;
    }

    public boolean isRegular() {
        return regular;
    }
    
    public void setIrregular(boolean irregular) {
        this.irregular = irregular;
        this.regular = !irregular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
        this.irregular = !regular;
    }
    
    public Rect getRoi() {
		return roi;
	}

	/**
     * Creates new form ImageEditor
     */
    public Util_Recorte() {
    	addMouseMotionListener(new MouseMotionAdapter() {
    		@Override
    		public void mouseMoved(MouseEvent arg0) {
    			formMouseMotion(arg0);
    		}
    	});
        pontos = new ArrayList<>();
        irregular = false;
        regular = false;
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.PINK);
        //g2d.setStroke(new BasicStroke(3));
        if(irregular){ 
	        int i = 0;
	        while (i < pontos.size()) {
	            Point p1 = pontos.get(i);
	            Point p2;
	            if (i + 1 < pontos.size()) {
	                p2 = pontos.get(i + 1);
	            } else {
	                p2 = pontos.get(0);
	            }
	            g2d.setPaint(Color.RED);
	            g2d.fillOval((int)p1.x-3, (int)p1.y-3, 6, 6);
	            g2d.setPaint(Color.PINK);
	            g2d.drawLine((int)p1.x,(int) p1.y,(int) p2.x,(int) p2.y);
	            i++;
	        }
        }
        if(regular){
        	int sizeL = pontos.size();
        	if(sizeL > 0){
        		if(sizeL == 1){
        			double x,y,width,height;
        			if(maxX < pontos.get(0).x){
        				x = maxX;
        				width = pontos.get(0).x - maxX;
        			}else{
        				x = pontos.get(0).x;
        				width = maxX - pontos.get(0).x;
        			}
        			if(maxY < pontos.get(0).y){
        				y = maxY;
        				height = pontos.get(0).y - maxY;
        			}else{
        				y = pontos.get(0).y;
        				height = maxY - pontos.get(0).y;
        			}
        			g2d.setPaint(Color.RED);
    	            g2d.fillOval((int)x-3, (int)y-3, 6, 6);
    	            g2d.fillOval((int)x+(int)width-3, (int)y-3, 6, 6);
    	            g2d.fillOval((int)x-3, (int)(y+height-3), 6, 6);
    	            g2d.fillOval((int)(x+width-3), (int)(y+height-3), 6, 6);
    	            g2d.setPaint(Color.PINK);
        			g2d.drawRect((int)x, (int)y, (int)width, (int)height);
        		}
        		if(sizeL == 2){
        			double x,y,width,height;
        			if(pontos.get(1).x < pontos.get(0).x){
        				x = pontos.get(1).x;
        				width = pontos.get(0).x - pontos.get(1).x;
        			}else{
        				x = pontos.get(0).x;
        				width = pontos.get(1).x - pontos.get(0).x;
        			}
        			if(pontos.get(1).y < pontos.get(0).y){
        				y = pontos.get(1).y;
        				height = pontos.get(0).y - pontos.get(1).y;
        			}else{
        				y = pontos.get(0).y;
        				height = pontos.get(1).y - pontos.get(0).y;
        			}
        			g2d.setPaint(Color.RED);
    	            g2d.fillOval((int)x-3, (int)y-3, 6, 6);
    	            g2d.fillOval((int)(x+width-3), (int)(y-3), 6, 6);
    	            g2d.fillOval((int)(x-3), (int)(y+height-3), 6, 6);
    	            g2d.fillOval((int)(x+width-3), (int)(y+height-3), 6, 6);
    	            g2d.setPaint(Color.PINK);
        			g2d.drawRect((int)x, (int)y, (int)width, (int)height);
        			if(roi == null){
        				roi = new Rect((int)x, (int)y, (int)width, (int)height);
        			}
        		}
        	}
        }
        repaint();
        revalidate();
        g.dispose();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(isIrregular()){
        	Point p = new Point(evt.getPoint().x,evt.getPoint().y);
            pontos.add(p);
        }
        if(isRegular()){
        	if(pontos.size()<2){
        		Point p = new Point(evt.getPoint().x,evt.getPoint().y);
                pontos.add(p);
        	}
        }
    }
    
    private void formMouseMotion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        if(isRegular()){
        	if(pontos.size() == 1){
        		maxX = evt.getX();
        		maxY = evt.getY();
        	}
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
