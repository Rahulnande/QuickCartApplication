package service;

public class MaskingThread extends Thread
{
    private boolean stop = false;

    public void stopMasking()
    {
        stop = true;
    }

    @Override
    public void run()
    {
        while(!stop)
        {
            System.out.print("*");

            try
            {
                Thread.sleep(100);
            }

            catch(Exception e)
            {
            }
        }
    }
}