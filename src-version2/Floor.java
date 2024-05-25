public class Floor {
    private final int floor;
    public Floor(int floor) { this.floor = floor; }
    public int getFloor() { return floor; }
    public boolean isUpperThan(Floor floor) {
        return this.floor > floor.getFloor();
    }

    public boolean isLowerThan(Floor floor) {
        return this.floor < floor.getFloor();
    }
    public String toString() {
        return "Floor [floor=" + floor + "]";
    }
    public boolean equals(Object object) {
        if ( ! (object instanceof Floor) ) return false;
        return ((Floor) object).getFloor() == getFloor();
    }
    public int hashCode() { return Integer.valueOf(floor).hashCode(); }
}