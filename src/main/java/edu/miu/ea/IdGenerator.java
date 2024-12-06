package edu.miu.ea;

public class IdGenerator {
    private static Integer id = 1;

    public static Integer getId() {
        return id++;
    }
}
