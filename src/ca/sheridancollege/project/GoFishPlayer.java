/**
 * SYST 17796 Project Winter 2020
 *
 * @author: Group7: Thanveer Hauzaree,Yuxiao Fang,Shuwen Wang,Chen-yu Wu
 * @updateDate: 2020-04-12
 */
package ca.sheridancollege.project;

public class GoFishPlayer extends Player {

    private GoFishHand hand;
    private int id;

    public void play() {
        throw new UnsupportedOperationException();
    }

    public GoFishHand getHand() {
        return this.hand;
    }
    public void setHand(GoFishHand hand) {
        this.hand = hand;
    }

    public GoFishPlayer(String name) {
        super(name);
    }
    public String toString(){
        return this.getPlayerID()+"("+this.id+")";
    }

    public void setId(int id) {
        this.id = id;
    }
     

}
