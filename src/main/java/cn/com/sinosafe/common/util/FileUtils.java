package cn.com.sinosafe.common.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import com.yzj.util.UUID32;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.utils.IOUtils;

import cn.com.sinosafe.domain.bean.FileType;
import org.springframework.util.ObjectUtils;

/**
 * @author cnmobi_db
 */
public final class FileUtils {
	private static Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 获取文件扩展名*
     * @param fileName 文件名
     * @return 扩展名
     */
    public static String getExtension(String fileName) {
        int i = fileName.lastIndexOf(".");
        if (i < 0) return null;

        return fileName.substring(i+1);
    }

    /**
     * 获取文件扩展名*
     * @param file 文件对象
     * @return 扩展名
     */
    public static String getExtension(File file) {
        if (file == null) return null;

        if (file.isDirectory()) return null;

        String fileName = file.getName();
        return getExtension(fileName);
    }

    /**
     * 读取文件*
     * @param filePath 文件路径
     * @return 文件对象
     */
    public static File readFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) return null;

        if (!file.exists()) return null;

        return file;
    }

    /**
     * 读取文件*
     * @param filePath 文件路径
     * @return 文件对象
     * @throws Exception
     */
    public static List<String> readTxtFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.isDirectory()) return null;
        if (!file.exists()) return null;
        String[] lines =  IOUtils.readLines(file);
        return Arrays.asList(lines);
    }

    /**
     * 复制文件
     * @param oldFilePath 源文件路径
     * @param newFilePath 目标文件毒经
     * @return 是否成功
     */
    public static boolean copyFile(String oldFilePath,String newFilePath) {
        try {
            int byteRead = 0;
            File oldFile = new File(oldFilePath);
            if (oldFile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldFilePath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newFilePath);
                byte[] buffer = new byte[1444];
                while ((byteRead = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteRead);
                }
                inStream.close();
                fs.close();

                File file = new File(newFilePath);
                if(FileUtils.isImage(file)){//如果为图片则生成缩略图
//                	ImageCompressUtil.zipImageFile(file);
                }

                return true;
            }
            return false;
        } catch (Exception e) {
            log.info("复制单个文件操作出错 ");
            e.printStackTrace();
           return false;
        }
    }

    /**
     *删除文件
     * @param filePath 文件地址
     * @return 是否成功
     */
    public static boolean delFile(String filePath) {
        return delFile(new File(filePath));
    }

    /**
     * 删除文件
     * @param file 文件对象
     * @return 是否成功
     */
    public static boolean delFile(File file) {
    	boolean result 	= false;
    	String filePath = file.getAbsolutePath();
        if (file.exists()) {
        	result = file.delete();
        }
        log.info("【FileUtils.delFile】删除文件" + filePath + "成功！");
        return result;
    }

    /**
     * png图片转jpg*
     * @param pngImage png图片对象
     * @param jpegFile jpg图片对象
     * @return 转换是否成功
     */
    public static boolean png2jpeg(File pngImage, File jpegFile) {
        BufferedImage bufferedImage;

        try {
            bufferedImage = ImageIO.read(pngImage);

            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                    bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);

            ImageIO.write(bufferedImage, "jpg", jpegFile);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断文件是否是图片*
     * @param imgFile 文件对象
     * @return
     */
    public static boolean isImage(File imgFile) {
        try {
            BufferedImage image = ImageIO.read(imgFile);
            return image != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断文件是否是视频*
     * @param videoFile  文件对象
     * @return
     */
    public static boolean isVideo(File videoFile){
    	try {

            FileType type = getType(videoFile);

            return type == FileType.AVI ||
                    type == FileType.RAM ||
                    type == FileType.RM ||
                    type == FileType.MOV ||
                    type == FileType.ASF ||
                    type == FileType.MPG;
        } catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }

    /**
     * 根据系统当前时间，返回时间层次的文件夹结果，如：upload/2015/01/18/0.jpg
     * @return
     */
    public static String getTimeFilePath(){
    	return new SimpleDateFormat("/yyyy/MM/dd").format(new Date())+"/";
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param src 原生byte
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src){

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到文件头
     *
     * @param file 文件
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(File file) throws IOException {

        byte[] b = new byte[28];

        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }


    /**
     * 判断文件类型
     *
     * @param file 文件
     * @return 文件类型
     */
    public static FileType getType(File file) throws IOException {

        String fileHead = getFileContent(file);

        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }

        fileHead = fileHead.toUpperCase();

        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }


/*    public static final String saveUploadFile(File file) {
    	String saveFilePath = "";
    	//表示存放在tomcat应用目录中
    	if (AppProperty.me().appPath() == 1) {
    		saveFilePath = Context.me().getRequest().getSession().getServletContext().getRealPath("/");
    	}

    	saveFilePath += AppProperty.me().uploadRooPath();

    	String timeFilePath = FileUtils.getTimeFilePath();
    	String urlPath = "";
    	if(FileUtils.isImage(file)){//保存图片
    		urlPath = AppProperty.me().imagePath() + timeFilePath;
    		saveFilePath += urlPath;
    	}else if(FileUtils.isVideo(file)){//保存视频
    		urlPath = AppProperty.me().videoPath() + timeFilePath;
    		saveFilePath += urlPath;
    	}else{//其他文件(如果是)
    		urlPath = AppProperty.me().otherPath() + timeFilePath;
    		saveFilePath += urlPath;
    	}
    	File saveFileDir = new File(saveFilePath);
    	if (!saveFileDir.exists()) {
    		saveFileDir.mkdirs();
    	}


    	String fileName = System.currentTimeMillis() + "."+ getFileType(file.getName());
    	//保存 文件
    	if (FileUtils.copyFile(file.getAbsolutePath(), saveFilePath + fileName)) {
    		//删掉临时文件
    		file.delete();
    		return urlPath + fileName;
    	} else {
    		return null;
    	}
    }
*/

    public static String getFileType(String fileUri){
    	 File file = new File(fileUri);
    	 String fileName = file.getName();
         String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
    	 return fileType;
    	}

    /**
	 * 影像图片类型判断
	 *
	 * @param imgStr
	 * @return
	 * @throws Exception
	 */
	public static Boolean isImg(String imgStr) throws Exception {

		String imglist = "bmp,dib,gif,jfif,jpe,jpeg,jpg,png,tif,tiff,ico";
		String[] imgArra = imglist.split(",");
		for (int i = 0; i < imgArra.length; i++) {
			String img_tmp = imgArra[i];
			if (img_tmp.equalsIgnoreCase(imgStr)) {
				return true;
			}
		}
		return false;
	}

	public static void initFiles(String path) {
		File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
	}

	/**
	 * 删除文件（如果文件存在）
	 * @author Hirson
	 * @param path
	 */
	public static void delFiles(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.delete();
		}
	}

	/**
	  * 下载文件
	  * @param url
	  * @return
	  * @throws Exception
	  */
	public static void httpClientGetMethod(String url, String path) throws Exception {
		HttpClient client = null;
		GetMethod getMethod = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			client = new HttpClient();
			getMethod = new GetMethod(url);
			client.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
			client.executeMethod(getMethod);
			in = getMethod.getResponseBodyAsStream();
			out = new FileOutputStream(path);
			copy(in, out);
		} finally {
			closeQuietly(out);
			closeQuietly(in);
			getMethod.releaseConnection();
			client = null;
		}
	}

	 /**
	  * 关闭对象
	  * @param closeable
	  */
	public static void closeQuietly(Closeable... closeable) {
		if (null != closeable && closeable.length >= 1) {
			for (Closeable c : closeable) {
				if (null != c) {
					try {
						c.close();
					} catch (IOException i) {
					}
				}
			}
		}
	}
	 /**
	  * 流复制
	  * @param input
	  * @param output
	  * @return
	  * @throws IOException
	  */
	public static int copy(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[4096];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return (int) count;
	}

	/**
	 * 写文件
	 * @param targetContent 各行数据
	 * @param outTxtPath 文件路径
	 * @throws Exception
	 */
	public static void write(List<String> targetContent, String outTxtPath) throws Exception {
		FileWriter fw = new FileWriter(outTxtPath, false);
		BufferedWriter bw = new BufferedWriter(fw);
		if(StringUtils.isEmpty(targetContent)) {
			bw.write("");
		}else {
			for (String s : targetContent) {
				bw.write((targetContent.indexOf(s) == targetContent.size() - 1) ? s : s + "\r\n");
			}
		}

		bw.close();
		fw.close();
	}

	/**
	 * 写文件
	 * @param content 单行数据
	 * @param outTxtPath 文件路径
	 * @throws Exception
	 */
	public static void writeOne(String content, String outTxtPath) throws Exception {
		FileWriter fw = new FileWriter(outTxtPath, false);
		BufferedWriter bw = new BufferedWriter(fw);
		if(StringUtils.isEmpty(content)) {
			bw.write("");
		}else {
			bw.write(content);
		}

		bw.close();
		fw.close();
	}

	/**
	 * 将数据进行分批
	 * @param <T>
	 * @Description
	 * @date 2019年7月29日
	 * @param list
	 * @param n
	 * @return
	 */
	public static <T> List<List<T>> batchInfo(List<T> list,int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        if(StringUtils.isNotEmpty(list)){
        	 int remainder = list.size() % n;
             int times = list.size() / n;
             for (int i = 0; i < times; i++) {
                 List<T> value = list.subList(i * n, (i + 1) * n);
                 result.add(value);
             }
             if (remainder > 0) {
                 result.add(list.subList(times * n, times * n + remainder));
             }
        }

		return result;
	}

    

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 从文件中筛选渠道业务写入新的文件
     * @param billNos
     * @param fileName
     * @param mustUploadFiles
     * @param locatePath
     * @param locatePathForBusiCop
     * @throws Exception
     */
    public static void choose(List<String> billNos, String fileName, List<String> mustUploadFiles, String locatePath,String locatePathForBusiCop) throws Exception {
        List<String> contents = read(locatePath);
        List<String> targetContent = new ArrayList<>();
        for (String s : contents) {
            for (String billNo : billNos) {
                if (StringUtils.isNotEmpty(s) && s.contains(billNo)) {
                    // 浩森小贷重庆农商行-还款明细最前面加上 唯一编号
                    //if(fileName.startsWith("HA008")) {
                     //   targetContent.add(UUID32.getUUID() + "@|@" + s);
                    //}else {
                        targetContent.add(s);
                    //}
                }
            }
        }
        // 将筛选后的数据写入新的文件
        write(targetContent, locatePathForBusiCop + "/" + fileName);
        mustUploadFiles.add(locatePathForBusiCop + "/" + fileName);
    }

    public static List<String> read(String txtPath) throws Exception {
        String[] lines = IOUtils.readLines(new File(txtPath));
        return Arrays.asList(lines);
    }

    /**
     * 删除文件
     * @param mustUploadFiles
     * @param locatePath
     * @param locatePathForAm
     * @param files
     */
    public static void deleteFiles(List<String> mustUploadFiles, String locatePath, String locatePathForAm, File[] files) {
        if (!ObjectUtils.isEmpty(files)) {
            for (File file : files) {
                file.delete();
            }
        }
        if (!ObjectUtils.isEmpty(mustUploadFiles)) {
            for (String path : mustUploadFiles) {
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        new File(locatePath).delete();
        File locatePathForAmFile = new File(locatePathForAm);
        if ((locatePathForAmFile.exists()) && (locatePathForAmFile.isDirectory())) {
            File[] locatePathForAmFiles = locatePathForAmFile.listFiles();
            if (!ObjectUtils.isEmpty(locatePathForAmFiles)) {
                for (File file : locatePathForAmFiles) {
                    file.delete();
                }
            }
            locatePathForAmFile.delete();
        }
    }
}

