package entity;

public class Inventory {
    public int flowerCount;

    public Inventory() {
        flowerCount = 0;
    }

    public int getFlowerCount() {
        return flowerCount;
    }

    public void addFlower() {
        flowerCount = flowerCount + 1;
    }
}