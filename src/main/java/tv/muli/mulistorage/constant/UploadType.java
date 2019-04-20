package tv.muli.mulistorage.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 上传类型枚举
 *
 * @author jory
 * @date 2019-03-14
 */
@Getter
@AllArgsConstructor
public enum UploadType {

    /**
     * 图片类型
     */
    PIC(0, "图片"),
    /**
     * 视频类型
     */
    VIDEO(1, "视频"),
    /**
     * 文件类型
     */
    FILE(2, "文件");

    private Integer type;
    private String desc;
}
