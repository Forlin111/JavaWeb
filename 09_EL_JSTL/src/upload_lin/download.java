package upload_lin;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

public class download   extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //文件的下载

        //获取要下载的文件名
        String downloadFileName="1.jpg";
        //读取要下载的文件内容(通过servletContext对象可以获取)
        ServletContext servletContext = getServletContext();
        //在回传数据前要通过响应头告诉数据类型给客户端
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println(downloadFileName);
        System.out.println(mimeType);
        resp.setContentType(mimeType);
        //告诉客户端收到的数据是用来下载使用的
        //Content-Disposition响应头表示收到的数据怎么处理
        //attachmen表示附件
        //filename表示指定下载的文件名    不一定要跟下载的文件名一样,可以自定义文件名
//        resp.setHeader("Content-Disposition","attachment;filename=hhj.jpg");
        //设置中文文件名
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("黄慧静.jpg","UTF-8"));

        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //就是把输入流的数据复制给输出流,输出给客户端;
        IOUtils.copy(resourceAsStream,outputStream);


    }
}
