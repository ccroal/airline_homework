public enum PlaneType {

    BOEING747(400, 30000),
    BOEING737(300, 20000),
    BOEING777(200, 10000),
    AIRBUSA340(500, 50000),
    CESNA(2, 80);

    private final int capacity;

    private final int weight;

    PlaneType(int capacity, int weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight(){
        return weight;
    }

}
