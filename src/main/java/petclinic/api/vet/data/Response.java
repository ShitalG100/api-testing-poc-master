package petclinic.api.vet.data;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Response{
	@Expose
	private String firstName;
	@Expose
	private String lastName;
	@Expose
	private List<SpecialtiesItem> specialties;
	@Expose
	private int id;

	/*
	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public List<SpecialtiesItem> getSpecialties(){
		return specialties;
	}

	public int getId(){
		return id;
	}*/
}