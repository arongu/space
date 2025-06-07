package aron.app;

// d(c,p) = sqrt( (cx-px)pow2 + (cy-py)pow2 );
public class SameXYRCircle {
    private final int r, x, y;

    public SameXYRCircle( final int r ) {
        if ( r < 0 ) {
            this.r = -1 * r;
        } else {
            this.r = r;
        }

        x = r;
        y = r;
    }

    public double distanceFromCenter( final int x, final int y ) {
        int dx = this.x - x;
        dx = dx * dx;

        int dy = this.y - y;
        dy = dy * dy;

        return Math.sqrt(dx + dy);
    }

    public boolean isPointInside( final int x, final int y ) {
        double distance = distanceFromCenter(x, y);
        return distance <= (double) this.r;
    }
}
