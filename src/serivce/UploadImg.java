package serivce;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import util.UploadImgResult;
import util.UploadImgResult_util;


public class UploadImg extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRealPath("/upload_commentImg");
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("file is exist");
            file.mkdirs();
        }
        String fileName = "defaulFileName";// 文件名称


        /**上传文件处理内容**/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题
        sfu.setSizeMax(5*1024 * 1024); // 限制文件大小

        List<FileItem> fileItems = null; // 解码请求
        try {
            fileItems = sfu.parseRequest(new ServletRequestContext(request));
        } catch (FileUploadException e) {
            System.out.println("fail to analyze request\n"+e.getMessage());
        }
        for (FileItem fi : fileItems) {
            fileName = UUID.randomUUID()+fi.getName().substring(fi.getName().lastIndexOf("."),fi.getName().length());
            try {
                fi.write(new File(path, fileName));
            } catch (Exception e) {
                System.out.println("fail to write fi \n"+e.getMessage());
            }
        }

        /***获取图片url地址***/
        String imgUrl = "http://localhost:8080/hello web/upload_commentImg/" + fileName;
        response.setContentType("text/text;charset=utf-8");
        PrintWriter out = response.getWriter();
        UploadImgResult result = UploadImgResult_util.success(new String[]{imgUrl});
        JSONObject object =JSONObject.fromObject(result );
        out.write(object .toString());
        out.flush();
        out.close();
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
