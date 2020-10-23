package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializationUtil {

	public static void serialize(String fileName, Object obj) throws IOException {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			oos = new ObjectOutputStream(fos);
			oos.writeObject((Employee) obj);
		} catch (Exception e) {

		} finally {
			oos.close();
			fos.close();
		}
	}

	public static Object deserialize(String fileName) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Manager emp = null;
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);
			emp = (Employee)ois.readObject();
//			emp = new Employee();
//			emp.setValue((String) ois.readObject());
//			emp.setEmpId(ois.readInt());
//			emp.setEmpName((String) ois.readObject());
		} catch (Exception e) {

		} finally {
			ois.close();
			fis.close();
		}
		return emp;
	}
}
