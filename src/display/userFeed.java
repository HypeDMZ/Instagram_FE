package display;

import chatting.ListeningThread;
import chatting.chatting_client;
import function.ImgSetSize;
import function.follow;
import function.unfollow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class userFeed extends JFrame{
    private JButton homeButton;
    private JButton userhomeButton;
    private JButton reelsButton;
    private JButton searchButton;
    private JButton shopButton;
    private JPanel bottom;
    private JPanel top;
    private JPanel profile;
    private JPanel post;
    private JPanel main;
    private String user_id;

    private chatting_client client;

    private final static ArrayList<Integer> List= new ArrayList<>();
    private JButton create;
    private JScrollPane post_scroll;
    private JPanel scroll;
    private JButton uploadButton;
    private JButton moreButton;
    private JButton profile_follow;
    private JLabel related;
    private JLabel security;
    private JLabel arrowDown;

    private JLabel feedList;
    private JLabel feedTag;
    private JPanel userLeftRight;
    private JPanel userLeft;
    private JPanel userRight;
    private JLabel user_id_gui;
    private JLabel postNum;
    private JLabel followerNum;
    private JLabel followingNum;

    private String follow_exist;

    private String id;

    private int session;
    public userFeed(int session, String user_id, String id,chatting_client client, ListeningThread t1){

        this.user_id = user_id;
        this.session = session;
        this.client = client;
        this.id = id;


        ImgSetSize home = new ImgSetSize("src/IMG/home.png", 50, 50);
        homeButton.setIcon(home.getImg());

        ImgSetSize search = new ImgSetSize("src/IMG/search.png", 50, 50);
        searchButton.setIcon(search.getImg());

        ImgSetSize reels = new ImgSetSize("src/IMG/reels.png", 50, 50);
        reelsButton.setIcon(reels.getImg());

        ImgSetSize shop = new ImgSetSize("src/IMG/shop.jpg", 50, 50);
        shopButton.setIcon(shop.getImg());

        ImgSetSize userHome = new ImgSetSize("src/IMG/userhomefeed.png", 50, 50);
        userhomeButton.setIcon(userHome.getImg());

        ImgSetSize lock = new ImgSetSize("src/IMG/security.png", 50, 50);
        security.setIcon(lock.getImg());

        ImgSetSize feedLl = new ImgSetSize("src/IMG/feedList.png", 50, 50);
        feedList.setIcon(feedLl.getImg());

        ImgSetSize feedRl = new ImgSetSize("src/IMG/feedTag.png", 50, 50);
        feedTag.setIcon(feedRl.getImg());

        ImgSetSize upload = new ImgSetSize("src/IMG/addfeed.png", 50, 50);
        uploadButton.setIcon(upload.getImg());

        ImgSetSize more = new ImgSetSize("src/IMG/user_more.png", 50, 50);
        moreButton.setIcon(more.getImg());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Integer> post_list = new ArrayList<Integer>();
        // get_post_list();
        post_list.add(1);
        post_list.add(2);
        post_list.add(3);
        post_list.add(4);
        post_list.add(5);
        post_list.add(6);
        post_list.add(7);
        post_list.add(8);
        post_list.add(9);
        post_list.add(10);
        post_list.add(11);

        post_scroll.getVerticalScrollBar().setUnitIncrement(15);

        GridBagLayout Gbag = new GridBagLayout();
        scroll.setLayout(Gbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        for(int i = 0;i<post_list.size();i++){
            post pane = new post();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipadx = 200;
            gbc.ipady = 200;
            gbc.gridx = i%3;
            gbc.gridy = i/3;
            Gbag.setConstraints(pane,gbc);
            scroll.add(pane);
            scroll.updateUI();
        }
        post_scroll.setViewportView(scroll);
        post_scroll.setVisible(true);
        scroll.setVisible(true);

        client.get_post_num(10, user_id);
        client.get_following_num(19, user_id);
        client.get_follow_num(20, user_id);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        postNum.setText(String.valueOf(t1.getPost_num()));
        followerNum.setText(String.valueOf(t1.get_follow_num()));
        followingNum.setText(String.valueOf(t1.getFollowing_num()));


        if(user_id == id){
            profile_follow.setText("editprofile");
            user_id_gui.setText(user_id);
        }
        else{
            user_id_gui.setText(id);
            client.follow_bool(9,user_id,id);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            String a = t1.get_follow_exist();
            follow_exist =a;
            if(a.equals("true")){
                profile_follow.setText("unfollow");
            }
            else{
                profile_follow.setText("follow");
            }
        }


        setContentPane(main);
        setSize(850,1000);
        bottom.setSize(850,50);
        setBounds(0,0,850,1000);
        setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFeed a = new mainFeed(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search a = new search(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        reelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reels a = new reels(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop a = new shop(session,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        userhomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFeed a = new userFeed(session,user_id,user_id,client,t1);
                setVisible(false);
                a.setVisible(true);
            }
        });

        profile_follow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user_id == id){
                    //profile_수정
                    editprofile a = new editprofile(session,user_id,client,t1);
                    setVisible(false);
                    a.setVisible(true);
                }
                else{
                    user_id_gui.setText(id);
                    client.follow_bool(9,user_id,id);
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                    catch(Exception ea){
                        ea.printStackTrace();
                    }
                    String a = t1.get_follow_exist();
                    follow_exist =a;
                    //follow
                    if(follow_exist.equals("true")){
                        //unfollow 요청
                        profile_follow.setText("follow");
                        new unfollow(user_id,id,client);
                    }
                    else{
                        //follow 요청
                        profile_follow.setText("unfollow");
                        new follow(user_id,id,client);

                    }
                }
            }
        });
    }
    public class post extends JPanel{
        private JButton post_num;

        post(){
            setLayout(new GridLayout(1,1));
            setSize(200,200);
            post_num = new JButton();
            post_num.setSize(200,200);
            add(post_num);


            post_num.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
    }
}
