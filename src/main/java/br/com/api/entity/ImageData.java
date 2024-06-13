package br.com.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_image_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String type;
	
	@Lob
    @Column(name = "imagedata",length = 1024, columnDefinition="LONGBLOB NOT NULL")
    @MapKeyColumn(columnDefinition="LONGBLOB NOT NULL")
	private byte[] imageData;
	
}
