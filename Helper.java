package obsidiangame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Helper {
    public boolean Collide(Player craft, Block tile)
    {
        Rectangle r3 = craft.getBounds();
        Rectangle r1 = tile.getBounds();
        if(r3.intersects(r1))
        {
            return true;
        }
        return false;
    }
}