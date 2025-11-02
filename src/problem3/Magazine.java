package problem3;

public class Magazine extends Document {
    private String month;
    private int year;

    public Magazine(String title, String month, int year) {
        super(title);
        this.month = month;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Magazine [numRec=" + getNumRec() + ", title=" + getTitle() +
                ", month=" + month + ", year=" + year + "]";
    }
}
