package snake;

import MathPack.Vector2Int;
import java.util.Random;
import snake.ui.Window;

/**
 *
 * @author Robert
 */
public class GameMaster
{
    public static GameMaster GM;
    
    public Window window;
    
    public GameMaster()
    {
        GM = this;
        window = new Window();
        window.Init();
    }
    
    Random r = new Random();
    public Vector2Int GenerateFoodDot(int w, int h)
    {
        return new Vector2Int(r.nextInt(w), r.nextInt(h));
    }
}
