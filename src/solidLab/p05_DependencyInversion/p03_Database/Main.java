package solidLab.p05_DependencyInversion.p03_Database;

public class Main {
    public static void main(String[] args) {
        Courses courses = new Courses(new Data());
        courses.printAll();
        courses.printIds();
        courses.printById(1);
        courses.search("some substring");
    }
}
