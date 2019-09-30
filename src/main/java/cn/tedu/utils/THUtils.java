package cn.tedu.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author LeafDust
 * @create 2019-09-16 20:32
 */
public class THUtils {
    private static TemplateEngine templateEngine;

    static {
        templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setCharacterEncoding("UTF-8");
        resolver.setSuffix(".html");
        templateEngine.setTemplateResolver(resolver);
    }

    public static void write(String path, HttpServletResponse response, Context context) throws IOException {
        String html = templateEngine.process(path, context);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(html);
        printWriter.close();
    }
}
