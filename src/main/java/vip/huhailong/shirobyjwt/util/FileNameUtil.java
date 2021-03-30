package vip.huhailong.shirobyjwt.util;

/**
 * @author Huhailong
 * @Description 文件工具类
 * @Date 2021/3/30.
 */
public class FileNameUtil {

    /**
     * 获取获取文件后缀类型
     * @param fileName 文件全名
     * @return 返回类型
     */
    public static String getFileSuffix(String fileName){
        String[] split = fileName.split("\\.");
        return "."+split[split.length-1];
    }
}
