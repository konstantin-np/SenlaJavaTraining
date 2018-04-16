import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Airport
{
	public static void main(String[] args)
	{
		//System.setOut(new java.io.PrintStream(System.out, true, "Cp866"));
		
		Hangar hang1, hang2;
		Plane pln1, pln2, pln3;
		Pilot plt1, plt2, plt3, plt4;
		Flight fl1, fl2;
		
		hang1 = new Hangar(1);
		hang2 = new Hangar(2);
		
		pln1 = new Plane("Bo745", "Boeing");
		pln2 = new Plane("Ar434", "Airbus");
		pln3 = new Plane("Bo544", "Boeing");
		Plane pln4 = new Plane("Bo332", "Boeing");
		
		plt1 = new Pilot("Petrov A.I.");
		plt2 = new Pilot("Ivanov P.K.");
		plt3 = new Pilot("Bazhenov I.B.");
		plt4 = new Pilot("Sergeev N.M.");
		
		DateFormat birthDateFormat = new SimpleDateFormat("MM/dd/yy");
		try {
			plt1.setBirthDate(birthDateFormat.parse("1/22/1967"));
			plt2.setBirthDate(birthDateFormat.parse("10/22/1981"));
			plt3.setBirthDate(birthDateFormat.parse("10/20/1990"));
			plt4.setBirthDate(birthDateFormat.parse("6/13/1972"));
		}
		catch (Exception e) {
			System.out.println("Can not parse date");
		}
		
		hang1.addPlane(pln1);
		hang1.addPlane(pln2);
		hang2.addPlane(pln3);
		hang2.addPlane(pln4);
		
		hang1.removePlane(pln2);
		hang2.addPlane(pln2);
		
		System.out.printf("%nPlanes in hangar %d:%n", hang2.getNumber());
		for(Plane pln : hang2.getPlanes()) {
            System.out.println(pln.getName());
        }
		
		fl1 = new Flight("AR-2343", "Moscow", "Ekaterinburg");
		fl2 = new Flight("SE-3245", "Moscow", "Paris");
		
		fl1.addPilot(plt1);
		fl1.addPilot(plt3);
		
		fl2.addPilot(plt2);
		fl2.addPilot(plt4);
		
		fl1.setPlane(pln4);
		
		fl2.setPlane(pln1);
		fl2.setPlane(pln2);
		
		System.out.printf("%nPilots of %s flight:%n", fl1.getName());
		for(Pilot plt : fl1.getPilots()) {
            System.out.println(plt.getName());
        }
		
		System.out.printf("%nPilots of %s flight:%n", fl2.getName());
		for(Pilot plt : fl2.getPilots()) {
            System.out.println(plt.getName());
        }
	}
}