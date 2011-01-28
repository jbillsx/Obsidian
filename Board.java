package obsidiangame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.JPanel;
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

        craft = new Player();
        tile = new Grass(70, 452);
        timer = new Timer(5, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        g2d.drawImage(tile.getImage(), tile.getX(), tile.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        
        craft.move(tile);
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e,tile);
        }
    }
}