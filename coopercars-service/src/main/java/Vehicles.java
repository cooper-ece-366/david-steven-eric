import java.util.ArrayList;
import java.util.List;

public class Vehicles
{
    // instance variables
    ArrayList<Vehicle> vehicles;

    // constructor
    public Vehicles()
    {
        vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle v)
    {
        vehicles.add(v);
    }

    public void sortByBasePrice()
    {
        for (int j = 1; j < vehicles.size(); j++)
        {
            Vehicle temp = vehicles.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getBasePrice() < vehicles.get(possibleIndex - 1).getBasePrice())
            {
                vehicles.set(possibleIndex,vehicles.get(possibleIndex - 1));
                possibleIndex--;
            }
            vehicles.set(possibleIndex, temp);
        }
    }

    public Vehicle getVehicle(String theVIN)
    {
        for (Vehicle v : vehicles)
            if (v.getVIN().equals(theVIN))
                return v;
        return null;
    }

    public int getBasePrice(String theVIN)
    {
        for (Vehicle v : vehicles)
            if (v.getVIN().equals(theVIN))
                return v.getBasePrice();
        return Integer.MIN_VALUE;
    }

    public String getEnergySource(String theVIN)
    {
        for (Vehicle v : vehicles)
            if (v.getMake().equals(theVIN))
                return v.getFuelTypePrim();
        return null;
    }

    public List<Vehicle> getAllByMake(String make)
    {
        ArrayList<Vehicle> byMake = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getMake().equals(make))
                byMake.add(v);
        return byMake;
    }

    public List<Vehicle> getAllWithinBudget(int low, int high)
    {
        ArrayList<Vehicle> byBudgetBracket = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getBasePrice() >= low && v.getBasePrice() <= high)
                byBudgetBracket.add(v);
        return byBudgetBracket;
    }

    public List<Vehicle> getAllByBodyClass(String type)
    {
        List<Vehicle> byType = new ArrayList<>();
        for (Vehicle v : vehicles)
            if (v.getBodyClass().equals(type))
                byType.add(v);

        return byType;
    }

}

