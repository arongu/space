package aron.app;

/*
    d(c,p) = sqrt( (cx-px)pow2 + (cy-py)pow2 );
*/
public class SameXYRCircle {
    int radius;
    int x, y;

    public SameXYRCircle( final int radius ) {
        if ( radius < 0 ) {
            this.radius = -1 * radius;
        } else {
            this.radius = radius;
        }

        x = radius;
        y = radius;
    }

    public double distanceFromCenter( final int x, final int y ) {
        int dx = this.x - x;
        dx = dx * dx;

        int dy = this.y - y;
        dy = dy * dy;

        return Math.sqrt(dx + dy);
    }

    public boolean IsPointInside( final int x, final int y ) {
        double distance = distanceFromCenter(x, y);
        return distance <= (double) this.radius;
    }
}
