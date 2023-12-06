package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject implements KeyListener{
	
	public Type_B_GameObject(int x, int y) {
		super(x, y);
		ID = 3;
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
		
	}
	
	public void move(Canvas c) {	
	}
	
	//SPECIFY THE IMAGE TO DISPLAY
    //	USED FOR ANIMATION
    public void setImage() {
    	switch (getDirection()) {
    	case Direction.NONE:
    		break;
    	case Direction.UP:
    		currentImage = 0;
    		break;
    	case Direction.DOWN:
    		currentImage = 1;
    		break;
    	case Direction.LEFT:
    		currentImage = 3;
    		break;
    	case Direction.RIGHT:
    		currentImage = 2;
    		break;
    		
    	}
    }
    
    public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB && isFocus == true) {
			setDirection(Direction.NONE);
		}
		if (e.getKeyCode() == KeyEvent.VK_TAB && isFocus == true) {
			if (getCurrentImage() == imageList.get(0)) {
				setDirection(Direction.UP);
			}
			else if (getCurrentImage() == imageList.get(1)){
				setDirection(Direction.DOWN);
			}
			else if (getCurrentImage() == imageList.get(2)) {
				setDirection(Direction.LEFT);
			}
			else {
				setDirection(Direction.RIGHT);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if(isFocus == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}
	
	

}
