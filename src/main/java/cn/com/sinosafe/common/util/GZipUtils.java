package cn.com.sinosafe.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

public class GZipUtils {

	public static void unTarGz(File file, String outputDir) throws IOException {
		TarInputStream tarIn = null;
		try {
			tarIn = new TarInputStream(new GZIPInputStream(
					new BufferedInputStream(new FileInputStream(file))), 2048);
			createDirectory(outputDir, null);
			TarEntry entry = null;
			while ((entry = tarIn.getNextEntry()) != null) {
				if (entry.isDirectory()) {
					entry.getName();
					createDirectory(outputDir, entry.getName());
				} else {
					File tmpFile = new File(outputDir + "/" + entry.getName());
					createDirectory(tmpFile.getParent() + "/", null);
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int length = 0;

						byte[] b = new byte[2048];

						while ((length = tarIn.read(b)) != -1) {
							out.write(b, 0, length);
						}
					} catch (IOException ex) {
						throw ex;
					} finally {
						if (out != null) {
							out.close();
						}
					}
				}
			}
		} catch (IOException ex) {
			throw new IOException("解压归档文件出现异常", ex);
		} finally {
			try {
				if (tarIn != null) {
					tarIn.close();
				}
			} catch (IOException ex) {
				throw new IOException("关闭tarFile出现异常", ex);
			}
		}
	}

	public static void createDirectory(String outputDir, String subDir) {
		File file = new File(outputDir);
		if ((subDir != null) && (!subDir.trim().equals(""))) {
			file = new File(outputDir + "/" + subDir);
		}
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
				file.mkdirs();
			}
		}
	}

	/**
	 * 解压gz
	 *
	 * @param archive
	 * @author yutao
	 * @throws IOException
	 * @date 2017年5月27日下午4:34:41
	 */
	public static void unCompressArchiveGz(String archive) throws IOException {
		File file = new File(archive);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));
		String fileName = file.getName().substring(0,
				file.getName().lastIndexOf("."));
		String finalName = file.getParent() + File.separator + fileName;
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(finalName));
		GzipCompressorInputStream gcis = new GzipCompressorInputStream(bis);
		byte[] buffer = new byte[1024];
		int read = -1;
		while ((read = gcis.read(buffer)) != -1) {
			bos.write(buffer, 0, read);
		}
		gcis.close();
		bos.close();
		unCompressTar(finalName);
	}

	/**
	 * 解压tar
	 *
	 * @param finalName
	 * @author yutao
	 * @throws IOException
	 * @date 2017年5月27日下午4:34:41
	 */
	public static void unCompressTar(String finalName) throws IOException {
		File file = new File(finalName);
		String parentPath = file.getParent();
		TarArchiveInputStream tais = new TarArchiveInputStream(
				new FileInputStream(file));

		TarArchiveEntry tarArchiveEntry = null;

		while ((tarArchiveEntry = tais.getNextTarEntry()) != null) {
			String name = tarArchiveEntry.getName();
			File tarFile = new File(parentPath, name);
			if (!tarFile.getParentFile().exists()) {
				tarFile.getParentFile().mkdirs();
			}
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(tarFile));
			int read = -1;
			byte[] buffer = new byte[1024];
			while ((read = tais.read(buffer)) != -1) {
				bos.write(buffer, 0, read);
			}
			bos.close();
		}
		tais.close();
		file.delete();// 删除tar文件
	}


	/**
	 * <p>Tar文件解压方法</p>
	 *
	 * @param tarFile
	 *            要解压的压缩文件名称（绝对路径名称）
	 * @param destDir
	 *            解压后文件放置的路径名（绝对路径名称）
	 * @return 解压出的文件列表
	 * xiechong 2018/09/05
	 */
	public static List<String> deCompressTarFile(String tarFile, String destDir) throws Exception {

		List<String> fileList = new ArrayList<String>();

		OutputStream out = null; // 建立输出流，用于将从压缩文件中读出的文件流写入到磁盘
		FileInputStream fis = null; // 建立输入流，用于从压缩文件中读出文件

		TarArchiveInputStream taris = null;
		TarArchiveEntry entry = null;
		TarArchiveEntry[] subEntries = null;

		File entryFile = null;
		File subEntryFile = null;
		String entryFileName = null;

		try {
			fis = new FileInputStream(new File(tarFile));
			taris = new TarArchiveInputStream(fis);

			while ((entry = taris.getNextTarEntry()) != null) {
				entryFileName = destDir + File.separator + entry.getName();
				entryFile = new File(entryFileName);
				if (entry.isDirectory()) {
					if (!entryFile.exists()) {
						entryFile.mkdir();
					}
					subEntries = entry.getDirectoryEntries();
					for (int i = 0; i < subEntries.length; i++) {
						subEntryFile = new File(entryFileName + File.separator + subEntries[i].getName());
						fileList.add(entryFileName + File.separator + subEntries[i].getName());
						out = new FileOutputStream(subEntryFile);
						byte[] buf = new byte[1024];
						int len = 0;
						while ((len = taris.read(buf)) != -1) {
							out.write(buf, 0, len);
						}
					}
				} else {
					fileList.add(entryFileName);
					out = new FileOutputStream(entryFile);
					byte[] buf = new byte[1024];
					int len = 0;
					while ((len = taris.read(buf)) != -1) {
						out.write(buf, 0, len);
					}
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (out != null) {
				out.flush();
				out.close();
				// out = null;
			}
			if (taris != null) {
				taris.close();
				// taris = null;
			}
			if (fis != null) {
				fis.close();
				// fis = null;
			}
		}
		return fileList;

	}



	/**
	 * 归档 生成tar
	 *
	 * @param entry
	 * @throws IOException
	 * @author yutao
	 * @return
	 * @date 2017年5月27日下午1:48:23
	 */
	public static String archive(String entry) throws IOException {
		File file = new File(entry);
		TarArchiveOutputStream tos = new TarArchiveOutputStream(
				new FileOutputStream(file.getAbsolutePath() + ".tar"));
		String base = file.getName();
		if (file.isDirectory()) {
			archiveDir(file, tos, base);
		} else {
			archiveHandle(tos, file, base);
		}
		tos.close();
		return file.getAbsolutePath() + ".tar";
	}

	/**
	 * 递归处理，准备好路径
	 *
	 * @param file
	 * @param tos
	 * @param basePath
	 * @throws IOException
	 * @author yutao
	 * @date 2017年5月27日下午1:48:40
	 */
	private static void archiveDir(File file, TarArchiveOutputStream tos,
								   String basePath) throws IOException {
		File[] listFiles = file.listFiles();
		for (File fi : listFiles) {
			if (fi.isDirectory()) {
				archiveDir(fi, tos, basePath + File.separator + fi.getName());
			} else {
				archiveHandle(tos, fi, basePath);
			}
		}
	}

	/**
	 * 具体归档处理（文件）
	 *
	 * @param tos
	 * @param fi
	 * @param basePath
	 * @throws IOException
	 * @author yutao
	 * @date 2017年5月27日下午1:48:56
	 */
	private static void archiveHandle(TarArchiveOutputStream tos, File fi,
									  String basePath) throws IOException {
		TarArchiveEntry tEntry = new TarArchiveEntry(basePath + File.separator
				+ fi.getName());
		tEntry.setSize(fi.length());

		tos.putArchiveEntry(tEntry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				fi));

		byte[] buffer = new byte[1024];
		int read = -1;
		while ((read = bis.read(buffer)) != -1) {
			tos.write(buffer, 0, read);
		}
		bis.close();
		tos.closeArchiveEntry();// 这里必须写，否则会失败
	}

	/**
	 * 把tar包压缩成gz
	 *
	 * @param path
	 * @throws IOException
	 * @author yutao
	 * @return
	 * @date 2017年5月27日下午2:08:37
	 */
	public static String compressArchive(String path) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				path));

		GzipCompressorOutputStream gcos = new GzipCompressorOutputStream(
				new BufferedOutputStream(new FileOutputStream(path + ".gz")));

		byte[] buffer = new byte[1024];
		int read = -1;
		while ((read = bis.read(buffer)) != -1) {
			gcos.write(buffer, 0, read);
		}
		gcos.close();
		bis.close();
		return path + ".gz";
	}

	/**
	 * 解压tar.gz 文件
	 *
	 * @param file
	 *            要解压的tar.gz文件对象
	 * @param outputDir
	 *            要解压到某个指定的目录下
	 * @throws IOException
	 */
	public static void unTarGz2(File file, String outputDir) throws IOException {
		TarInputStream tarIn = null;
		try {
			tarIn = new TarInputStream(new BufferedInputStream(
					new FileInputStream(file)), 1024 * 2);
			createDirectory(outputDir, null);// 创建输出目录
			TarEntry entry = tarIn.getNextEntry();
			while (entry != null) {
				if (entry.isDirectory()) {// 是目录
					entry.getName();
					createDirectory(outputDir, entry.getName());// 创建空目录
				} else {// 是文件
					File tmpFile = new File(outputDir + "/" + entry.getName());
					createDirectory(tmpFile.getParent() + "/", null);// 创建输出目录
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int length = 0;
						byte[] b = new byte[2048];
						while ((length = tarIn.read(b)) != -1) {
							out.write(b, 0, length);
						}
					} catch (IOException ex) {
						throw ex;
					} finally {
						if (out != null) {
							out.close();
						}
					}
				}
			}
		} catch (IOException ex) {
			throw new IOException("解压归档文件出现异常", ex);
		} finally {
			try {
				if (tarIn != null) {
					tarIn.close();
				}
			} catch (IOException ex) {
				throw new IOException("关闭tarFile出现异常", ex);
			}
		}
	}

	/**
	 * 解压tar.gz 文件
	 *
	 * @param file
	 *            要解压的tar.gz文件对象
	 * @param outputDir
	 *            要解压到某个指定的目录下
	 * @throws IOException
	 */
	public static void unTarGz3(File file, String outputDir)
			throws IOException
	{
		TarInputStream tarIn = null;
		try {
			tarIn = new TarInputStream(new GZIPInputStream(
					new BufferedInputStream(new FileInputStream(file))),
					2048);

			createDirectory(outputDir, null);

			TarEntry entry = null;
			while ((entry = tarIn.getNextEntry()) != null)
			{
				if (entry.isDirectory()) {
					entry.getName();
					createDirectory(outputDir, entry.getName());
				} else {
					File tmpFile = new File(outputDir + "/" + entry.getName());
					createDirectory(tmpFile.getParent() + "/", null);
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int length = 0;

						byte[] b = new byte[2048];

						while ((length = tarIn.read(b)) != -1) {
							out.write(b, 0, length);
						}
					}
					catch (IOException ex)
					{
						throw ex;
					}
					finally {
						if (out != null) {
							out.close();
						}
					}
				}
			}
		} catch (IOException ex) {
			throw new IOException("解压归档文件出现异常", ex);
		} finally {
			try {
				if (tarIn != null) {
					tarIn.close();
				}
			}
			catch (IOException ex) {
				throw new IOException("关闭tarFile出现异常", ex);
			}
		}
	}

	public static void unGzipFile(String sourcedir) {
		String ouputfile = "";
		try {
			//建立gzip压缩文件输入流
			FileInputStream fin = new FileInputStream(sourcedir);
			//建立gzip解压工作流
			GZIPInputStream gzin = new GZIPInputStream(fin);
			//建立解压文件输出流
			ouputfile = sourcedir.substring(0,sourcedir.lastIndexOf('.'));
			ouputfile = ouputfile.substring(0,ouputfile.lastIndexOf('.'));
			FileOutputStream fout = new FileOutputStream(ouputfile);

			int num;
			byte[] buf=new byte[1024];

			while ((num = gzin.read(buf,0,buf.length)) != -1)
			{
				fout.write(buf,0,num);
			}

			gzin.close();
			fout.close();
			fin.close();
		} catch (Exception ex){
			System.err.println(ex.toString());
		}
		return;
	}

	/**
	 * zip解压
	 *
	 * @param srcFile
	 *            zip源文件
	 * @param destDirPath
	 *            解压后的目标文件夹
	 * @throws RuntimeException
	 *             解压失败会抛出运行时异常
	 */
	public static void unZip(File srcFile, String destDirPath)
			throws RuntimeException {
		long start = System.currentTimeMillis();
		// 判断源文件是否存在
		if (!srcFile.exists()) {
			throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
		}
		// 开始解压
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(srcFile);
			Enumeration<?> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				System.out.println("解压" + entry.getName());
				// 如果是文件夹，就创建个文件夹
				if (entry.isDirectory()) {
					String dirPath = destDirPath + "/" + entry.getName();
					File dir = new File(dirPath);
					dir.mkdirs();
				} else {
					// 如果是文件，就先创建一个文件，然后用io流把内容copy过去
					File targetFile = new File(destDirPath + "/"
							+ entry.getName());
					// 保证这个文件的父文件夹必须要存在
					if (!targetFile.getParentFile().exists()) {
						targetFile.getParentFile().mkdirs();
					}
					targetFile.createNewFile();
					// 将压缩文件内容写入到这个文件中
					InputStream is = zipFile.getInputStream(entry);
					FileOutputStream fos = new FileOutputStream(targetFile);
					int len;
					byte[] buf = new byte[1024];
					while ((len = is.read(buf)) != -1) {
						fos.write(buf, 0, len);
					}
					// 关流顺序，先打开的后关闭
					fos.close();
					is.close();
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("解压完成，耗时：" + (end - start) + " ms");
		} catch (Exception e) {
			throw new RuntimeException("unzip error from ZipUtils", e);
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

