public class oops {
    public static void main(String args[]){
        /*Pen p1 = new Pen();
        //System.out.println(p1.color);
        p1.setcolor("blue");
        p1.getcolor();*/
        /*Student s = new Student();
        s.marks[0] = 100;
        s.marks[1] = 98;
        s.marks[2] = 93;
        Student s2 = new Student(s);
        s.marks[0] = 95;
        for(int i =0;i<3;i++){
            System.out.println(s2.marks[i]);
        }*/
        Horse h = new Horse();
        h.eats();




    }
    
}
class Pen{
    Pen(){
        System.out.print("pen called in main fun");
    }
    private String color;
    int tip;
    void setcolor(String newcolor){
        this.color = newcolor;
    }
    void getcolor(){
        System.out.println(this.color);
    }

}
class Student{
    int marks[] ;
    Student(){
        marks = new int[3];
    }
    Student(Student s1){
        //this.marks = s1.marks;
        marks = new int[3];
        for(int i=0;i<3;i++){
            this.marks[i] = s1.marks[i];
        }

    }
}
abstract class Animal{
    Animal(){
        System.out.println("animal calles");
    }
    abstract void eats();
}
class Horse extends Animal{
    void eats(){
        System.out.println("eats grass");
    }
}
class Lion extends Animal{
    void eats(){
        System.out.println("eats nonv");
    }
}
