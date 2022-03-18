package Mechanic;

import static Libraries.Methods.visTrue;
import static Mechanic.MainVariables.*;

public class Mechanic {
    final public static DrawPanel drawPanel = new DrawPanel();

    void preparation() {


        frame.addKeyListener(new MainVariables.FrameKeyListener());
        frame.addMouseListener(new MainVariables.FrameMouseListener());
        frame.addMouseMotionListener(new MainVariables.FrameMouseMotionListener());
        frame.addMouseWheelListener(new MainVariables.FrameMouseWheelListener());

        frame.setUndecorated(fullscreenOn);

        frame.add(drawPanel);
        drawPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        gameLoopOn = true;
        gameLoop.start();

        visTrue(frame);
    }
}
