package projectapp;

public interface Consultant extends Cloneable {

    Consultant makeCopy();
    void addConsultantDetails(String name, String email, String PhoneNumber);
}
