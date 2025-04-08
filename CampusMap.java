import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        // add a House with the overloaded House constructor
        House washburn=new House("Washburn","3 Green Street");
        // test that default value for hasElevator and nFloors have been applied
        System.out.println(washburn.toString());
        // add a House with the full House constructor
        House hubbard=new House("Hubbard","3 Green Street", 4,false);
        // test the overriden method goToFloor()
        try{
            hubbard.enter();
            hubbard.goToFloor(4);
        } catch(RuntimeException e){
            hubbard.exit();
        }
        // test the overloaded method moveIn()
        House morrow=new House("Morrow","1 Paradise Road",4,false);
        ArrayList<Student> newstudents=new ArrayList<>();
        Student a=new Student("A","9900xx",2028);
        Student b=new Student("B","9900xx",2028);
        newstudents.add(a);
        newstudents.add(b);
        morrow.moveIn(newstudents);
        System.out.println(morrow.nResidents());
        // add a Library with the overloaded Library constructor
        Library josten=new Library("Joseten","122 Green Street");
        // check the default values
        System.out.println(josten.toString());
        // test the overloaded method addTitle()
        Library neilson=new Library("Neilson","1 Neilson Drive",3);
        ArrayList<String> books = new ArrayList<>();
        books.add("OOP");
        books.add("Operating System");
        books.add("Organic Chemistry I");
        neilson.addTitle(books);
        neilson.printCollection();
        // create a new instance of Cafe
        Cafe ccCafe=new Cafe("CC","1 Chapin Way",1);
        ccCafe.sellCoffee(5,0,0);
        // create a new instance of Cafe
        Cafe compass=new Cafe("Compass","1 Neilson Drive",1);
        //test overloaded method sellCoffee()
        compass.sellCoffee();
        // test overloaded method goDown() in Builing
        Building sabinReed = new Building("Sabin Reed","44 College Lane",4);
        sabinReed.enter();
        sabinReed.goDown(true);
        myMap.addBuilding(washburn);
        myMap.addBuilding(hubbard);
        myMap.addBuilding(morrow);
        myMap.addBuilding(neilson);
        myMap.addBuilding(josten);
        myMap.addBuilding(ccCafe);
        myMap.addBuilding(compass);
        myMap.addBuilding(sabinReed);
        System.out.println(myMap);
    }
}