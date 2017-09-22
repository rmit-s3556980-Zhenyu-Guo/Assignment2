
public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Test Swimmer, Sprinter, Cyclist Class
		Swimmer a = new Swimmer("aa", "bb", "cc", "dd", 0);
		for(int i=0;i<100000;i++){
			if(a.compete("Swimming")>=200 || a.compete("Swimming")<=100)
				System.out.println(a.compete("Swimming"));
		}
		System.out.println("all right");
		
		SuperAthletes sa = new SuperAthletes("aa", "bb", "cc", "dd", 0);
		for(int i=0;i<100000;i++){
			if(sa.compete("Swimming")>=200 || sa.compete("Swimming")<=100)
				System.out.println(sa.compete("Swimming"));
		}
		System.out.println("SA swimming all right");
		
		Sprinter b = new Sprinter("aa", "bb", "cc", "dd", 0);
		for(int i=0;i<100000;i++){
			if(b.compete("Running")>=20 || b.compete("Running")<=10)
				System.out.println(b.compete("Running"));
		}
		System.out.println("Running compete all right");
		for(int i=0;i<100000;i++){
			if(sa.compete("Running")>=20 || sa.compete("Running")<=10)
				System.out.println(sa.compete("Running"));
		}
		System.out.println("SA running all right");
		
		Cyclist c = new Cyclist("aa", "bb", "cc", "dd", 0);
		for(int i=0;i<100000;i++){
			if(c.compete("Cycling")>=800 || c.compete("Cycling")<=500)
				System.out.println(c.compete("Cycling"));
		}
		System.out.println("Cyclist compete all right");
		for(int i=0;i<100000;i++){
			if(sa.compete("Cycling")>=800 || sa.compete("Cycling")<=500)
				System.out.println(sa.compete("Cycling"));
		}
		System.out.println("SA cycling all right");
		Driver d = new Driver();
		d.meanMenuControl();

	}

}
