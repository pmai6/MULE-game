public class River implements Tile {

    private String player;
    public River() {

    }
    public void setOwner(String player) {
        this.player = player;
    }
    public Tile getLocation(Tile[][] tiles) { return tiles[4][3]; }

    public String getOwner() {
        return player;
    }

    public int getCost() {
        return 300;
    }
}
