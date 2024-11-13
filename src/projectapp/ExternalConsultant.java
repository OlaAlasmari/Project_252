package projectapp;

public class ExternalConsultant implements Consultant {

     private String name;
    private String email;
    private String PhoneNumber;

    @Override
    public Consultant makeCopy() {
        return new ExternalConsultant();
    }

    @Override
    public void addConsultantDetails(String name, String email, String PhoneNumber) {
        this.name = name;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        System.out.println("Work friend added: " + name);
    }
}
