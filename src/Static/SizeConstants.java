package Static;

public class SizeConstants
{
    private int WIDTH;
    private int WIDTH_RATIO;

    private int HEIGHT;
    private int HEIGHT_RATIO;

    public SizeConstants()
    {
        this.WIDTH = 1000;
        this.WIDTH_RATIO = WIDTH / 100;

        this.HEIGHT = 700;
        this.HEIGHT_RATIO = HEIGHT / 100;
    }

    public int getWIDTH()
    {
        return WIDTH;
    }

    public int getWIDTH_RATIO()
    {
        return WIDTH_RATIO;
    }

    public int getHEIGHT()
    {
        return HEIGHT;
    }

    public int getHEIGHT_RATIO()
    {
        return HEIGHT_RATIO;
    }
}