package MathPack;

/**
 *
 * @author Robert
 */
public class Geometry
{
    public static float Vector2Distance(Vector2 a, Vector2 b)
    {
        return (float)Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
    
    public static float Vector2Distance(Vector2Int a, Vector2Int b)
    {
        return Vector2Distance(new Vector2(a.x, a.y), new Vector2(b.x, b.y));
    }
    
    public static float Vector2Distance(Vector2 a, Vector2Int b)
    {
        return Vector2Distance(a, new Vector2(b.x, b.y));
    }
    
    public static float Vector2Distance(Vector2Int a, Vector2 b)
    {
        return Vector2Distance(new Vector2(a.x, a.y), b);
    }
}
