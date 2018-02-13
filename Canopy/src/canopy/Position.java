package canopy;

public class Position {
    public int x;
    public int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Position)) {
            return false;
        } else {
            Position p = (Position)obj;
            return (this.x == p.x) && (this.y == p.y);
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.x) + Integer.hashCode(this.y);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
    
    
}
