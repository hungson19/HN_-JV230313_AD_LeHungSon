package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    private static Book[] books = new Book[100];
    private static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách [15 điểm]\n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện [15 điểm]\n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần [15 điểm]\n" +
                    "4. Xóa sách theo mã sách [10 điểm]\n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả [10 điểm]\n" +
                    "6. Thay đổi thông tin sách theo mã sách [10 điểm]\n7. Thoát [05 điểm]\n");
            System.out.println("Lựa chọn chức năng : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập số lượng sách muốn thêm : ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Book book = new Book();
                        book.inputData(scanner, books);
                        books[bookCount] = book;
                        bookCount++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < bookCount; i++) {
                        books[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i <bookCount; i++) {
                        for (int j = 0; j < bookCount-i-1; j++) {
                            if (books[i].calInterest()<books[j+1].calInterest()){
                                Book temp = books[j];
                                books[j]=books[j+1];
                                books[j+1]=temp;
                            }
                        }
                    }
                    for (int i = 0; i < bookCount; i++) {
                        books[i].displayData();
                    }
                    break;

                case 4:
                    System.out.println("Nhập mã sách muốn xóa : ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    int indexToDelete = -1;
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == deleteId) {
                            indexToDelete = i;
                            break;
                        }
                    }
                    if (indexToDelete != -1) {
                        //đẩy cuốn sách xóa lên 1 vị trí
                        for (int i = indexToDelete; i < bookCount - 1; i++) {
                            books[i] = books[i + 1];
                        }
                        bookCount--;
                        // cập nhật lại bookId cuon sach
                        for (int i = 0; i < bookCount; i++) {
                            books[i].setBookId(i + 1);
                        }
                        System.out.println("Đã xóa sách có mã " + deleteId);
                    } else {
                        System.out.println("Không tìm thấy sách có mã " + deleteId);
                    }
                    break;
                case 5:
                    System.out.println("Nhập tương đối theo tên sách hoặc mô tả");
                    String search = scanner.nextLine();
                    boolean check = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookName().contains(search)||books[i].getDescriptions().contains(search)){
                            books[i].displayData();
                            check=true;
                        }
                    }
                    if (!check){
                        System.out.println("Không tim thay sách phu hop voi tu khoa");
                    }
                    break;
                case 6:
                    System.out.println("Nhập mã sách muốn thay đổi thông tin: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    boolean found = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getBookId() == updateId) {
                            System.out.println("Nhập thông tin mới cho sách: ");
                            books[i].inputData(scanner, books);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách với mã sách đã nhập.");
                    }
                    break;
                case 7 :
                    System.exit(0);
                    break;
            }
        }
    }
}
