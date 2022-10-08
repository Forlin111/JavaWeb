package upload_lin;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class uploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //用来处理接收到的文件 以流的形式来接收数据
//        ServletInputStream stream = req.getInputStream();
//        byte[] bytes = new byte[102400];
//        int read = stream.read(bytes);
//        System.out.println(new String(bytes,0,read));

        //1先判断上传的数据是否是多段的数据(只有是多段的数据才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建FileItemFactory实现类
            FileItemFactory factory=new DiskFileItemFactory();
            //创建用于解析上传数据的解析类ServletFileUpload类
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            //解析上传的数据得到每一个表单项
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(req);
                //循环判断每一个表单项是普通类型或者文件
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name值:"+fileItem.getFieldName());
                        System.out.println("表单项的value值:"+fileItem.getString("UTF-8"));//防止乱码
                    }else {
                        //上传的文件
                        System.out.println("表单项的name值:"+fileItem.getFieldName());
                        System.out.println("上传的文件名:"+fileItem.getName());
                        //将解析到的文件写入磁盘
                        fileItem.write(new File("E:/abc/"));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
