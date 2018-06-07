package util;

public class UploadImgResult_util {
    public static UploadImgResult success(String []object) {
        UploadImgResult result = new UploadImgResult();
        result.setErrno(0);
        result.setData(object);
        return result;
    }
    public static UploadImgResult success() {
        return success(null);
    }
}
