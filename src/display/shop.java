package display;

import function.ImgSetSize;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shop extends JFrame{
    private JButton home;
    private JButton userHomeButton;
    private JButton searchButton;
    private JButton reelsButton;
    private JButton shopButton;
    private JPanel bottom;
    private JButton homeButton;
    private JPanel main;

    public shop(int session){
        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.jpg", 50, 50);
        shopButton.setIcon(shop.getImg());

        ImgSetSize userHome = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
        userHomeButton.setIcon(home.getImg());



        setContentPane(main);
        setSize(850,1000);
        bottom.setSize(850,50);
        setBounds(0,0,850,1000);
        setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a  = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
        userHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session);
                setVisible(false);
                a.setVisible(true);
            }
        });
    }
}
