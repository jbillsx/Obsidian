package obsidiangame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
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


    public void move(ArrayList<ArrayList> p) {
        y += dy;
        if(this.y-this.old_y == 100)
        {
            dy = 4;
        }
        for (ArrayList row: p)
        {
            Iterator<Block> itr = row.iterator();
            while(itr.hasNext())
            {
                Block next = itr.next();
                //help.Mess(new Boolean(next.solid).toString());
                if(next.solid && next.visible)
                {
                    if(help.Collide(this, next))
                    {


                        if (next.solid)
                        {
                            y -= dy;
                            this.jump = true;
                        }
                    }
                }
            }
        }
        x += dx;
        for (ArrayList row: p)
        {
            Iterator<Block> itr = row.iterator();
            while(itr.hasNext())
            {
                Block next = itr.next();
                if(next.solid && next.visible)
                {
                    if(help.Collide(this, next))
                    {


                        if (next.solid)
                        {
                            x -= dx;
                            this.jump = true;
                        }
                    }
                }
            }
        }
    }
    private void ChangeImage()
    {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(user));
        image = ii.getImage();
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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            user = "userleft.png";
            ChangeImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            user = "user.png";
            ChangeImage();
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