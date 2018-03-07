package reassessment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI implements ActionListener{
	
	//create menu
	JFrame frame;
	JMenuBar menuBar;
	JMenu fileMenu, fileSpace, fileHelp,fileSize;
	JMenuItem newMenuLoad,newMenuSave,newMenuExit,newMenuAbout,newMenuWidth,newMenuHeight;
	
	//create JPanels
	GraphicsPanel gp= new GraphicsPanel();
	JPanel tp=new JPanel(); 
	
	//create component
	JTextArea textarea;
	JButton button;
	FileDialog fd;
	File file;
	int width=1200,height=800;
	
	public void CreateandShowGUI(){
		//create frame
		frame = new JFrame("Draw image");
		
		//Component of TextPanel
		button=new JButton("Draw");
		textarea= new JTextArea(45,25);
		tp.add(textarea);
		button.setPreferredSize(new Dimension(80,100)); 
		button.addActionListener(new ButtonListener());
		tp.add(button);
		
		//Layout manage GraphicsPanel and TextPanel
		frame.add(gp,BorderLayout.WEST);
		frame.add(tp,BorderLayout.EAST);
		
		//create menu bar
		menuBar = new JMenuBar();	
		
		//File Menu in the menu bar
		fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("sans-serif", Font.PLAIN, 20));
		menuBar.add(fileMenu);

		fileSpace = new JMenu("   ");
		menuBar.add(fileSpace);
		
		fileSize = new JMenu("Size");
		fileSize.setFont(new Font("sans-serif", Font.PLAIN, 20));
		menuBar.add(fileSize);
		
		fileSpace = new JMenu("   ");
		menuBar.add(fileSpace);
		
		fileHelp = new JMenu("Help");
		fileHelp.setFont(new Font("sans-serif", Font.PLAIN, 20));
		menuBar.add(fileHelp);
		
		
		//files inside the menu bar(File ->...) 
		newMenuLoad = new JMenuItem("Load",new ImageIcon("Icon/load.png"));
		newMenuLoad.setFont(new Font("sans-serif", Font.PLAIN, 20));
		fileMenu.add(newMenuLoad);
		newMenuLoad.addActionListener(this);
		
		newMenuSave = new JMenuItem("Save",new ImageIcon("Icon/Save.png"));
		newMenuSave.setFont(new Font("sans-serif", Font.PLAIN, 20));
		fileMenu.add(newMenuSave);
		newMenuSave.addActionListener(this);
		
		newMenuExit = new JMenuItem("Exit",new ImageIcon("Icon/Exit.png"));
		newMenuExit.setFont(new Font("sans-serif", Font.PLAIN, 20));
		fileMenu.add(newMenuExit);
		newMenuExit.addActionListener(this);
		
		//files inside the menu bar(About ->...) 
		newMenuAbout = new JMenuItem("About",new ImageIcon("Icon/Help.png"));
		newMenuAbout.setFont(new Font("sans-serif", Font.PLAIN, 20));
		fileHelp.add(newMenuAbout);
		newMenuAbout.addActionListener(this);
		
		//files inside the menu bar(Resize ->...) 
		newMenuWidth = new JMenuItem("Resize",new ImageIcon("Icon/Size.png"));
		newMenuWidth.setFont(new Font("sans-serif", Font.PLAIN, 20));
		fileSize.add(newMenuWidth);
		newMenuWidth.addActionListener(this);
		
		frame.pack();
		//Display frame in the center of window
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(menuBar);
		frame.setSize(width, height);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}

	//Display frame
	public static void main(String[] args){
		 GUI part1= new GUI();
		 part1.CreateandShowGUI();
		 
	}
	//identity ImageIcon correct or not
    protected ImageIcon createImageIcon(String path,
            String description) {
    	//load ImageIcon
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	//When click JMenuItem from JMenuBar
	public void actionPerformed (ActionEvent e){
		JMenuItem source = (JMenuItem) (e.getSource());
		// When click "Save"
		if (source.getText().equals("Save")){
			fd = new FileDialog(frame,"Save",FileDialog.SAVE);
            fd.setVisible(true); 
			 try {
				 if ((fd.getDirectory()!=null) && (fd.getFile()!=null)){
				file = new File(fd.getDirectory(),fd.getFile());
				
				ImageIO.write(GraphicsPanel.image, "jpeg", file);}
			} catch (IOException e1) {
				System.out.println(e1);
			}
			
		}
		// When click "Load"
		else if (source.getText().equals("Load")){
			fd = new FileDialog(frame,"Open",FileDialog.LOAD);
            fd.setVisible(true);   //create and display filedialog.
            try {   
            	if ((fd.getDirectory()!=null) && (fd.getFile()!=null)){
            	//get the path and file name.
            	file = new File(fd.getDirectory(),fd.getFile());
            	
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String aline;
                //load file data to textarea
                while ((aline=br.readLine()) != null){
                textarea.append(aline+"\n");
                //button will click automatically when file loaded.
                button.doClick(); 
                }
                fr.close();
                br.close();}
                
              }
            catch (IOException ioe){
                
                System.out.println(ioe);
              }	
	
			
		}
		//When click "Exit"
		else if (source.getText().equals("Exit")){	
			frame.dispose();	
		}
		//When click "Resize"
		else if (source.getText().equals("Resize")){
			JTextField tf1 = new JTextField();
			JTextField tf2 = new JTextField();
			//content in Optionpanel
			 Object[] inputFields = {"Width:", tf1,"Height:",tf2};
			 //create an optionpanel
			 int option = JOptionPane.showConfirmDialog(null, inputFields, "Enter WIDTH and HEIGHT!", JOptionPane.OK_CANCEL_OPTION);
			 //load input in optionpanel if click "OK".
			 if (option == JOptionPane.OK_OPTION)
			 {
				 String value1= tf1.getText();
				 width = Integer.parseInt(value1);
				 String value2= tf2.getText();
				 height = Integer.parseInt(value2);
				 frame.setSize(width,height);
			 }
		}
		//When click "About"
		else if (source.getText().equals("About")){
			//create an optionpanel.
			JOptionPane.showMessageDialog(newMenuAbout, "Welcome to Reggie's draw panel!"+"\n"+"                        :)");
			
		}
	
	}
	//Transfer data of lines to class "Draw".
	public ArrayList<Draw> commend(String string){
		ArrayList<Draw> drawshape = new ArrayList<>();
		String line[] = string.split("\\n");
		int x=0,y=0,red=255,green=255,blue=255;
		Color color;
		//make Array "line" to String and loop it.
		for (String lines: line){
			Draw draw = new Draw();
			String s[] = lines.split(" "); 
			String Shape = String.valueOf(s[0]);
			//prevent data error. For type, number of parameters.Such as line 200 eqe and line 400.
			try{
				//check the type of commend.
				if (Shape.trim().equalsIgnoreCase("Move")){
					//prevent data is negative number and suitable number of parameters. Such as line -200 400 and line 400 200 300.
					if(Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && s.length==3){
						x=Integer.valueOf(s[1]);
						y=Integer.valueOf(s[2]);
					}else{
						//if error happened then output word behind commend.
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Colour")){
					if(Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && Integer.valueOf(s[3])>=0 && s.length==4){
						red=Integer.valueOf(s[1]);
						green=Integer.valueOf(s[2]);
						blue=Integer.valueOf(s[3]);
						color = new Color(red,green,blue);
						draw.setColor(color);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Line")){
					if (Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && s.length==3){
						draw.setLineX(Integer.valueOf(s[1]));
						draw.setLineY(Integer.valueOf(s[2]));
						draw.setMoveX(x);
						draw.setMoveY(y);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Circle")){
					if(Integer.valueOf(s[1])>=0 && s.length==2){
						draw.setMoveX(x);
						draw.setMoveY(y);
						draw.setR(Integer.valueOf(s[1]));
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Solid_Circle")){
					if(Integer.valueOf(s[1])>=0 && s.length==2){
						draw.setMoveX(x);
						draw.setMoveY(y);
						draw.setSolidR(Integer.valueOf(s[1]));
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Oval")){
					if (Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && s.length==3){
						draw.setOvalX(Integer.valueOf(s[1]));
						draw.setOvalY(Integer.valueOf(s[2]));
						draw.setMoveX(x);
						draw.setMoveY(y);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Solid_Oval")){
					if (Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && s.length==3){
						draw.setSolid_OvalX(Integer.valueOf(s[1]));
						draw.setSolid_OvalY(Integer.valueOf(s[2]));
						draw.setMoveX(x);
						draw.setMoveY(y);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Rectangle")){
					if(Integer.valueOf(s[1])>=0 && Integer.valueOf(s[2])>=0 && s.length==3){
						draw.setRectX(Integer.valueOf(s[1]));
						draw.setRectY(Integer.valueOf(s[2]));
						draw.setMoveX(x);
						draw.setMoveY(y);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}
				else if (Shape.trim().equalsIgnoreCase("Text")){
					if(s.length>1){
						String text = "";
						for(int i=1;i<s.length;i++){
							text = text + s[i] + " ";
						}
						draw.setText(text);
						draw.setMoveX(x);
						draw.setMoveY(y);
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}else if ((Shape.trim().equalsIgnoreCase("Clear"))){
					if(s.length==1){
						draw.setClear(Shape);
						x=0;y=0;
						color = Color.white;
						drawshape.add(draw);
					}else{
						textarea.append(" Commend is not correct!");
					}
				}else if ((Shape.equals(""))){
					
				}else{
					textarea.append(" Commend is not correct!");
				}
			}catch(Exception e){
				textarea.append(" Commend is not correct!");
			}
		}
		//get a new value.
		return drawshape;
	}
	public class ButtonListener implements ActionListener{
		
		public void actionPerformed (ActionEvent actionEvent){
				String content= textarea.getText();
				gp.DrawShape(commend(content));
				gp.repaint();
			
			
		}

	}
	
} 	




