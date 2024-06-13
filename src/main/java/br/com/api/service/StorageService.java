package br.com.api.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.entity.ImageData;
import br.com.api.repository.StorageRepository;
import br.com.api.util.ImageUtils;

@Service
public class StorageService {

	@Autowired
	private StorageRepository repository;
	
	public String uploadImage(MultipartFile file) throws IOException {
		
		ImageData imageData = repository.save(
				ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		
		if(imageData != null ) {
			return "Arquivo foi enviado com sucesso! : " + file.getOriginalFilename();
		}
		return null;
	}
	
	public byte[] downloadImage(String fileName) {
		Optional<ImageData> dbImageData = repository.findByName(fileName);
		byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		return images;
	}
	
	
	public List<String> getAllNames() {
		LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo")); 
		// https://howtodoinjava.com/java/date-time/java-localdatetime-class/
		// https://howtodoinjava.com/java/date-time/java8-datetimeformatter-example/
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
		System.out.println(now.format(formatter) + ".png");
		
		return repository.findAllByName();
	}
	
	
	
	
	
	
}
