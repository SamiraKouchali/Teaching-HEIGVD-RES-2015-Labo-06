
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVtoLDIF {

    public void csvToLDIF(String csvFileName) throws UnsupportedEncodingException {
        Map<String, Departement> departements = new HashMap<>();

        BufferedReader is = null;
        BufferedWriter osDepartments = null;
        BufferedWriter osPersons = null;

        try {
            is = new BufferedReader(new InputStreamReader(new FileInputStream(new File(csvFileName)), "UTF-8"));

            // Lecture des personnes et des départements
            String line = null;
            String[] person = null;

            // Ecriture du fichier person.ldif
            osPersons = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("people.ldif")), "UTF-8"));

            while ((line = is.readLine()) != null) {
                // Parsing de la ligne
                person = line.split(",");

                Departement department = departements.get(person[6]);

                if (department == null) {
                    department = new Departement(person[6]);
                    departements.put(person[6], department);
                }

                Person p = new Person(person[0], person[2], person[1], null, department, person[7], person[4], person[3]);
                
                osPersons.write(p.toLdif() + "\n");
                osPersons.flush();
            }
            
            // Ecriture du fichier des département (departments.ldif)
            osDepartments = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("departments.ldif")), "UTF-8"));
            
            for (String key : departements.keySet())
                osDepartments.write(departements.get(key).toLdif() + "\n");
            osDepartments.flush();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVtoLDIF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVtoLDIF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
                osPersons.close();
                osDepartments.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVtoLDIF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String... args) {
        try {
            new CSVtoLDIF().csvToLDIF("users.csv");
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
