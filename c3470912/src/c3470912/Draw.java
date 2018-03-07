package reassessment;

import java.awt.Color;

public class Draw {
	private int Linex=0,Liney=0,Movex=0,Movey=0,R=0,SolidR=0,Rectx=0,Recty=0,Ovalx=0,Ovaly=0,Solid_Ovalx=0,Solid_Ovaly=0;
	private String Text=null,Clear=null;
	private Color color;
	//return the value from setLineX.GraphicsPanel get the value to draw.
	public int getLineX(){
		return Linex;
	}
	//get the Linex from GUI.java.
	public void setLineX(int Linex){
		this.Linex = Linex;
	}
	public int getLineY(){
		return Liney;
	}
	public void setLineY(int Liney){
		this.Liney = Liney;
	}
	public int getMoveX(){
		return Movex;
	}
	public void setMoveX(int Movex){
		this.Movex = Movex;
	}
	public int getMoveY(){
		return Movey;
	}
	public void setMoveY(int Movey){
		this.Movey = Movey;
	}
	public int getR(){
		return R;
	}
	public void setR(int R){
		this.R = R;
	}
	public int getSolidR(){
		return SolidR;
	}
	public void setSolidR(int SolidR){
		this.SolidR = SolidR;
	}
	public int getRectX(){
		return Rectx;
	}
	public void setRectX(int Rectx){
		this.Rectx = Rectx;
	}
	public int getRectY(){
		return Recty;
	}
	public void setRectY(int Recty){
		this.Recty = Recty;
	}

	public String getText(){
		return Text;
	}
	public void setText(String Text){
		this.Text = Text;
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public String getClear(){
		return Clear;
	}
	public void setClear(String Clear){
		this.Clear = Clear;
	}
	public int getOvalX(){
		return Ovalx;
	}
	public void setOvalX(int Ovalx){
		this.Ovalx = Ovalx;
	}
	public int getOvalY(){
		return Ovaly;
	}
	public void setOvalY(int Ovaly){
		this.Ovaly = Ovaly;
	}
	public int getSolid_OvalX(){
		return Solid_Ovalx;
	}
	public void setSolid_OvalX(int Solid_Ovalx){
		this.Solid_Ovalx = Solid_Ovalx;
	}
	public int getSolid_OvalY(){
		return Solid_Ovaly;
	}
	public void setSolid_OvalY(int Solid_Ovaly){
		this.Solid_Ovaly = Solid_Ovaly;
	}
	
}
