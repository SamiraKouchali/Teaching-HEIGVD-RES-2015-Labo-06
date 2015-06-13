/**
 *
 * @author oliechti
 */
public class Person {

    public enum Gender {MALE, FEMALE};
    
    private String id;
    private String firstName;
    private String lastName;
    private Gender sex;
    private Departement department;
    private String function;
    private String email;
    private String phone;
    
    public Person(String id, String firstName, String lastName, Gender sex, Departement department, String function, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.department = department;
        this.function = function;
        this.email = email;
        this.phone = phone;
    }

    public Departement getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getSex() {
        return sex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(id);
        sb.append(", ");
        sb.append(lastName);
        sb.append(", ");
        sb.append(firstName);
        sb.append(", ");
        sb.append(email);
        sb.append(", ");
        sb.append(phone);
        sb.append(", ");
        sb.append(sex);
        sb.append(", ");
        sb.append(department);
        sb.append(", ");
        sb.append(function);
        return sb.toString();
    }   
    
    public String toLdif() {   
        StringBuilder s = new StringBuilder();
        
        s.append("dn: uid=" + getId() + ",ou=People,dc=heigvd,dc=ch\n");
        // Non valide avec le serveur LDAP du labo
        //s.append("changetype: add\n");
        s.append("objectClass: top\n");
        s.append("objectClass: person\n");
        s.append("objectClass: organizationalPerson\n");
        s.append("objectClass: inetOrgPerson\n");
        s.append("uid: " + getId() + "\n");
        s.append("givenName: " + getFirstName() + "\n");
        s.append("sn: " + getLastName() + "\n");
        s.append("cn: " + getFirstName() + " " + getLastName() + "\n");
        s.append("mail: " + getEmail() + "\n");
        s.append("homePhone:" + getPhone() + "\n");
        s.append("departmentNumber: " + department.getName() + "\n");
        s.append("employeeType: " + function + "\n");
        
        return s.toString();
    }
}
