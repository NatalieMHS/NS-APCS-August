
public class DrumKitTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrumKit d = new DrumKit();
		d.playSnare();
		d.snare = false;
		if (d.snare == true) {
			d.playSnare();
		}
		d.playTopHat();
	}

}
