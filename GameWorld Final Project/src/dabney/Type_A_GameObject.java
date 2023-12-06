package dabney;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {
	
	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.UP);
		ID = 1;
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		int  iconHeight = icon.getIconHeight();
	    int  canvasHeight = (int)c.getSize().getHeight();
	    
	    //MOVE YELLOW GAME OBJECT
	    switch(getDirection()) {
	    case Direction.UP:
	    	setY(getY() - getVelocity());
	    	if(getY() < 0) {
	    		setY(0);
	    		setDirection(Direction.DOWN);
	    	}
	    	break;
	    case Direction.DOWN:
	    	setY(getY() + getVelocity());
	    	if(getY() + iconHeight > canvasHeight) {
	    		setY((int) (canvasHeight - iconHeight));
	    		setDirection(Direction.UP);
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
    	case Direction.UP:
    		currentImage = 0;
    		break;
    	case Direction.DOWN:
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
				setDirection(Direction.UP);
			}
			else {
				setDirection(Direction.DOWN);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if (isFocus == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
		}
	}

}
