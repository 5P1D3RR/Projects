// Java Program to create a notepad using java
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

class notepad extends JFrame implements ActionListener {
    // Frame
    JFrame frame;

    // Text component
    JTextArea textArea;

    // Constructor
    notepad()
    {
        // Create a frame
        frame = new JFrame("Notepad");


        // Text component
        textArea = new JTextArea();

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu for menu
        JMenu file = new JMenu("File");

        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi7 = new JMenuItem("Print");



        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi7.addActionListener(this);

        file.add(mi1);
        file.add(mi2);
        file.add(mi3);
        file.add(mi7);


        // Create a menu for menu
        JMenu edit = new JMenu("Edit");

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");

        // Add action listener
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        edit.add(mi4);
        edit.add(mi5);
        edit.add(mi6);


        JMenuItem about = new JMenuItem("About");

        about.addActionListener(this);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(about);



        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.add(new JScrollPane(textArea));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // When a button is pressed
    public void actionPerformed(ActionEvent event)
    {
        String about = "This Notepad was designed by Abdulrahman Yusuf of Cybersecurity Department";
        String s = event.getActionCommand();

        if (s.equals("cut")) {
            textArea.cut();
        }
        else if (s.equals("copy")) {
            textArea.copy();
        }
        else if (s.equals("paste")) {
            textArea.paste();
        }
        else if (s.equals("Save")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");

            // Invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    // Create a file writer
                    FileWriter wr = new FileWriter(fi, false);

                    // Create buffered writer to write
                    BufferedWriter w = new BufferedWriter(wr);

                    // Write
                    w.write(textArea.getText());

                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(frame, "the user " +
                        "cancelled the operation");
        }
        else if (s.equals("Print")) {
            try {
                // print the file
                textArea.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        }
        else if (s.equals("Open")) {
            // Create an object of JFileChooser class
            JFileChooser jFileChooser = new JFileChooser("f:");

            // Invoke the showsOpenDialog function to show the save dialog
            int showOpenDialog = jFileChooser.showOpenDialog(null);

            // If the user selects a file
            if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
                // Set the label to the path of the selected directory
                File fi = new File(jFileChooser.getSelectedFile().getAbsolutePath());

                try {
                    // String
                    String s1 = "", sl = "";

                    // File reader
                    FileReader fr = new FileReader(fi);

                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);

                    // Initialize sl
                    sl = br.readLine();

                    // Take the input from the file
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }

                    // Set the text
                    textArea.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else
                JOptionPane.showMessageDialog(frame, "the user" +
                        " cancelled the operation");
        }
        else if (s.equals("New")) {
            textArea.setText(" ");
        }
        else if (s =="About"){
            JOptionPane.showMessageDialog(frame, about);
        }
    }

    // Main class
    public static void main(String args[]){
        notepad e = new notepad();
    }
}

