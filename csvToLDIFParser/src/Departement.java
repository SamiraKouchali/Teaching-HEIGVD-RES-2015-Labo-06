
public class Departement {

    private String nom;

    public Departement(String nom) {
        this.nom = nom;
    }

    public String getName() {
        return nom;
    }

    public String toLdif() {
        StringBuilder s = new StringBuilder();

        /*s.append("dn: uid=" + getId() + ",ou=People,dc=heigvd,dc=ch\n");
        s.append("changetype: add\n");
        s.append("objectClass: top\n");
        s.append("objectClass: person\n");
        s.append("objectClass: organizationalPerson\n");
        s.append("objectClass: inetOrgPerson\n");
        s.append("uid: " + getId() + "\n");
        s.append("givenName: " + getFirstName() + "\n");
        s.append("sn: " + getLastName() + "\n");
        s.append("cn: " + getFirstName() + " " + getLastName() + "\n");
        s.append("mail: " + getEmail() + "\n");
        s.append("phone:" + getPhone() + "\n");
        s.append("departmentNumber: " + department.getName() + "\n");
        s.append("employeeType: " + function + "\n");*/

        return s.toString();
    }

}
