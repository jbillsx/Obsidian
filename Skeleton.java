/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package obsidiangame;

/**
 *
 * @author josiah
 */

import javax.swing.JFrame;

public class Skeleton extends JFrame {

    public Skeleton(String x) {
        add(new Board());
        setTitle(x);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(774, 508);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new Skeleton("Obsidian: 2D Minecraft");
    }
}
