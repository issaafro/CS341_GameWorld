package dabney;

public class MyMain {

	public static void main(String[] args) {
		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT
		Type_D_GameObject user = new Type_D_GameObject(460, 570);
		user.setVelocity(20);
		canvas.addKeyListener(user);
		canvas.addGameObject(user);
		
		Type_A_GameObject userA = new Type_A_GameObject(600, 50);
		userA.setVelocity(20);
		canvas.addKeyListener(userA);
		canvas.addGameObject(userA);
		
		Type_C_GameObject userC = new Type_C_GameObject(300, 300);
		userC.setVelocity(20);
		canvas.addKeyListener(userC);
		canvas.addGameObject(userC);
		
		Type_B_GameObject userB = new Type_B_GameObject(50,50);
		Type_B_AdapterObject adapterB = new Type_B_AdapterObject(userB);
		adapterB.setVelocity(20);
		canvas.addKeyListener(adapterB);
		canvas.addGameObject(adapterB);

	}

}
