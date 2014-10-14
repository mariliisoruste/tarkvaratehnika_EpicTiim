package ee.ut.math.tvt.EpicTiim;

import java.awt.*;
import java.io.IOException;
 
//import org.apache.log4j.Logger;
 
import javax.swing.*;

public class Intro {
	
   // private static final Logger log = Logger.getLogger(Intro.class);
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    DrawInterfaceXDisplayInterface();
                } catch (IOException e) {
                  //  log.error("IO problem.", e);
                    throw new RuntimeException(e);
                } catch (Throwable t) {
                   // log.error("Something went wrong.", t);
                    throw t;
                }
            }
        });
    }


	private static void DrawInterfaceXDisplayInterface() throws IOException {
		IntroUI intro = new IntroUI();
		intro.setTitle("Homework 3.");
		
		int width = 600;
		int height = 450;
		intro.setSize(width, height);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		intro.setLocation((screen.width - width) / 2, (screen.height - height) / 2); // set it in the middle
		
		intro.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        intro.setVisible(true);
        
        // I (personally) couldn't fix logger, but this line of code would need to be here:
        // log.info("Success.");
		
	}
	}
