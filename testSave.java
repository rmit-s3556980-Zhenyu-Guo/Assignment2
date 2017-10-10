import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.io.*;

public class testSave {
	public static void main(String[] args){
//		Data data = new Data();
//		data.Cyclist();
//		data.setCyclingGameNumber(6);
//		
//		File file = new File("test.txt");
//		FileOutputStream out;
//		try {
//			out = new FileOutputStream(file);
//			ObjectOutputStream objOut = new ObjectOutputStream(out);
//			objOut.writeObject(data);
//			objOut.flush();
//			objOut.close();
//			System.out.print("Save success!");
//		} catch (IOException e) {
//			System.out.print("Write object failed");
//			e.printStackTrace();
//		}
		
		//read 
		Object temp=null;
        File file =new File("test.txt");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(in);
            temp = objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		Data da = (Data) temp;
		System.out.println(da.getCyclistList().size());
		System.out.println(da.getCyclingGameNumber());
		System.out.println(da.getResultList().size());
		
	}

}
