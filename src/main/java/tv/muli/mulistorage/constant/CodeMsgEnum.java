package tv.muli.mulistorage.constant;

import lombok.Getter;

/**
 * 返回码枚举
 *
 * @author jory
 * @date 2019-03-14
 */
@Getter
public enum CodeMsgEnum {

    /**
     * 通用错误信息
     */
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    SYSTEM_ERROR(2, "系统异常"),

    /**
     * 参数检查错误信息
     */
    ARGS_MISSING(201, "参数不全"),
    ARGS_ILLEGAL(202, "非法参数"),

    FILE_ERROR_TYPE(301, "文件格式不正确"),
    FILE_UPLOAD_ERROR(302, "文件上传失败"),
    FILE_UPLOAD_ERR_SIZE(303, "文件太大"),
    IMG_EMPTY(304, "上传图片为空"),
    IMG_FORMAT_ERROR(305, "图片格式错误"),
    MIME_TYPE_ERROR(306, "不支持媒体类型");


    private int code;
    private String msg;

    CodeMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
