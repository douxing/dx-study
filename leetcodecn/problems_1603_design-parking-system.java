class ParkingSystem {
    int[] c;

    public ParkingSystem(int big, int medium, int small) {
	this.c = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
	return this.c[carType - 1]-- > 0;
    }
}
