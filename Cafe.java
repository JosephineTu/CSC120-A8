/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    // attributes
    int nCoffeeounces=10;
    int nSugarPackets=5;
    int nCreams=5;
    int nCups=5;
    /**constructor
     * @param String name, String address, int nFloors
     */
    public Cafe(String name, String address, int nFloors) {
        super(name,address,nFloors);
        System.out.println("You have built a cafe: ☕");
    }
    /** restock(), customize restock amounts
     * @param int nCoffeeounces, int nSugarPackets, int nCreams, int nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeounces+=nCoffeeOunces;
        this.nSugarPackets+=nSugarPackets;
        this.nCreams+=nCreams;
        this.nCups+=nCups;
    }
    /**
     * overloaded restock(), used when there is no specific coffee requirements
     * @param none
     * @return none
     */
    private void restock(){
        this.nCoffeeounces=10;
        this.nSugarPackets=5;
        this.nCreams=5;
        this.nCups=5;
    }
    /** 
     * sellCoffee()
     * @param int size, int nSugarPackets, int nCreams
     */
     public void sellCoffee(int size, int nSugarPackets,int nCreams){
        // restock only the item that goes below 0
        if((this.nCoffeeounces-=size)<0){
            this.restock(2*size,0,0,0);
        }
        if((this.nSugarPackets-=nSugarPackets)<0){
            this.restock(0, 2*nSugarPackets, 0, 0);
        }
        if((this.nCreams-=nCreams)<0){
            this.restock(0,0,nCreams*2,0);
        }    
        if((this.nCups==0)){
            this.restock(0,0,0,10);
        }
        // update the value
        this.nCoffeeounces-=size;
        this.nSugarPackets-=nSugarPackets;
        this.nCreams-=nCreams;
        this.nCups-=1;
        System.out.println("Your "+size+" oz coffee with "+nSugarPackets+" sugar and "+nCreams+" cream is made!");
    }
    /**
     * overloaded sellCoffee(), sells a default cup of coffee when there is no user input
     * @param none
     * @return none
     */
    public void sellCoffee(){
        if((this.nCoffeeounces-=3)<0){
            this.restock();
        }
        if((this.nSugarPackets-=1)<0){
            this.restock();
        }
        if((this.nCreams-=1)<0){
            this.restock();
        }    
        if((this.nCups==0)){
            this.restock();
        }
        this.nCoffeeounces-=3;
        this.nSugarPackets-=1;
        this.nCreams-=1;
        this.nCups-=1;
        System.out.println("Your "+ 3 +" oz coffee with "+ 1 +" sugar and "+ 1 +" cream is made!");
    }
    /**
     * overriden showOptions, contain methods local to the Cafe class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()");
    }
    /**
     * overriden method goToFloor(), customers cannot go to floors other than 1
     * @param int floorNum
     * @return none
     */
    public void goToFloor(int floorNum){
        if(floorNum!=1){
            throw new RuntimeException("You are not authorized to go to other floors.");
        }
    }
    public static void main(String[] args) {
        Cafe ccCafe=new Cafe("ccCafe","1 Chapin Way",1);
        ccCafe.sellCoffee(3,1,1);
    }
    
  }
