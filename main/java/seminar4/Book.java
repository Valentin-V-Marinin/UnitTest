package seminar4;

public class Book implements Comparable<Book> {
    private String id;
    private String title;
    private String author;

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Book o) {
        if ( (this.id).equals(o.id)
                && (this.title).equals(o.title)
                && (this.author).equals(o.author)
            ) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
