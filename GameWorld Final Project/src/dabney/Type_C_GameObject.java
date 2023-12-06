package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {
	
	public Type_C_GameObject(int x, int y) {
		super(x,y);
		setDirection(Direction.LEFT);
		ID = 2;
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
		
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();
		
		//MOVE PURPLE GAME OBJECT
		switch(getDirection()) {
		case Direction.RIGHT:
			setX(getX() + getVelocity());
			if(getX() + iconWidth > canvasWidth) {
				setX((int) (canvasWidth - iconWidth));
				setDirection(Direction.LEFT);
			}
			break;
		case Direction.LEFT:
			setX(getX() - getVelocity());
	        if (getX() < 0) {
	          setX(0);
	          setDirection(Direction.RIGHT);
	        }
	        break;
		}
	}
	
	//SPECIFY THE IMAGE TO DISPLAY
    //	USED FOR ANIMATION
    public void setImage() {
    	switch (getDirection()) {
    	case Direction.NONE:
    		break;
    	case Direction.LEFT:
    		currentImage = 0;
    		break;
    	case Direction.RIGHT:
    		currentImage = 1;
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
				setDirection(Direction.LEFT);
			}
			else {
				setDirection(Direction.RIGHT);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if(isFocus == true) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.RIGHT);
			}
		}
	}
}
