
package Entity;

public class Users_Options {
  
    private int uoIdUser;
    private int uoIdOption;
    private int uoIdchoice;
    private boolean isVoted;

    public Users_Options() {
    }

    public Users_Options(int uoIdUser, int uoIdOption, int uoIdchoice, boolean isVoted) {
        this.uoIdUser = uoIdUser;
        this.uoIdOption = uoIdOption;
        this.uoIdchoice = uoIdchoice;
        this.isVoted = isVoted;
    }

    public int getUoIdchoice() {
        return uoIdchoice;
    }

    public void setUoIdchoice(int uoIdchoice) {
        this.uoIdchoice = uoIdchoice;
    }

   

    public int getUoIdUser() {
        return uoIdUser;
    }

    public int getUoIdOption() {
        return uoIdOption;
    }

    public boolean isIsVoted() {
        return isVoted;
    }

    public void setUoIdUser(int uoIdUser) {
        this.uoIdUser = uoIdUser;
    }

    public void setUoIdOption(int uoIdOption) {
        this.uoIdOption = uoIdOption;
    }

    public void setIsVoted(boolean isVoted) {
        this.isVoted = isVoted;
    }
    
    
    
}
