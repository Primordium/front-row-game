package org.academiadecodigo.ramsters.frontrowgame.window;

public class FieldLimits {
    private static final int minX = 10;
    private static final int minY = 10;
    private static final int height = 825;
    private static final int width = 1145;

    public static boolean verifyX(int x) {
        if (x - 10 < minX || x + 10 > width) {
            return false;
        }
        return true;
    }

    public static boolean verifyY(int y) {
        if (y + 10 > height || y - 10 < minY) {
            return false;
        }
        return true;
    }
}
