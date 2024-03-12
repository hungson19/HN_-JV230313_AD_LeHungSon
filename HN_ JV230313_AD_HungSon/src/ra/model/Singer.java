package ra.model;

import java.util.Scanner;

public class Singer {
    private static int nextId = 1;
    private int singerId ;
    private  String singerName ;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre ;

    public Singer() {
        this.singerId=nextId++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = nextId++;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }


    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputDataSinger(Scanner scanner){
        System.out.println("Nhập tên ca sĩ không được để trống  ");
        while (true){
            singerName = scanner.nextLine();
            if (!singerName.isEmpty()) break;
            System.out.println("Không hợp lệ , Nhập lại tên ca sĩ :");
        }
        System.out.println("Nhập tuổi");
        while (true){
            age = Integer.parseInt(scanner.nextLine());
            if (age>0){
                break;
            }else {
                System.out.println("Không hợp lệ , Nhập lại tuổi");
            }
        }
        System.out.println("Nhập quốc tịch ca sĩ : ");
        while (true){
            nationality = scanner.nextLine();
            if (!nationality.isEmpty()) break;
            System.out.println("Không hợp lệ , Nhập lại quốc tịch");
        }
        System.out.println("Giới tính true là nam , false là nữ");
        gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Nhập thể loại");
        while (true){
            genre = scanner.nextLine();
            if (!genre.isEmpty()) break;
            System.out.println("Không hợp le, Nhâp lai the loai");
        }


    }
    public void displaySinger(){
        System.out.println("Singer{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", gender=" + (gender?"Nam":"Nữ") +
                ", genre='" + genre + '\'' +
                '}');
    }

}
