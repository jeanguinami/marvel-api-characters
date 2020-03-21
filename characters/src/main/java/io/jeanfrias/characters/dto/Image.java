
package io.jeanfrias.characters.dto;

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
public class Image {

	@Getter
	@Setter
	private String path;
	@Getter
	@Setter
	private String extension;

}
