import java.util.*;

public class seatBookingUsingHashMaps {
    static Scanner sc = new Scanner(System.in);
    HashMap<String, ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();

    public static void main(String args[]) {

        int rows = 5;
        int columns  = 6;
        int temp;
        int tempData;

        final HashMap<Integer, ArrayList<Integer>> originalPattern = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> myDesign = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> solidPattern = new HashMap<>();


        xyz(originalPattern);
        xyz(myDesign);
        solidPattern = myDesign;

        for(int j = 1; j < 6 ; j++)
        {
            for(int mm = 0 ; mm < 6 ; mm++)
            {
                System.out.print(originalPattern.get(j).get(mm)+"\t");
            }
            System.out.println();
        }


        char choice;
        do{
            int conditionFlag = 0;
            do{
                System.out.println("Enter choice\n" +
                        "T : displaySeatInfo\n" +
                        "S : seatBooking\n" +
                        "E : editSeatNumber\n" +
                        "X : Exit\n");
                choice = sc.next().charAt(0);

                switch(choice) {
                    case 'T':
                        display(originalPattern);
                        break;
                    case 'S':
                        int nRow = 0;
                        int nColumn = 0;
                        nRow = rowInput();
                        nColumn = colInput() - 1;
                        tempData = solidPattern.get(nRow).get(nColumn);
                        if (tempData == 30 || tempData == 20 || tempData == 10) {
                            conditionFlag = 1;
                            solidPattern.get(nRow).set(nColumn, 0);
                        } else {
                            System.out.println("Seat Already Booked !");
                        }
                        display(solidPattern);
                        break;
                case 'E' :
                        if(conditionFlag < 1)
                        {
                            System.out.println("No ticket history found !");
                        }
                        else
                        {
                            nRow = rowInput();
                            nColumn = colInput() - 1;
                            temp = originalPattern.get(nRow).get(nColumn);
                            int tempCurrent = myDesign.get(nRow).get(nColumn);
                            if( tempCurrent == 30 || tempCurrent == 20 || tempCurrent == 10 )
                            {
                                System.out.println("No seat found !!");
                            }
                            else
                            {
                                myDesign.get(nRow).set(nColumn, temp);
                            }
                        }
                        display(myDesign);

                    case 'X':
                        break;
                    default:
                        System.out.println("Invalid Selection. Please Try Again !");
                }
            }while(choice != 'X');
        }while(choice != 'X');
    }

    private static void xyz(HashMap<Integer, ArrayList<Integer>> myDesign) {
        myDesign.put(1, new ArrayList<Integer>(Arrays.asList(30,30,30,30,30,30)));
        myDesign.put(2, new ArrayList<Integer>(Arrays.asList(10,10,10,10,10,10)));
        myDesign.put(3, new ArrayList<Integer>(Arrays.asList(10,10,10,10,10,10)));
        myDesign.put(4, new ArrayList<Integer>(Arrays.asList(10,10,20,20,20,20)));
        myDesign.put(5, new ArrayList<Integer>(Arrays.asList(10,10,20,20,20,20)));
    }

    public static int[][] createPattern(HashMap<Integer, ArrayList<Integer>> map, int rows, int columns)
    {
        HashMap<Integer, ArrayList<Integer>> myPattern = map;
        int i = 1;
        int[][] myArray = new int[rows][columns];

        ArrayList<Integer> listOfLists;
        Integer listOfIntArrays = null;

        int count = 1;
        int j = 0;

        do
        {
            listOfLists = myPattern.get(i);
            for(int mm = 0 ; mm < listOfLists.size() ; mm++)
            {
                listOfIntArrays = listOfLists.get(mm);
                myArray[j][mm] = listOfIntArrays;
            }
            j++;
            i++;
        }while( j < 5);
        return myArray;
    }

    public static int rowInput()
    {
        int nRow ;
        do{
            System.out.println("Enter the row :");
            nRow = sc.nextInt();
            if(nRow > 5 || nRow < 1)
            {
                System.out.println(" Please enter the value between 1 to 5");
            }
        }while(nRow > 5 || nRow < 1);
        return nRow;
    }

    public static int colInput()
    {
        int nColumn = 1;
        do{
            System.out.println("Enter the Column :");
            nColumn = sc.nextInt();

            if(nColumn > 6 || nColumn < 1)
            {
                System.out.println(" Please enter the value between 1 to 6");
            }
        }while(nColumn > 6 || nColumn < 1);
        return nColumn;
    }
    public static void display(HashMap<Integer, ArrayList<Integer>> myPattern)
    {
        for(int j = 1; j < 6 ; j++)
        {
            for(int mm = 0 ; mm < 6 ; mm++)
            {
                System.out.print(myPattern.get(j).get(mm)+"\t");
            }
            System.out.println();
        }
    }
}