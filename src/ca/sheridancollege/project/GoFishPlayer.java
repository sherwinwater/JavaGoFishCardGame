/**
 * SYST 17796 Project Winter 2019 Base code.
 * @Modifier: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
package ca.sheridancollege.project;

public class GoFishPlayer extends Player {

    private GoFishHand hand;

    /**
     * The method to be instantiated when you subclass the Player class with
     * your specific type of Player and filled in with logic to play your game.
     */
    public void play() {
        // TODO - implement GoFishPlayer.play
        throw new UnsupportedOperationException();
    }

    public GoFishHand getHand() {
        return this.hand;
    }

    /**
     *
     * @param hand
     */
    public void setHand(GoFishHand hand) {
        this.hand = hand;
    }

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public void Player(String name) {
        // TODO - implement GoFishPlayer.Player
    }

    /**
     *
     * @param name
     */
    public GoFishPlayer(String name) {
        // TODO - implement GoFishPlayer.GoFishPlayer
        super(name);
    }

}
