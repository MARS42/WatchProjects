package snake.ui;

import MathPack.Geometry;
import MathPack.Vector2;
import MathPack.Vector2Int;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import snake.GameMaster;
import snake.controller.Controller;

/**
 *
 * @author Robert
 */
public class Window extends JFrame
{
    public GameZone gameZone;
    public Controller controller = new Controller(this);
    
    public Window()
    {
        super("Java Snake");
    }
    
    public void Init()
    {
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
        gameZone = new GameZone();
        gameZone.addKeyListener(controller);
        gameZone.setFocusable(true);
        add(gameZone);
    }
    
    public class GameZone extends JPanel
    {
        Color backgroundColor = Color.BLACK;
        Vector2 screenCenter = new Vector2(0, 0);
        Vector2 playerPosition = new Vector2(0, 0);
        Vector2 playerSize = new Vector2(30, 30);
        float playerSpeed = 1;
        
        Vector2Int nextFoodDot;
        int foodSize = 10;
        
        public GameZone()
        {
            Init();
        }
        
        private void Init()
        {
            setBackground(backgroundColor);
            screenCenter.x = getWidth() / 2;
            screenCenter.y = getHeight() / 2;
            playerPosition.x = screenCenter.x;
            playerPosition.y = screenCenter.y;
            Update update = new Update();
            update.setPriority(Thread.MAX_PRIORITY);
            update.start();
        }
        
        @Override
        public void paint(Graphics gr)
        {
            super.paint(gr);
            Graphics2D g = (Graphics2D)gr;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
            UpdateMovePlayer(g);
            UpdateFoodDot(g);
        }
        
        private void UpdateMovePlayer(Graphics2D g)
        {
            screenCenter.x = getWidth() / 2;
            screenCenter.y = getHeight() / 2;
            switch(controller.getDirection())
            {
                case UP:
                    playerPosition.y -= playerSpeed;
                    break;
                case DOWN:
                    playerPosition.y += playerSpeed;
                    break;
                case RIGHT:
                    playerPosition.x += playerSpeed;
                    break;
                case LEFT:
                    playerPosition.x -= playerSpeed;
                    break;
                case IDLE:
                    playerPosition.x = screenCenter.x;
                    playerPosition.y = screenCenter.y;
                    break;
            }
            g.setPaint(Color.WHITE);
            g.fillOval((int)playerPosition.x - (int)playerSize.x / 2, (int)playerPosition.y - (int)playerSize.y / 2, (int)playerSize.x, (int)playerSize.y);
        }
        
        private void UpdateFoodDot(Graphics2D g)
        {
            if(nextFoodDot == null)
                nextFoodDot = GameMaster.GM.GenerateFoodDot(getWidth(), getHeight());
            else
            {
                g.setPaint(Color.MAGENTA);
                g.fillOval(nextFoodDot.x - foodSize / 2, nextFoodDot.y - foodSize / 2, foodSize, foodSize);
                if(Geometry.Vector2Distance(playerPosition, nextFoodDot) < playerSize.x - foodSize)
                    nextFoodDot = null;
            }
        }
        
        public class Update extends Thread
        {
            @Override
            public void run()
            {
                while(!Thread.currentThread().isInterrupted())
                {
                    try
                    {
                        repaint();
                        sleep(10);
                    }
                    catch (InterruptedException ex){}
                }
            }
        }
    }
}
