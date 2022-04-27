class ParkingSystem {

    Map<Integer, Integer> pool = new HashMap<>();
    
    public ParkingSystem(int big, int medium, int small) {
        pool.put(1, big);
        pool.put(2, medium);
        pool.put(3, small);
    }
    
    public boolean addCar(int carType) {
        if(pool.get(carType) != 0){
            pool.put(carType, pool.get(carType) -  1);
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */