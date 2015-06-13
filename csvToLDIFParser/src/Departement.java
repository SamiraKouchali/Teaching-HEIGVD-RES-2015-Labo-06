
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

        s.append("dn: uid=" + nom + ",ou=Department,dc=heigvd,dc=ch\n");
        s.append("objectClass: top\n");
        // Non valide avec le serveur LDAP du labo
        //s.append("changetype: add\n");
        s.append("uid: " + nom + "\n");

        return s.toString();
    }

}
