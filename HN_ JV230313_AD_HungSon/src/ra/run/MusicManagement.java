package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Iterator;
import java.util.Scanner;


public class MusicManagement {
    private static Song[] songs = new Song[100];
    private static Singer[] singers = new Singer[100];

    private static int length =0;
    private static int length1 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1. Quản lý ca sĩ [20 điểm]\n" +
                    "2. Quản lý bài hát [20 điểm]\n" +
                    "3. Tìm kiếm bài hát [25 điểm]\n" +
                    "4. Thoát [5 điểm");
            System.out.println("Chọn chức năng : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:managerSinger();
                break;
                case 2:managerSong();;
                break;
                case 3:
                    managerSearch();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    public static void managerSinger(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("**********************SINGER-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữliệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ\n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id\n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)\n" +
                    "5.Thoát");
            System.out.println("Chọn chức năng : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Muốn nhập vào mấy ca sĩ cần thêm");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Singer singer = new Singer();
                        singer.inputDataSinger(scanner);
                        singers[length++]=singer;

                    }
                    break;
                case 2:
                    for (int i = 0; i < length; i++) {
                        singers[i].displaySinger();
                    }
                    break;
                case 3:
                    System.out.println("Nhập id muốn sửa");
                    int idEdit= Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < length; i++) {
                        if (singers[i].getSingerId() == idEdit){
                            singers[i].inputDataSinger(scanner);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập id xóa");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    int index=-1;
                    for (int i = 0; i < length; i++) {
                        if (singers[i].getSingerId()==idDelete){
                            index=i;
                        }

                    }
                    if (index != -1){
                        for (int i = 0; i < length -1 ; i++) {
                            singers[i]=singers[i+1];
                        }
                        length--;
                        System.out.println("Đã xóa ca sĩ có id" +idDelete);
                    }else {
                        System.out.println("Không ti thấy ca sĩ có id " +idDelete);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ. Nhập lại");
            }

        }
    }

    public static void managerSong(){
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("**********************SONG-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữliệu nhập vào)\n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ\n" +
                    "3.Thay đổi thông tin bài hát theo mã id\n" +
                    "4.Xóa bài hát theo mã id\n" +
                    "5.Thoát");
            System.out.println("Chọn chức năng : " );
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Muốn nhập vào mấy bài hát cần thêm");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Song song = new Song();
                        song.inputDataSong(scanner,singers,length);
                        songs[length1++]=song;

                    }
                    break;
                case 2:
                    for (int i = 0; i < length1; i++) {
                        songs[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã muốn sửa");
                    String idEdit= scanner.nextLine();
                    for (int i = 0; i < length1; i++) {
                        if (songs[i].getSongId().equals(idEdit)){
                            songs[i].inputDataSong(scanner,singers,length);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã xóa");
                    String idDelete = scanner.nextLine();
                    int index=-1;
                    for (int i = 0; i < length1; i++) {
                        if (songs[i].getSongId().equals(idDelete)){
                            index=i;
                        }

                    }
                    if (index != -1){
                        for (int i = 0; i < length1 -1 ; i++) {
                            songs[i]=songs[i+1];
                        }
                        length1--;
                        System.out.println("Đã xóa bài hát có id" +idDelete);
                    }else {
                        System.out.println("Không tim thấy bai hat có id " +idDelete);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ. Nhập lại");
            }
        }
    }
    public static void managerSearch(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("*********************SEARCH-MANAGEMENT************************\n" +
                    "1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại . [5 điểm]\n" +
                    "2.Tìm kiếm ca sĩ theo tên hoặc thể loại [5 điểm]\n" +
                    "3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần [5 điểm]\n" +
                    "4.Hiển thị 10 bài hát được đăng mới nhất [10 điểm]\n" +
                    "5.Thoát");
            System.out.println("Chọn chức năng : " );
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập tên ca sĩ hoặc thể loại bài hát:");
                    String input = scanner.nextLine();
                    for (int i = 0; i < songs.length; i++) {
                        if (songs[i] != null && (songs[i].getSinger().getSingerName().equalsIgnoreCase(input) || songs[i].getSinger().getGenre().equalsIgnoreCase(input))) {
                            songs[i].displayData();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên ca sĩ theo tên hoặc thể loại bài hát : ");
                    String input1 = scanner.nextLine();
                    for (int i = 0; i < singers.length; i++) {
                        if (singers[i]!=null && (singers[i].getSingerName().equalsIgnoreCase(input1)) || singers[i].getGenre().equalsIgnoreCase(input1)){
                            singers[i].displaySinger();
                        }
                    }
                case 3:
                    for (int i = 0; i < songs.length - 1; i++) {
                        for (int j = i + 1; j < songs.length; j++) {
                            if (songs[i] != null && songs[j] != null && songs[i].getSongName().compareTo(songs[j].getSongName()) > 0) {
                                Song temp = songs[i];
                                songs[i] = songs[j];
                                songs[j] = temp;
                            }
                        }
                    }
                    for (Song song : songs) {
                        if (song != null) {
                            song.displayData();
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < songs.length - 1; i++) {
                        for (int j = i + 1; j < songs.length; j++) {
                            if (songs[i] != null && songs[j] != null && songs[i].getCreatedDate().before(songs[j].getCreatedDate())) {
                                Song temp = songs[i];
                                songs[i] = songs[j];
                                songs[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < 10 && songs[i] != null; i++) {
                        songs[i].displayData();
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chức năng ko hợp lệ ,Nhập lại ");
            }
        }

    }
}
