
package Entity;

public class Options {
    
    private int opId;
    private String opName;
    private String opDate;
    private int opCatId;

    public Options() {
    }

    public Options(int opId, String opName, int opCatId) {
        this.opId = opId;
        this.opName = opName;
        this.opCatId = opCatId;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public String getOpDate() {
        return opDate;
    }

    public int getOpId() {
        return opId;
    }

    public String getOpName() {
        return opName;
    }

    public int getOpCatId() {
        return opCatId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public void setOpCatId(int opCatId) {
        this.opCatId = opCatId;
    }
    
    
    
}
