package aron.app;

public class SpaceComputer {
    private static final String messageComputer = "SPACE COMPUTER working on r=%d, x=%d, y=%d\n";

    public static void CanWeLandSafely( final int r, final int landingX, final int landingY ) {
        if ( r <= 0 ) {
            System.out.println("ERROR: r must be greater than zero!");
            return;
        }

        final SameXYRCircle greenCircle  = new SameXYRCircle(r);
        final SameXYRCircle yellowCircle = new SameXYRCircle(-r);
        final boolean insideGreenCircle  = greenCircle.IsPointInside(landingX, landingY);
        final boolean insideYellowCircle = yellowCircle.IsPointInside(landingX, landingY);

        System.out.printf(messageComputer, r, landingX, landingY);
        if ( insideGreenCircle || insideYellowCircle ) {
            if ( insideGreenCircle ) {
                System.out.println("☺☺☺ GREEN ZONE OK ☺☺☺\n");
            } else {
                System.out.println("☺☺☺ YELLOW ZONE OK ☺☺☺\n");
            }

        } else {
            System.out.println("☠☠☠ WE WILL NOT REACH ANY OF THE SAFE ZONES! ☠☠☠\n");
        }
    }

    public static void main( String[] args ) {
        // coordinates closer to green zone
        CanWeLandSafely(6, 0, 0);
        CanWeLandSafely(6, 1, 1);
        CanWeLandSafely(6, 2, 2);
        CanWeLandSafely(6, 3, 3);
        CanWeLandSafely(6, 6, 6);
        CanWeLandSafely(6, 11, 7);
        CanWeLandSafely(6, 12, 7);
        System.out.println("---------------------------------------");
        // coordinates closer to yellow zone
        CanWeLandSafely(6, 0, 0);
        CanWeLandSafely(6, -1, -1);
        CanWeLandSafely(6, -2, -2);
        CanWeLandSafely(6, -3, -3);
        CanWeLandSafely(6, -6, -6);
        CanWeLandSafely(6, -11, -7);
        CanWeLandSafely(6, -12, -7);
    }
}