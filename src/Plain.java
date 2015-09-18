public class Plain implements Tile {

	public void setOwner(String player) {
		player = "travis";
	}

	public Tile getLocation(Tile[][] tiles) { return tiles[6][5]; }
}