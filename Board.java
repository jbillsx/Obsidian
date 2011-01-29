package obsidiangame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Iterator;
import javax.swing.Timer;
import java.util.ArrayList;
public class Board extends JPanel implements ActionListener{
    private Player craft;
    private Block tile;
    private Timer timer;
    public ArrayList<Block> blocks;
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.lightGray);
        setDoubleBuffered(true);
        blocks = new ArrayList<Block>();
        craft = new Player();
        //tile = new Block(70, 452);
        timer = new Timer(5, this);
        boolean add = blocks.add(new Block(0,452));
        add = blocks.add(new Block(32,452));
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        //g2d.drawImage(tile.getImage(), tile.getX(), tile.getY(), this);
        Iterator<Block> itr = blocks.iterator();
        while(itr.hasNext())
        {
            Block next = itr.next();
            g2d.drawImage(next.getImage(), next.getX(), next.getY(), this);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        
        craft.move(blocks);
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }
}