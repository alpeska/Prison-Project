package D_20190305040;

public class GenericsCrimeClass<T> {

    private T crime_code;
    private String crime_name;

    public GenericsCrimeClass(T data) {
        this.crime_code = data;
    }
    public void setCrime_code(T crime_code) {
        this.crime_code = crime_code;
    }
    public T getCrime_code() {
        return this.crime_code;
    }

    public String getCrime_name() {
        return crime_name;
    }

    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }



}
