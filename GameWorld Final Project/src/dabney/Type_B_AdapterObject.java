package dabney;

import javax.swing.Icon;

public class Type_B_AdapterObject extends Type_B_GameObject {
	
	public Type_B_AdapterObject(Type_B_GameObject type_B) {
		super(type_B.getX(), type_B.getY());
		setDirection(Direction.UP);
		
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();
		
		//MOVE RED GAME OBJECT
		if(isFocus == true) {
			switch (getDirection()) {
		      case Direction.UP:
		        setY(getY() - getVelocity());
		        if (getY() < 0) {
		          setY(0);
		        }
		        break;
		      case Direction.DOWN:
		        setY(getY() + getVelocity());
		        if (getY() + iconHeight > canvasHeight) {
		          setY((int)(canvasHeight - iconHeight));
		        }
		        break;
		      case Direction.LEFT:
		        setX(getX() + getVelocity());
		        if (getX() + iconWidth > canvasWidth) {
		          setX((int)(canvasWidth - iconWidth));
		        }
		        break;
		      case Direction.RIGHT:
		        setX(getX() - getVelocity());
		        if (getX() < 0) {
		          setX(0);
		        }
		        break;
			default:
				break;
		    }
		}
		
		else {
			switch (getDirection()) {
		      case Direction.UP:
		        setY(getY() - getVelocity());
		        if (getY() < 0) {
		          setY(0);
		          setDirection(Direction.RIGHT);
		        }
		        break;
		      case Direction.DOWN:
		        setY(getY() + getVelocity());
		        if (getY() + iconHeight > canvasHeight) {
		          setY((int)(canvasHeight - iconHeight));
		          setDirection(Direction.LEFT);
		        }
		        break;
		      case Direction.LEFT:
		        setX(getX() + getVelocity());
		        if (getX() + iconWidth > canvasWidth) {
		          setX((int)(canvasWidth - iconWidth));
		          setDirection(Direction.UP);
		        }
		        break;
		      case Direction.RIGHT:
		        setX(getX() - getVelocity());
		        if (getX() < 0) {
		          setX(0);
		          setDirection(Direction.DOWN);
		        }
		        break;
			default:
				break;
		    }
		}
		
	}

}
