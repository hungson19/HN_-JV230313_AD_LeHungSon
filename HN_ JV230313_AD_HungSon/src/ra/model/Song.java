package ra.model;
import java.util.Date;
import java.util.Scanner;



public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        this.createdDate = new Date();
    }

    public void inputDataSong(Scanner scanner,Singer[] singers,int length) {
        System.out.println("Nhập mã bài hát (4 ký tự, bắt đầu bằng 'S'): ");
        while (true){
            songId=scanner.nextLine();
            if (songId.startsWith("S") && songId.length()==4){
                break;
            }
            System.out.println("Nhập lại do khong hop  le");
        }
        System.out.println("Nhập tên bài hát (không được để trống): ");
        while (true) {

            this.songName = scanner.nextLine();
            if (!this.songName.isEmpty()) {
                break;
            }
            System.out.println("Tên bài hát không hợp lệ. Hãy nhập lại.");
        }

        System.out.println("Nhập mô tả bài hát: ");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập tên người sáng tác (không được để trống): ");
        while (true) {

            this.songWriter = scanner.nextLine();
            if (!this.songWriter.isEmpty()) {
                break;
            }
            System.out.println("Tên người sáng tác không hợp lệ. Hãy nhập lại.");
        }

        System.out.println("Nhập trạng thái bài hát (true = đang phát, false = không phát): ");
        this.songStatus = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Chọn ca sĩ từ danh sách sau:");
        for (int i = 0; i < length; i++) {
            if (singers[i] != null) {
                System.out.println((i + 1) + ". " + singers[i].getSingerName());
            }
        }
        int singerChoice = Integer.parseInt(scanner.nextLine());
        this.singer = singers[singerChoice - 1];

    }



    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Đang phát" : "Không phát"));
        System.out.println("Ca sĩ trình bày: " + singer.getSingerName());
    }

    public String getSongId() {
        return songId;
    }


    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
}
