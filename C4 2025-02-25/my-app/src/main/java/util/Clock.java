package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock {
	public static void updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		String currentDateTime = sdf.format(new Date());
		clock.setText(currentDateTime);
		/*Timer timer = new Timer(1000, e -> Clock.updateDateTime(lblNewLabel_1));帶這個
		timer.start();*/
	}

}
