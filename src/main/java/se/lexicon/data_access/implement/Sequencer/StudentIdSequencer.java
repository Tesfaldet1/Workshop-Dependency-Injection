package se.lexicon.data_access.implement.Sequencer;

public class StudentIdSequencer {
    private static int sequencer =100;
    public static  int nextId(){
        return ++sequencer;
    }
}
