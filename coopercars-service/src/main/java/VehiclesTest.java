public class VehiclesTest
{
    public static void main (String[] args) throws Exception
    {
        String[] theArgs = null;
        VehiclesDataBuilder builder = new VehiclesDataBuilder();
        builder.main(theArgs);

        VehiclesDataReader reader = new VehiclesDataReader();
        reader.main(theArgs);


    }
}
