package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	private int cyear;
	private int semester;
	
	@Size(max=50, message="ccode must be between 1 and 50 chars")
	private String ccode;
	
	@Size(max=50, message="ccode must be between 1 and 50 chars")
	private String ctitle;
	
	@Size(max=50, message="ccode must be between 1 and 50 chars")
	private String division;

	private int grade;
}
