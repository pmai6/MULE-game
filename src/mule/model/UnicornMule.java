package mule.model;

/**
 * Created by redcream12 on 10/20/15.
 */
public class UnicornMule implements Mule{
        private Player player;
        private boolean isOwned;
        private static  Tile tile;

        public UnicornMule() {

        }

        public void setOwner(Player player) {
            this.player = player;
        }
        public Tile getLocation(Tile tile) { return tile; }

        public void setLocation(Tile tile) {
            UnicornMule.tile = tile; }

        public Player getOwner() {
            return player;
        }

        public int getCost() {
            return 700;
        }

        public boolean isOwned() {
            return isOwned;
        }

        public void setIsOwned(boolean isOwned) {
            this.isOwned = isOwned;
        }

    }

