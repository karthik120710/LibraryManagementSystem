package Entity;

public class Librarian extends  Member{
    private String personalId;
    public Librarian(String name,String id){
        super(name,id);
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}
