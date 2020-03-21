
package io.jeanfrias.characters.dto;

import java.util.List;

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
public class EventDataContainer {

	@Getter
	@Setter
	private Integer offset;
	@Getter
	@Setter
	private Integer limit;
	@Getter
	@Setter
	private Integer total;
	@Getter
	@Setter
	private Integer count;
	public List<Event> results = null;

}
