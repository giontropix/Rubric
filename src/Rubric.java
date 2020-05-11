import java.io.*;
import java.util.ArrayList;

public class Rubric {
    private ArrayList<User> arrayListContacts = new ArrayList();
    private int counter = 0;
    private char[] letters;

    public void insertUser(User user) {
        arrayListContacts.add(user);
        //arrayListContacts.set(2, user); nel caso in cui si voglia memorizzare l'oggetto in una determinata posizione
    }
    public void insertUser(int position, User user) {
        arrayListContacts.set(position, user);
        writeUser(user);
    }
    

    public int getRubricLength() {
        // arrayContacts.length; in caso di array a dimensione fissa
        return arrayListContacts.size();
    }

    public User getIndex(int index) {
        // arrayContacts[index]; in caso di array a dimensione fissa
        return arrayListContacts.get(index);
    }

    public ArrayList<User> search(String searchField) {
        ArrayList<User> arrayListSearch = new ArrayList();
        for (int i = 0; i < arrayListContacts.size(); i++) {
            if (arrayListContacts.get(i).getName().contains(searchField) ||
                    (arrayListContacts.get(i).getSurname().contains(searchField))) {
                arrayListSearch.add(arrayListContacts.get(i));
            }
        }
        return arrayListSearch;
    }

    public void writeUser(User user) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\giont\\Desktop\\Steve Jobs Academy\\Programmazione\\Rubric\\src\\data.txt", true);
            writer.write("-");
            writer.write(user.getName());
            writer.write(".");
            writer.write(user.getSurname());
            writer.write(".");
            writer.write(user.getPhone());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRubric() {
            try {
                FileWriter writer = new FileWriter("C:\\Users\\giont\\Desktop\\Steve Jobs Academy\\Programmazione\\Rubric\\src\\data.txt", true);
                for (int i = 0; i < arrayListContacts.size(); i++) {
                    writer.write(" ");
                    writer.write(arrayListContacts.get(i).getName());
                    writer.write(".");
                    writer.write(arrayListContacts.get(i).getSurname());
                    writer.write(".");
                    writer.write(arrayListContacts.get(i).getPhone());
                    writer.write("-");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public String readRubric() { //leggiamo la rubrica e ci facciamo tornare una stringa contenente tutta la rubrica
        String result = "";
        String line;
        try {
            FileReader reader = new FileReader("C:\\Users\\giont\\Desktop\\Steve Jobs Academy\\Programmazione\\Rubric\\src\\data.txt");
            BufferedReader buffer = new BufferedReader(reader);
            while ((line = buffer.readLine()) != null) {
                //System.out.println(line);
                result += line;
            }
            reader.close();

        } catch (final IOException e) {
            e.printStackTrace();
        }
        //System.out.println(result);
        return result;
    }

    public void assignToUser(String test) { //scansioniamo la rubrica e dividiamo i contatti appena si incontra il carattere "-"
        String contact;
        for (int i = 0, j = 0; i < test.length(); i++) {
            if(test.charAt(i) == '-') {
                contact = test.substring(j, i);
                j = i;
                insertUser(fromStringToUser(contact)); //appena incontra "-" divide nome, cognome, tel, crea l'user e lo passa al metodo insertUser
            }
        }
    }

    public User fromStringToUser(String test) { //diviso il carattere, dividiamo nome, cognome e telefono e facciamoci restituire un oggetto User
        String name = "";
        String surname = "";
        String phone = "";
        for (int i = 0, j = 1, count = 0; i < test.length(); i++) {
            if(test.charAt(i) == '.') {
                if(count == 0) {
                    //System.out.println("name" + " i:" + i + " j:" + j);
                    name = test.substring(j, i);
                    count++;
                    j = i;
                    continue;
                }
                if(count == 1) {
                    //System.out.println("surname" + " i:" + i + " j:" + j);
                    surname = test.substring(j+1, i);
                    count++;
                    j = i;
                }
                if(count == 2) {
                    phone = test.substring(j+1);
                    //System.out.println("phone" + " i:" + test.length() + " j:" + j);
                }
            }
        }
        return new User(name, surname, phone);
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < arrayListContacts.size(); i++)
        {
            result+="Nome: "+arrayListContacts.get(i).getName()+"\nCognome: "+arrayListContacts.get(i).getSurname()+"\nNum: "+arrayListContacts.get(i).getPhone()+"\n\n";
        }
        return result;
    }
}