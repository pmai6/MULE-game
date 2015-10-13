package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Plain implements Tile {
private Player player;
	private boolean isOwned;
	private List<Mule> mules = new ArrayList<>();



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


	public List<Mule> getMule() {
		return mules;
	}

	public void addMule (Mule mule) {
		mules.add(mule);
	}

	public void calculateProduction() {
		List<Mule> mules = this.getMule();
		Iterator<Mule> muleIterator = mules.iterator();
		while(muleIterator.hasNext()) {
			Mule currentMule = muleIterator.next();
			if(currentMule instanceof FoodMule) {
				PlayerManager.addPlayerFood(this.getOwner(), 2);
			}
			else if(currentMule instanceof EnergyMule) {
				PlayerManager.addPlayerEnergy(this.getOwner(),3);
			}
			else if(currentMule instanceof SmithoreMule) {
				PlayerManager.addPlayerSmithore(this.getOwner(),1);
			}

		}

	}


}