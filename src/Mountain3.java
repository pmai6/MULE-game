public class Mountain3 implements Tile {

    private String player;
    public Mountain3() {

    }
    public void setOwner(String player) {
        this.player = player;
    }
    public Tile getLocation(Tile[][] tiles) { return tiles[2][4]; }

    public String getOwner() {
        return player;
    }
}