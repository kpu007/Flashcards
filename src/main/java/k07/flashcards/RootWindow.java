package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;

public class RootWindow extends JFrame {

    private ArrayList<CharacterTuple> results;
    int currentPos = 0;

    JTextField characterField = new JTextField();

    public RootWindow() {
        this.setTitle("Kanji Flashcards");
        this.setLayout(new GridLayout(3, 1));

        JTextArea outputArea = new JTextArea();
        this.add(outputArea);

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
            outputArea.setText(InternetUtils.obtainMapForKanji(characterField.getText()).toString());
        });
        retrieveButton.setText("Lookup");
        this.add(retrieveButton);

        this.add(ComponentUtils.componentWithLabel(characterField, "Character"));

        this.addWindowListener(new CloseApplicationListener());
    }

    private class CloseApplicationListener implements WindowListener {
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e){System.exit(0);}
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowActivated(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
    }





}
