import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        boolean ret = false;
        double parameter = 0;
        Rectangle r = (Rectangle) x;

        parameter = 2 * (r.getWidth() + r.getHeight());
        if (parameter > 10) {
            ret = true;
        }
        return ret;
    }


}
