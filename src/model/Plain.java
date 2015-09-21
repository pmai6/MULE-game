
public class Plain implements Tile {
private String player;


	public void setOwner(String player) {
		this.player = player;
	}

	public Tile getLocation(Tile[][] tiles) { return tiles[6][5]; }

	public String getOwner() {
		return player;
	}

	public int getCost() {
		return 300;
	}
}