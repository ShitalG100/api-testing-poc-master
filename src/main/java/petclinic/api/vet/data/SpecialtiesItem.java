package petclinic.api.vet.data;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpecialtiesItem{
	@Expose
	private String name;
	@Expose
	private int id;

	/*
	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}*/
}
