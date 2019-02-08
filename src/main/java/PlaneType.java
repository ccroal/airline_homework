public enum PlaneType {

    BOEING747(400),
    BOEING737(300),
    BOEING777(200),
    AIRBUSA340(500),
    CESNA(2);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

}
