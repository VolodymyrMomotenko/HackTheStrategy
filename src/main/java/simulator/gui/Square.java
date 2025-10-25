package simulator.gui;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends StackPane
{
    public static final int LAYER_BACKGROUND = 0;
    public static final int LAYER_POINT = 1;
    public static final int LAYER_HIGHLIGHT = 2;
    
    private final Node[] layers = new Node[3];
    private final int squareSize;
    
    public Square(Color colour, int size)
    {
        this.squareSize = size;
        layers[LAYER_BACKGROUND] = new Rectangle(size, size, colour);
        getChildren().add(layers[LAYER_BACKGROUND]);
    }

    public void setColour(Color colour)
    {
        setLayer(LAYER_BACKGROUND, new Rectangle(squareSize, squareSize, colour));
    }
    
    public void setPiece(Node interestPoint)
    {
        setLayer(LAYER_POINT, interestPoint);
    }
    
    public void setHighlight(Node highlight)
    {
        setLayer(LAYER_HIGHLIGHT, highlight);
    }

    
    private void setLayer(int index, Node node)
    {
        getChildren().remove(layers[index]);
        
        if (node != null)
        {
            layers[index] = node;
            getChildren().add(node);
        }
    }
}
