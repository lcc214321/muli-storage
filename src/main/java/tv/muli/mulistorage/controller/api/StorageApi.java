package tv.muli.mulistorage.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tv.muli.mulistorage.constant.CodeMsgEnum;
import tv.muli.mulistorage.constant.UploadType;
import tv.muli.mulistorage.controller.ApiBaseController;
import tv.muli.mulistorage.service.StorageService;

import java.io.IOException;
import java.util.UUID;

/**
 * @author jory
 * @date 2019-03-20
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class StorageApi extends ApiBaseController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("img") MultipartFile multipartFile) {
        if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
            return failResult(CodeMsgEnum.IMG_EMPTY);
        }
        try {
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            UUID uuid = UUID.randomUUID();
            String imgName = uuid + "." + suffix;
            String url = storageService.adUpload(imgName, multipartFile.getInputStream(), multipartFile.getSize(), multipartFile.getContentType(), UploadType.PIC);
            return successResult(url);
        } catch (IOException e) {
            log.error(e.getMessage());
            return failResult(CodeMsgEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
    public String uploadVideo(@RequestParam("video") MultipartFile multipartFile) {
        if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
            return failResult(CodeMsgEnum.MIME_TYPE_ERROR);
        }
        try {
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            UUID uuid = UUID.randomUUID();
            String videoName = uuid + "." + suffix;
            String url = storageService.adUpload(videoName, multipartFile.getInputStream(), multipartFile.getSize(), multipartFile.getContentType(), UploadType.VIDEO);
            return successResult(url);
        } catch (IOException e) {
            log.error(e.getMessage());
            return failResult(CodeMsgEnum.SYSTEM_ERROR);
        }
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
            return failResult(CodeMsgEnum.MIME_TYPE_ERROR);
        }
        try {
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            UUID uuid = UUID.randomUUID();
            String videoName = uuid + "." + suffix;
            String url = storageService.adUpload(videoName, multipartFile.getInputStream(), multipartFile.getSize(), multipartFile.getContentType(), UploadType.FILE);
            return successResult(url);
        } catch (IOException e) {
            log.error(e.getMessage());
            return failResult(CodeMsgEnum.SYSTEM_ERROR);
        }
    }
}
