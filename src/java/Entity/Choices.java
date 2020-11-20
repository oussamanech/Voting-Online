
package Entity;

public class Choices {
        
    private int chId;
    private int chOpId;
    private String chName;
    private int chPrsntg;

    public Choices() {
    }

    public Choices(int chId, int chOpId, String chName, int chPrsntg) {
        this.chId = chId;
        this.chOpId = chOpId;
        this.chName = chName;
        this.chPrsntg = chPrsntg;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public void setChOpId(int chOpId) {
        this.chOpId = chOpId;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public void setChPrsntg(int chPrsntg) {
        this.chPrsntg = chPrsntg;
    }

    public int getChId() {
        return chId;
    }

    public int getChOpId() {
        return chOpId;
    }

    public String getChName() {
        return chName;
    }

    public int getChPrsntg() {
        return chPrsntg;
    }
    
    
    
 
}
