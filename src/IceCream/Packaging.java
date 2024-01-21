package IceCream;

public enum Packaging {
    SingleScoopCone(1),// single scoop ice cream cone with 1 scoop
    DoubleScoopCone(2),// double scoop ice cream one with 2 scoops
    SmallCup(4),       // small ice cream cup with 4 scoops
    MediumCup(6),      // medium ice cream cup with 6 scoops
    LargeCup(8);       // 8 scoops cup

    private final int scoops; // Scoops a cup can hold

    Packaging(int scoops) {
        this.scoops = scoops;
    }

    // Return the number of scoops a cup can hold
    public int getScoops() {
        return scoops;
    }

    public boolean canAddScoop(int currentScoops, int newScoops) {
        System.out.print(currentScoops+newScoops);
        System.out.print(scoops);
        return (currentScoops + newScoops) <= scoops;
    }
}