
package io.jeanfrias.characters.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CREATOR_LIST")
public class CreatorList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private Integer available;
	@Getter
	@Setter
	private Integer returned;
	@Getter
	@Setter
	private String collectionURI;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<CreatorSummary> items = null;

}
