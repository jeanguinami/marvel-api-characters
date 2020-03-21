
package io.jeanfrias.characters.dto;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ComicDate {

	@Getter
	@Setter
	private String type;
	@Getter
	@Setter
	private Date date;

}
