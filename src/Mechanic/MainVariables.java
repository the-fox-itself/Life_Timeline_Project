package Mechanic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static Libraries.Methods.*;

public class MainVariables {
    public static ArrayList<String> listOfThings = new ArrayList<>();

    public static GameThreads.GameLoop gameLoop = new GameThreads.GameLoop();
    public static double millisecondsPerUpdate = 1000d / 60;

    public static int cameraCenterSquareX = 0;
    public static int cameraCenterSquareY = 0;
    public static int cameraCenterSquareDoubleX = 0;
    public static int cameraCenterSquareDoubleY = 0;
    public static int cameraScalePixelsPerYear = 100;

    public static boolean gameLoopOn;
    public static boolean fullscreenOn = false;

    public static boolean w;
    public static boolean a;
    public static boolean s;
    public static boolean d;

    public static Point mouseLocation;

    final public static Image ICON_FRAME = new ImageIcon("resources"+SEPARATOR+"images"+SEPARATOR+"Icon.png").getImage();
    public static JFrame frame = getFrame("", ICON_FRAME, FRAME_SIZE.width, FRAME_SIZE.height, null, null, true);


    public static class FrameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    if (!w)
                        w = true;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    if (!a)
                        a = true;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    if (!d)
                        d = true;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    if (!s)
                        s = true;
                    break;
                default:
                    System.out.println(e.getKeyChar());
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                case 'W':
                case 'ц':
                case 'Ц':
                    w = false;
                    break;
                case 'a':
                case 'A':
                case 'ф':
                case 'Ф':
                    a = false;
                    break;
                case 'd':
                case 'D':
                case 'в':
                case 'В':
                    d = false;
                    break;
                case 's':
                case 'S':
                case 'ы':
                case 'Ы':
                    s = false;
                    break;
            }
        }
    }

    public static class FrameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            mouseLocation = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static class FrameMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            int dx = e.getX() - mouseLocation.x;
            int dy = e.getY() - mouseLocation.y;
            mouseLocation = e.getPoint();
            cameraCenterSquareDoubleX += dx;
            if (cameraCenterSquareDoubleX >= cameraScalePixelsPerYear) {
                cameraCenterSquareX += Math.floorDiv(cameraCenterSquareDoubleX, cameraScalePixelsPerYear);
                cameraCenterSquareDoubleX = Math.floorMod(cameraCenterSquareDoubleX, cameraScalePixelsPerYear);
            }
            if (cameraCenterSquareDoubleX < 0) {
                if (Math.floorDiv(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear) > 0) {
                    cameraCenterSquareX -= Math.floorDiv(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear);
                    cameraCenterSquareDoubleX = cameraScalePixelsPerYear - Math.floorMod(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear);
                } else {
                    cameraCenterSquareX -= 1;
                    cameraCenterSquareDoubleX = cameraScalePixelsPerYear - Math.abs(cameraCenterSquareDoubleX);
                }
            }
            cameraCenterSquareDoubleY += dy;
            if (cameraCenterSquareDoubleY >= cameraScalePixelsPerYear) {
                cameraCenterSquareY += Math.floorDiv(cameraCenterSquareDoubleY, cameraScalePixelsPerYear);
                cameraCenterSquareDoubleY = Math.floorMod(cameraCenterSquareDoubleY, cameraScalePixelsPerYear);
            }
            if (cameraCenterSquareDoubleY < 0) {
                if (Math.floorDiv(Math.abs(cameraCenterSquareDoubleY), cameraScalePixelsPerYear) > 0) {
                    cameraCenterSquareY -= Math.floorDiv(Math.abs(cameraCenterSquareDoubleY), cameraScalePixelsPerYear);
                    cameraCenterSquareDoubleY = cameraScalePixelsPerYear - Math.floorMod(Math.abs(cameraCenterSquareDoubleY), cameraScalePixelsPerYear);
                } else {
                    cameraCenterSquareY -= 1;
                    cameraCenterSquareDoubleY = cameraScalePixelsPerYear - Math.abs(cameraCenterSquareDoubleY);
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static class FrameMouseWheelListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            switch (e.getWheelRotation()) {
                case 1:
                    if (cameraScalePixelsPerYear > 1) {
                        cameraScalePixelsPerYear -= 1;
                        if (cameraCenterSquareDoubleY >= cameraScalePixelsPerYear) {
                            cameraCenterSquareDoubleY -= cameraScalePixelsPerYear;
                            cameraCenterSquareY += 1;
                        }
                        if (cameraCenterSquareDoubleY <= -1) {
                            cameraCenterSquareDoubleY += cameraScalePixelsPerYear;
                            cameraCenterSquareY -= 1;
                        }
                        if (cameraCenterSquareDoubleX >= cameraScalePixelsPerYear) {
                            cameraCenterSquareDoubleX -= cameraScalePixelsPerYear;
                            cameraCenterSquareX += 1;
                        }
                        if (cameraCenterSquareDoubleX <= -1) {
                            cameraCenterSquareDoubleX += cameraScalePixelsPerYear;
                            cameraCenterSquareX -= 1;
                        }
                    }
                    break;
                case -1:
                    cameraScalePixelsPerYear += 1;
                    if (cameraCenterSquareDoubleY >= cameraScalePixelsPerYear) {
                        cameraCenterSquareDoubleY -= cameraScalePixelsPerYear;
                        cameraCenterSquareY += 1;
                    }
                    if (cameraCenterSquareDoubleY <= -1) {
                        cameraCenterSquareDoubleY += cameraScalePixelsPerYear;
                        cameraCenterSquareY -= 1;
                    }
                    if (cameraCenterSquareDoubleX >= cameraScalePixelsPerYear) {
                        cameraCenterSquareDoubleX -= cameraScalePixelsPerYear;
                        cameraCenterSquareX += 1;
                    }
                    if (cameraCenterSquareDoubleX <= -1) {
                        cameraCenterSquareDoubleX += cameraScalePixelsPerYear;
                        cameraCenterSquareX -= 1;
                    }
                    break;
            }
        }
    }
}
