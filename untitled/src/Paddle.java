import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle implements KeyListener {

    int id;
    int yVelocity;
    int movement = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(-movement);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(movement);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(-movement);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(movement);
                    move();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }

    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }

    public void move(){
        y = y + yVelocity;
    }

    public void draw(Graphics g){
        if(id == 1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }
}
