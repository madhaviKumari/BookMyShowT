package co.move.in.test.BookMyShow.services.aws.s3;

import org.springframework.web.multipart.MultipartFile;

public interface AmazonS3ClientService {
		void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess);

	    void uploadFileToS3Bucket(MultipartFile multipartFile, String filename, boolean enablePublicReadAccess);
	    
	    void deleteFileFromS3Bucket(String fileName);
	    String getFileLink();
}