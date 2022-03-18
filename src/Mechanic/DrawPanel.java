package Mechanic;

import javax.swing.*;
import java.awt.*;

import static Libraries.Methods.*;
import static Mechanic.MainVariables.*;

public class DrawPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xDisplacement = cameraCenterSquareX*cameraScalePixelsPerYear+cameraCenterSquareDoubleX;
        int yDisplacement = cameraCenterSquareY*cameraScalePixelsPerYear+cameraCenterSquareDoubleY;
//        System.out.println(xDisplacement);

        g.fillOval(10-4+xDisplacement, FRAME_SIZE.height/2-4+yDisplacement, 8, 8);
        g.drawString("2006", 10+xDisplacement, FRAME_SIZE.height/2+yDisplacement);
        g.drawLine(10+xDisplacement, FRAME_SIZE.height/2+yDisplacement, 10+15*cameraScalePixelsPerYear+xDisplacement, FRAME_SIZE.height/2+yDisplacement);
    }
}
