package aron.app;

public class SpaceComputer {
    public static void canWeLandSafely( final int r, final int landingX, final int landingY ) {
        if ( r <= 0 ) {
            System.out.println("ERROR: r must be greater than zero!");
            return;
        }

        System.out.printf("SPACE COMPUTER working on r=%d, x=%d, y=%d\n", r, landingX, landingY);

        final SameXYRCircle circleGreen          = new SameXYRCircle(r);
        final SameXYRCircle circleYellow         = new SameXYRCircle(-r);
        final boolean       isInsideGreenCircle  = circleGreen.isPointInside(landingX, landingY);
        final boolean       isInsideYellowCircle = circleYellow.isPointInside(landingX, landingY);

        if ( isInsideGreenCircle ) {
            System.out.println("☺☺☺ GREEN ZONE OK ☺☺☺\n");
        } else if ( isInsideYellowCircle ) {
            System.out.println("☺☺☺ YELLOW ZONE OK ☺☺☺\n");
        } else {
            System.out.println("☠☠☠ WE WILL NOT REACH ANY OF THE SAFE ZONES! ☠☠☠\n");
        }
    }

    public static void main( String[] args ) {
        // coordinates closer to green zone
        canWeLandSafely(6, 0, 0);
        canWeLandSafely(6, 1, 1);
        canWeLandSafely(6, 2, 2);
        canWeLandSafely(6, 3, 3);
        canWeLandSafely(6, 6, 6);
        canWeLandSafely(6, 11, 7);
        canWeLandSafely(6, 12, 7);
        System.out.println("---------------------------------------");
        // coordinates closer to yellow zone
        canWeLandSafely(6, 0, 0);
        canWeLandSafely(6, -1, -1);
        canWeLandSafely(6, -2, -2);
        canWeLandSafely(6, -3, -3);
        canWeLandSafely(6, -6, -6);
        canWeLandSafely(6, -11, -7);
        canWeLandSafely(6, -12, -7);
    }
}