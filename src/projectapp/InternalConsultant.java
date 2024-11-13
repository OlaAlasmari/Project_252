package projectapp;

public class InternalConsultant implements Consultant {

    private String name;
    private String email;
    private String PhoneNumber;

    @Override
    public Consultant makeCopy() {
        return new InternalConsultant();
    }

    @Override
    public void addConsultantDetails(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        System.out.println("Close friend added: " + name);
    }
}
