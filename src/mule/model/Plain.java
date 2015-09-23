package mule.model;
public class Plain implements Tile {
private Player player;
	private boolean isOwned;



	public void setOwner(Player player) {
		this.player = player;
	}

	public Tile getLocation(Tile[][] tiles) { return tiles[6][5]; }

	public Player getOwner() {
		return player;
	}

	public int getCost() {
		return 300;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setIsOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}


}