package obsidiangame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Player {

    private String user = "user.png";

    private int dx;
    private int dy = 4;
    private static int width = 32;
    private static int height = 152;
    private int x;
    private int y;
    public int old_x;
    public int old_y;
    Helper help = new Helper();
    private Image image;
    public boolean jump = true;
    public void ResetX()
    {
        dx = 0;
    }
    public void ResetY()
    {
        dy = 0;
    }
    public void Fall()
    {
        dy = -4;
    }
    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(user));
        image = ii.getImage();
        x = 40;
        y = 60;
    }


    public void move(Block p) {
        y += dy;
        if(this.y-this.old_y == 100)
        {
            dy = 4;
        }
        if(help.Collide(this, p))
        {
            if (p.solid)
            {
                y -= dy;
                this.jump = true;
            }
        }
        x += dx;
        if(help.Collide(this, p))
        {
            if (p.solid)
            {
            x -= dx;
            }
        }
    }

    public int getX() {
        return x;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e, Block tile) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            this.old_x = this.y;
            if(jump)
            {
                dy = -4;
            }
            jump = false;

        }

        /*if (key == KeyEvent.VK_DOWN) {
            dy = 4;
        }*/
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 4;
        }

        /*if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }*/
    }
}