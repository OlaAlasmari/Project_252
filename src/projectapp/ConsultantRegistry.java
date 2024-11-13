package projectapp;

import java.util.HashMap;
import java.util.Map;

public class ConsultantRegistry {
    private Map<String, Consultant> consultant = new HashMap<>();

    public ConsultantRegistry() {
        // Register default prototypes for each friend type
        consultant.put("InternalConsultant", (Consultant) new InternalConsultant());
        consultant.put("ExternalConsultant", (Consultant) new ExternalConsultant());
    }

    public Consultant createConsultant(String consultantType) {
        Consultant prototype = consultant.get(consultantType);
        return (prototype != null) ? prototype.makeCopy() : null;
    }
}
