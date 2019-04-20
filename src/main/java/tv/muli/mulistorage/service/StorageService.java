package tv.muli.mulistorage.service;

import tv.muli.mulistorage.constant.UploadType;

import java.io.InputStream;

/**
 * @author jory
 * @date 2019-03-20
 */
public interface StorageService {

    String adUpload(String fileName, InputStream inputStream, long size, String contextType, UploadType adUploadType);
}
