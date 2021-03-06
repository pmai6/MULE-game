package mule.model;

import mule.PlayerManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grass implements Tile {

	private Player player;
	private boolean isOwned;
	private boolean hasMule;
	private List<Mule> mules = new ArrayList<>();

	public Grass() {

	}
	public void setOwner(Player player) {
		this.player = player;
	}
	public Tile getLocation(Tile[][] tiles) { return tiles[2][4]; }

	public Player getOwner() {
		return player;
	}

	public int getCost() {
		return 666;
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
			if (currentMule instanceof FoodMule) {
				PlayerManager.addPlayerFood(this.getOwner(), 4);
			} else if (currentMule instanceof EnergyMule) {
				PlayerManager.addPlayerEnergy(this.getOwner(), 5);
			} else if (currentMule instanceof SmithoreMule) {
				PlayerManager.addPlayerSmithore(this.getOwner(), 5);
			} else if (currentMule instanceof WineMule) {
				PlayerManager.addPlayerFood(this.getOwner(), 2);
			} else if (currentMule instanceof SantaMule) {
				PlayerManager.addPlayerFood(this.getOwner(), 2);
				PlayerManager.addPlayerEnergy(this.getOwner(), 1);
				PlayerManager.addPlayerCrystite(this.getOwner(), 3);
			} else if (currentMule instanceof CombatMule) {
				PlayerManager.addPlayerEnergy(this.getOwner(), 2);
				PlayerManager.addPlayerSmithore(this.getOwner(), 2);
			} else if (currentMule instanceof UnicornMule) {
				PlayerManager.addPlayerFood(this.getOwner(), 4);
				PlayerManager.addPlayerEnergy(this.getOwner(), 1);
			}
		}

	}

	public boolean hasMule() {
		return hasMule;
	}

	public void setHasMule(boolean hasMule) {
		this.hasMule = hasMule;
	}
}