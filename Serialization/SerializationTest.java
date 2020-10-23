package Serialization;

import java.io.IOException;

public class SerializationTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Employee emp1 = new Employee();
		emp1.setValue("A's Manager");
		emp1.setEmpId(1);
		emp1.setEmpName("A");

		try {
			SerializationUtil.serialize("emp1.ser", emp1);
			System.out.println(SerializationUtil.deserialize("emp1.ser").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Person p1 = new Person();
//		p1.setName("Gaj");
//		p1.setGender("Male");
//
//		try {
//			SerializationUtil.serialize("p1.ser", p1);
//			System.out.println(SerializationUtil.deserialize("p1.ser").toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
