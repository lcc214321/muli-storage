package tv.muli.mulistorage.service.impl;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;
import tv.muli.mulistorage.constant.UploadType;
import tv.muli.mulistorage.service.StorageService;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author jory
 * @date 2019-03-20
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${my.minio.url}")
    private String url;

    @Value("${my.minio.access-key}")
    private String accessKey;

    @Value("${my.minio.secret-key}")
    private String secretKey;

    @Value("${my.minio.muli.pic-bucket}")
    private String picBucket;

    @Value("${my.minio.muli.video-bucket}")
    private String videoBucket;

    @Value("${my.minio.muli.file-bucket}")
    private String fileBucket;

    @Value("${my.minio.muli.pic-url}")
    private String picUrl;

    @Value("${my.minio.muli.video-url}")
    private String videoUrl;

    @Value("${my.minio.muli.file-url}")
    private String fileUrl;

    @Override
    public String adUpload(String fileName, InputStream inputStream, long size, String contextType, UploadType uploadType) {
        try {
            String bucket;
            String returnDns;
            if (UploadType.PIC == uploadType) {
                bucket = picBucket;
                returnDns = picUrl;
            } else if (UploadType.VIDEO == uploadType) {
                bucket = videoBucket;
                returnDns = videoUrl;
            } else if (UploadType.FILE == uploadType) {
                bucket = fileBucket;
                returnDns = fileUrl;
            } else {
                log.error("上传文件类型错误");
                return "fail";
            }
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            boolean isExist = minioClient.bucketExists(bucket);
            if (!isExist) {
                minioClient.makeBucket(bucket);
            }
            minioClient.putObject(bucket, fileName, inputStream, size, contextType);
            return returnDns + "/" + bucket + "/" + fileName;
        } catch (MinioException | NoSuchAlgorithmException | XmlPullParserException | InvalidKeyException | IOException e) {
            log.error(e.getMessage(), e);
        }
        return "exception";
    }
}
