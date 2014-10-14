package ee.ut.math.tvt.EpicTiim;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Properties;

public class IntroUI extends JFrame {
    private JPanel panel;
    private JLabel teamLeader;
    private JLabel teamLeaderEmail;
    private JLabel teamName;
    private JLabel teamMembers;
    private JLabel VersionOfBuild;
    private JLabel logo;
    private GridBagLayout gridBagLayout = new GridBagLayout();
    private static final Insets insets = new Insets(0, 0, 0, 0);
    
    public IntroUI() throws IOException {
    	createInterior();
    	InteriorToThePanel();
    	fillFields();
    }
    
    private void createInterior(){
    	this.panel = new JPanel(gridBagLayout);
    	this.panel.setBackground(Color.darkGray);
    	
    	this.teamLeader = new JLabel();
    	this.teamLeaderEmail = new JLabel();
    	this.teamName = new JLabel();
    	this.teamMembers = new JLabel();
    	this.VersionOfBuild = new JLabel();
    	this.logo = new JLabel();
    	
    }
    
    private static void AddAComponent(Container container, Component component, int gridx, int gridy,
            int gridwidth, int gridheight, int anchor, int fill){
        GridBagConstraints GBC = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                anchor, fill, insets, 0, 0);
        container.add(component, GBC);
    }
    
    private void InteriorToThePanel(){
    	AddAComponent(panel, teamLeader, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
    	AddAComponent(panel, teamLeaderEmail, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
    	AddAComponent(panel, teamName, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
    	AddAComponent(panel, teamMembers, 0, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
    	AddAComponent(panel, VersionOfBuild, 0, 9, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
    	panel.add(logo);
    	this.add(panel);
    }
    
    private ImageIcon NewImageIcon(String PathToPic){
    	ClassLoader classLoader = IntroUI.class.getClassLoader(); // able to find a file.
    	java.net.URL imgURL = classLoader.getResource(PathToPic); // determine location of a file.
    	
    	 if (imgURL != null) {
             return new ImageIcon(imgURL);
    	 } else {
    		 System.err.println("Didn't find the file, which was suppose to be at: " + PathToPic);
    		 return null;
    	 }
    }
    
    private void fillFields() throws IOException {
    	 
        Properties properties = new Properties();
        //LoadProperties(properties, "application.properties"); // used to read data from app.prop.
        
        teamLeader.setText("Team leader: " + properties.getProperty("Leader"));
        teamLeaderEmail.setText("Team leader email: " + properties.getProperty("Email"));
        teamName.setText("Team name: " + properties.getProperty("Name"));
        teamMembers.setText("Team members: " + properties.getProperty("Members"));
        
        //LoadProperties(properties, "version.properties");
        VersionOfBuild.setText("Version: " + properties.getProperty("VersionOfBuild"));
        
}
    private void LoadProperties(Properties properties, String filename) throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        InputStream resourceStream = cl.getResourceAsStream(filename); 
        if (resourceStream == null) {
            throw new AssertionError("Check that etc is in classpath");
        }
        try {
            properties.load(resourceStream);
        } finally {
            resourceStream.close();
        }
    }
}
	

