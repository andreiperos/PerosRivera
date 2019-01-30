import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Drawing extends JComponent{
	
	public int x = 200;
	public int y = 420;
	
	
	public int state = 0;

	public BufferedImage image;
	public URL resource = getClass().getResource("run0.png");
	
	public BufferedImage crouch;
	public URL crch = getClass().getResource("crouch0.png");
	
	public BufferedImage bground;
	public URL bg = getClass().getResource("bground.png");

	public BufferedImage imageL;
	public URL lefty = getClass().getResource("RunLeft0.png");


	public Drawing(){
		try{
			image = ImageIO.read(resource);
			bground = ImageIO.read(bg);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		
		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		state++;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void runLeft(){
		
		if(state == 0){
			resource = getClass().getResource("RunLeft0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("RunLeft1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("RunLeft2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("RunLeft3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("RunLeft4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("RunLeft5.png");
			state = 0;
		}
		
		state++;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){  
                for(int astate = 0;astate<4;astate++){
                   
                    if(astate==5){
                        resource = getClass().getResource("crouch3.png");

                    }
                    else{
                        resource = getClass().getResource("crouch"+astate+".png");
                    }
                    try{
                        image = ImageIO.read(resource);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    repaint();    
                    try{
                        Thread.sleep(100);    
                    }
                    catch(InterruptedException e){

                    }
                }
            }
        });
        thread1.start();
    }

	public void moveUp(){
		reloadImage();
		repaint();
	}
	public void moveDown(){
		attackAnimation();
		repaint();
	}
	public void moveLeft(){
		if(x<=-10){
			x=x;
		}
		else{
			x=x -25;
			runLeft();
			repaint();
		}
	}
	public void moveRight(){
		if(x>=1120){
			x=x;
		}
		else{
			x=x +25;
			reloadImage();
			repaint();
		}
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bground,0,0,1366,720,this);
		g.drawImage(image,x,y,250,220,this);
		g.drawImage(imageL,x,y,this);
		g.drawImage(crouch,x,y,250,220,this);
	}
}