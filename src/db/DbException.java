package db;

public class DbException extends RuntimeException {

    private static final long serialVersionsUID = 1l;

    public DbException(String txt){
        super(txt);
    }

}
