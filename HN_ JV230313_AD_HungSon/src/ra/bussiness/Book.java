package ra.bussiness;

import java.util.Scanner;

public class Book {
    private static int nextId = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private Boolean bookStatus=true;

    public Book() {
        this.bookId = nextId++;
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, Boolean bookStatus) {
        this.bookId = nextId++;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = calInterest();
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner,Book[] arrBook){
        System.out.println("Nhập tên sách không được để trống: ");
            while (true){
                bookName = scanner.nextLine().trim();
                if (!bookName.isEmpty()) break;
                System.out.println("Không hợp lệ, Nhập lại tên sách : ");
            }
        System.out.println("Nhập tên tác giả không được để trống: ");
            while (true){
                author = scanner.nextLine().trim();
                if (!author.isEmpty()) break;
                System.out.println("Không hợp lệ , Nhập lại tên tác giả :");
            }
        System.out.println("Nhập mô tả về sách Không được để trống, ít nhất 10 ký tự ");
            while (true){
                descriptions = scanner.nextLine().trim();
                if (!descriptions.isEmpty() && descriptions.length() >=10){
                    break;
                }else {
                    System.out.println("Không hợp lệ , Nhập lại mô tả sách :");
                }
            }
        System.out.println("Nhập giá trị nhập của sách phải lớn hơn 0 : ");
            while (true){
                importPrice = Double.parseDouble(scanner.nextLine());
                if (importPrice>0){
                    break;
                }
                System.out.println("Không hợp lệ , mời nhập lại giá nhập của sách ");
            }
        System.out.println("Nhập giá trị xuất của sách phải lớn hơn 1.2 giá nhập ");
            while (true){
                exportPrice = Double.parseDouble(scanner.nextLine());
                if (exportPrice>importPrice*1.2){
                    break;
                }else {
                    System.out.println("Khong hop le , Nhap lai gia xuat : ");
                }
            }
            this.interest = (float) calInterest();
        System.out.println("Nhập trạng thái sách (true là đang bán , false là không bán");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.println("Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + (bookStatus?"Đang bán":"Chưa bán") +
                '}');
    }

    public double calInterest(){
        return exportPrice - importPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

}
