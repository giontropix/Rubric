public class Main {
    public static void main (String[] args) {
        User u1 = new User("Pippo", "Fallica", "0957125889");
        User u2 = new User("Paolo", "Fichera", "134654313");
        User u3 = new User("Maurizio", "Ercolano", "65465436465");
        Rubric r = new Rubric();
        //r.insertUser(u1);
        //r.insertUser(u2);
        //r.insertUser(u3);
        //r.writeUser(u1);
        //r.writeRubric();
        //r.readRubric();
        //r.readUser();
        //r.readUserChar();
        r.assignToUser(r.readRubric());
        System.out.println(r.toString());
        System.out.println(r.getRubricLength());
    }
}
