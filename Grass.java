package obsidiangame;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Grass extends Block{

    private String block = "grass.png";
    private static int width = 32;
    private static int height = 32;
    private int x;
    private int y;
    private Image image;
    Grass(int dx, int dy) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(block));
        image = ii.getImage();
        x = dx * 32;
        y = dy * 32;
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
}