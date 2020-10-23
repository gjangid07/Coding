package Serialization;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee extends Manager implements Serializable, ObjectInputValidation {

	private static final long serialVersionUID = -2079426234078741308L;

	public int empId;

	public String empName;

//	public String passwd;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

//	public String getPasswd() {
//		return passwd;
//	}
//
//	public void setPasswd(String passwd) {
//		this.passwd = passwd;
//	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

	public  void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

		// notice the order of read and write should be same

		setValue((String) ois.readObject());
		setEmpId(ois.readInt());
		setEmpName((String) ois.readObject());
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();

		oos.writeObject(getValue());
		oos.writeObject(getEmpId());
		oos.writeObject(getEmpName());
	}

	@Override
	public void validateObject() throws InvalidObjectException {
		// TODO Auto-generated method stub

	}
}

class Manager {
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Manager [value=" + value + "]";
	}
	
	

}
