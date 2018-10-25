package movietime.core.main;

public class Main {

	public static void main(String[] args) throws Exception {

		runApplication();

	}

	@SuppressWarnings("static-access")
	private static void runApplication() {
		MovieTimeUI window = new MovieTimeUI();
		window.frame.setVisible(true);
	}
}
