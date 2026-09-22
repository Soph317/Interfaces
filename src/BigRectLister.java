import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectList = new ArrayList<>();

        rectList.add(new Rectangle(1, 1));
        rectList.add(new Rectangle(1, 2));
        rectList.add(new Rectangle(2, 2));
        rectList.add(new Rectangle(1, 4));
        rectList.add(new Rectangle(2, 3));

        rectList.add(new Rectangle(3, 3));
        rectList.add(new Rectangle(2, 4));
        rectList.add(new Rectangle(4, 5));
        rectList.add(new Rectangle(6, 4));
        rectList.add(new Rectangle(5, 5));

        Filter filter = new BigRectangleFilter();
        System.out.println("Big rectangles with perimeter > 10:");
        for (Rectangle rect : rectList) {
            if (filter.accept(rect)) {
                System.out.println("Rectangle: width = " + rect.getWidth() + ", height = " + rect.getHeight() + ", perimeter = " + (2 * (rect.getWidth() + rect.getHeight())));
            }
        }

    }

}
