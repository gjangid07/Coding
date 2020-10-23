package Serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

	public String name;

	public String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		 name = (String)in.readObject();
		
		if("xyz".equals(name.substring(name.length()-3))) {
			name = name.substring(0,name.length()-3);
		}else throw new IOException("Not name String");
		
		 gender = (String)in.readObject();
		if("abc".equals(gender.substring(0, 3))) {
			gender = gender.substring(3);
		}else throw new IOException("Not gender String");

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.name + "xyz");
		out.writeObject("abc" + this.gender);
	}

}
