//Kevin Elfert
public class ISTester
{
    public static void main(String[] args)
    {
        IntegerSet iS1 = new IntegerSet();
        //testing add
        System.out.println("Adding 5 to iS1: "+ iS1.add(5));//should be true
        System.out.println("Adding 3 to iS1: "+ iS1.add(3));//should be true
        System.out.println("Adding 3 to iS1: "+ iS1.add(3));//should be false
        System.out.println("Adding 1 to iS1: "+ iS1.add(1));//should be true
        System.out.println("Adding 4 to iS1: "+ iS1.add(4));//should be true
        System.out.println("Adding 8 to iS1: "+ iS1.add(8));//should be true
        System.out.println("Adding 6 to iS1: "+ iS1.add(6));//should be true
        System.out.print("iS1: " + iS1.toString(iS1.getRoot()));
        System.out.println();
        //should print "iS1: 1 3 4 5 6 8"

        //testing contains
        System.out.println("iS1 contains 3: "+ iS1.contains(3));//should be true
        System.out.println("iS1 contains 7: "+ iS1.contains(7));//should be false
        
        IntegerSet iS2 = new IntegerSet();
        iS2.add(5);
        iS2.add(3);
        iS2.add(4);
        iS2.add(6);
        iS2.add(7);
        System.out.println("iS2: " + iS2.toString(iS2.getRoot()));
        //should print "iS2: 3 4 5 6 7"


        //test intersection
        IntegerSet iS3 = iS1.intersection(iS2);
        System.out.println("iS1 intersection iS2: " + iS3.toString(iS3.getRoot()));
        //should print "iS1 intersection iS2: 3 4 5 6"

        //test union
        IntegerSet iS4 = iS1.union(iS2);
        System.out.println("iS1 union iS2: " + iS4.toString(iS4.getRoot()));
        //should print "iS1 union iS2: 1 7 8"

        //test magnitude
        System.out.println("iS1 magnitude: " + iS1.magnitude());//should be 6
        System.out.println("iS2 magnitude: " + iS2.magnitude());//should be 5
        System.out.println("iS1 intersection iS2 magnitude: " + iS3.magnitude());//should be 4
        System.out.println("iS1 union iS2 magnitude: " + iS4.magnitude());//should be 3


    }
}