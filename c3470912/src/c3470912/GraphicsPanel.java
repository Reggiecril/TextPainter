package reassessment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
		
		
		private static final long serialVersionUID = 1L;
		private ArrayList<Draw> drawshape = null;
		public static BufferedImage image;
		private Color color = Color.black;
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    //if not data transfered.
		    if (drawshape == null) {
	            return;
	        }
	    	Graphics g1 =  image.createGraphics();
		    //loop every lines in textarea.
		    for (Draw draw:drawshape){
		    	//make all shape display in the bufferedimage
		    	g1.setColor(draw.getColor());
		    	if (draw.getClear()!=null){
		    		g1.setColor(color);
		    		g1.clearRect(0, 0, image.getWidth(), image.getHeight());
		    	}
		    	//prevent input value of move when line is null.
		    	if (draw.getLineX()!=0 || draw.getLineY()!=0){
		    		g1.drawLine(draw.getLineX(), draw.getLineY(), draw.getMoveX(), draw.getMoveY());
		    	}
		    	if (draw.getR()!=0){
		    		g1.drawOval(draw.getMoveX(),draw.getMoveY(),draw.getR(),draw.getR());
		    	}
		    	if (draw.getSolidR()!=0){
		    		g1.fillOval(draw.getMoveX(),draw.getMoveY(),draw.getSolidR(),draw.getSolidR());
		    	}
		    	if (draw.getRectX()!=0 || draw.getRectY()!=0){
		    		g1.drawRect(draw.getMoveX(),draw.getMoveY(),draw.getRectX(), draw.getRectY());
		    	}
		    	if (draw.getOvalX()!=0 || draw.getOvalY()!=0){
		    		g1.drawOval(draw.getMoveX(),draw.getMoveY(),draw.getOvalX(), draw.getOvalY());
		    	}
		    	if (draw.getSolid_OvalX()!=0 || draw.getSolid_OvalY()!=0){
		    		g1.fillOval(draw.getMoveX(),draw.getMoveY(),draw.getSolid_OvalX(), draw.getSolid_OvalY());
		    	}
		    	if (draw.getText() != null){
		    		g1.drawString(draw.getText(),draw.getMoveX(),draw.getMoveY());
		    	}
		    }
		    //Set all image from g1 to "image", then draw it.
		    g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null);
		}
		
		//Get commend from "Draw".
		public void DrawShape(ArrayList<Draw> drawshape){
			this.drawshape = drawshape;
		}
		
		
		GraphicsPanel() {
			//Set size of GraphcisPanel in frame.
		    setPreferredSize(new Dimension(800,800));
		    //Create size of image in GraphicsPanel.
			image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
			// Set max size of the panel, so that is matches the max size of the image.
			setMaximumSize(new Dimension(image.getWidth(), image.getHeight()));
			//Set background color same as image's color.
			setBackground(color);
			
		  }
		
	 }

	



	