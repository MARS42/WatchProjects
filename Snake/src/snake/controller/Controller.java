package snake.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snake.ui.Window;

/**
 *
 * @author Robert
 */
public class Controller implements KeyListener
{
    Window w;
    public Controller(Window w){ this.w = w; }
    
    public enum directions
    {
        UP, DOWN, LEFT, RIGHT, IDLE
    }
    private directions direction = directions.IDLE;
    public void setDirection(directions direction){ this.direction = direction; }
    public directions getDirection(){ return direction; }

    @Override
    public void keyTyped (KeyEvent e)
    {
    }

    @Override
    public void keyPressed (KeyEvent e)
    {
    }

    @Override
    public void keyReleased (KeyEvent e)
    {
        int kc = e.getKeyCode();
        switch (kc)
        {
            case 87:
            case 38:
                setDirection(directions.UP);
                break;
            case 83:
            case 40:
                setDirection(directions.DOWN);
                break;
            case 65:
            case 37:
                setDirection(directions.LEFT);
                break;
            case 68:
            case 39:
                setDirection(directions.RIGHT);
                break;
            default:
                break;
        }
        //System.out.println(getDirection().name());
    }
}
