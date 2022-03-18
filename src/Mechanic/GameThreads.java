package Mechanic;

import java.util.Date;

import static Mechanic.MainVariables.*;

public class GameThreads {
    public static class GameLoop extends Thread {
        public void run() {
            double previous = new Date().getTime();
            double steps = 0;
            while (true) {
                if (gameLoopOn) {
                    double loopStartTime = new Date().getTime();
                    double elapsed = loopStartTime - previous;
                    previous = new Date().getTime();
                    steps += elapsed;

                    handleInput();

                    while (steps >= millisecondsPerUpdate) {
                        updateGameStats();
                        steps -= millisecondsPerUpdate;
                    }

                    frame.repaint();

                    double loopSlot = 10;
                    double endTime = loopStartTime + loopSlot;
                    while (new Date().getTime() < endTime) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ignored) {
                        }
                    }
                } else {
                    previous = new Date().getTime();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public void handleInput() {
            if (!s && w) {
                cameraCenterSquareDoubleY += 1;
                if (cameraCenterSquareDoubleY >= cameraScalePixelsPerYear) {
                    cameraCenterSquareY += Math.floorDiv(cameraCenterSquareDoubleY, cameraScalePixelsPerYear);
                    cameraCenterSquareDoubleY = Math.floorMod(cameraCenterSquareDoubleY, cameraScalePixelsPerYear);
                }
            } else if (!w && s) {
                cameraCenterSquareDoubleY -= 1;
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
            if (!d && a) {
                cameraCenterSquareDoubleX += 1;
                if (cameraCenterSquareDoubleX >= cameraScalePixelsPerYear) {
                    cameraCenterSquareX += Math.floorDiv(cameraCenterSquareDoubleX, cameraScalePixelsPerYear);
                    cameraCenterSquareDoubleX = Math.floorMod(cameraCenterSquareDoubleX, cameraScalePixelsPerYear);
                }
            } else if (!a && d) {
                cameraCenterSquareDoubleX -= 1;
                if (cameraCenterSquareDoubleX < 0) {
                    if (Math.floorDiv(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear) > 0) {
                        cameraCenterSquareX -= Math.floorDiv(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear);
                        cameraCenterSquareDoubleX = cameraScalePixelsPerYear - Math.floorMod(Math.abs(cameraCenterSquareDoubleX), cameraScalePixelsPerYear);
                    } else {
                        cameraCenterSquareX -= 1;
                        cameraCenterSquareDoubleX = cameraScalePixelsPerYear - Math.abs(cameraCenterSquareDoubleX);
                    }
                }
            }
        }
        public void updateGameStats() {

        }
    }
}
