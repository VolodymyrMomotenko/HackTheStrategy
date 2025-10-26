package simulator.gui;

import simulator.core.Colour;
import simulator.core.pointsOfInterest.InterestPoint;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InterestPointRender extends ImageView
{
    private static final String IMAGE_PATH = "/images/%s.png";

    public InterestPointRender(InterestPoint point)
    {
        String type = point.getClass().getSimpleName().toLowerCase();
        String path =  String.format(IMAGE_PATH, type);
        
        Image image = new Image(getClass().getResourceAsStream(path));
        setImage(image);
        setFitWidth(80);
        setFitHeight(80);
    }
}
