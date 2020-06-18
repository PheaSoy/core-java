package book;

public class Book {
    double price;

    public void price() {
        if(this.price<=0) throw new BookException();

    }

    public void setPrice(double price) {
        this.price= price;
    }
}
