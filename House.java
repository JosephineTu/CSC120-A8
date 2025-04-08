/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  // attributes
  public boolean hasDiningRoom; 
  private int nResidents; 
  private ArrayList<Student> students;
  private boolean hasElevator;
  /*
   * overloaded constructor with name, address
   * @param String name, String address, nFloors
   */
   public House(String name,String address){
    this(name,address,4,false);
  }
  /*
   * full constructor
   * @param String name, String address, int nFloors
   */
  public House(String name,String address,int nFloors, boolean hasElevator) {
    super(name,address,nFloors);
    this.hasDiningRoom=true;
    this.students=new ArrayList<>();
    this.nResidents=0;
    this.hasElevator=hasElevator;
    System.out.println("You have built a house: 🏠"); 
  }
  /*
   * hasDiningRoom()
   * @param none
   * @return boolean value
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  /*
   * nResidents()
   * @return int nResidents
   */
  public int nResidents(){
    return this.nResidents;
  }
  /*
   * moveIn(Student s)
   * @param Student s
   */
  public void moveIn(Student s){
    // add new student to the ArrayList
    this.students.add(s);
    // modify residents number
    this.nResidents+=1;
  }
  /* moveOut(Student s)
   * @param Student s
   * @return Student s
   */
  public Student moveOut(Student s){
    // only works if student already in house
    if(this.students.contains(s)){
      this.students.remove(s);
      // modify residents number
      this.nResidents-=1;
      return s;
    } else{
      throw new RuntimeException("Error: student not found.");
    }
  }
  /* isResident(Student s)
   * @param Student s
   * @return boolean value
   */
  public boolean isResident(Student s){
    if(this.students.contains(s)){
      return true;
    } else{
      return false;
    }
  }
  /*
   * overloaded method moveIn(), move in all the students contained in an ArrayList
   * @param ArrayList<Student> students
   * @return none
   */
  public void moveIn(ArrayList<Student> students){
    for(int i=0;i<students.size();i++){
      this.moveIn(students.get(i));
    }
  }
  /*
   * overriden method goToFloor(), check if there is an elevator
   * @param int floorNum
   * @return none
   */
  public void goToFloor(int floorNum){
    // if the house has no elevator, this method only works for adjacent floors
    if(this.hasElevator==false){
      if(!(floorNum==this.activeFloor-1)&&!(floorNum==this.activeFloor+1)){
        throw new RuntimeException("We don't have an elevator. Please go to adjacent floors only.");
      }
    }
    super.goToFloor(floorNum);
  }
  /*
   * overriden showOptions(), added the methods specific to the House class
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + hasDiningRoom()\n + nResidents()\n + moveIn(s)\n + moveOut(s)\n + isResident(s)");
  }
  public static void main(String[] args) {

    House hubbard=new House("Hubbard","3 Green Street",4,false);
    hubbard.enter();
    hubbard.showOptions();
    System.out.println(hubbard.activeFloor);
    hubbard.goToFloor(2);
  }

}