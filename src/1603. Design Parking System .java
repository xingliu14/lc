// https://leetcode.com/problems/design-parking-system/
// 龙卷风摧毁停车场

class ParkingSystem {
    
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[3];
        spaces[0] = big;
        spaces[1] = medium;
        spaces[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(spaces[carType - 1] > 0) {
            spaces[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}