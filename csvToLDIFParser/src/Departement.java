
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

        s.append("dn: o=" + nom + ",ou=Departments,dc=heigvd,dc=ch\n");
        s.append("objectClass: top\n");
        s.append("objectClass: organization\n");
        s.append("o: " + nom + "\n");

        return s.toString();
    }

}
