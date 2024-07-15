package top.gtb520.tools.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jetbrains.annotations.NotNull;

public class YamlFile_Utils {

    private InputStream getResource(@NotNull String filename) {
        try {
            URL URL = getClass().getClassLoader().getResource(filename);
            if (URL == null)
                return null;
            URLConnection Connection = URL.openConnection();
            Connection.setUseCaches(false);
            return Connection.getInputStream();
        } catch (IOException ex) {
            return null;
        }
    }
    
    public void saveYmlFile(String FilePath, String FileName, String ResourcePath) {
        File Folder = new File(FilePath);
        if (!Folder.exists())
            Folder.mkdirs();
        saveResource(FilePath, ResourcePath, FileName, false);
    }

    public void saveYamlFile(String FilePath, String FileName, String ResourcePath,boolean Replace) {
        File Folder = new File(FilePath);
        if (!Folder.exists())
            Folder.mkdirs();
        saveResource(FilePath, ResourcePath, FileName, Replace);
    }

    public void saveResource(String FilePath, @NotNull String ResourcePath, String OutFileName, boolean Replace) {
        if (ResourcePath.equals(""))
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        ResourcePath = ResourcePath.replace('\\', '/');
        InputStream in = getResource(ResourcePath);
        if (in == null)
            throw new IllegalArgumentException("The embedded resource '" + ResourcePath + "' cannot be found in " + ResourcePath);
        File OutFile = new File(FilePath, OutFileName);
        try {
            if (!OutFile.exists() || Replace) {
                OutputStream out = new FileOutputStream(OutFile);
                byte[] buf = new byte[1024];
                int Len;
                while ((Len = in.read(buf)) > 0)
                    out.write(buf, 0, Len);
                out.close();
                in.close();
            } else {
                System.out.println("Could not save " + OutFile.getName() + " to " + OutFile + " because " + OutFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            System.out.println("Could not save " + OutFile.getName() + " to " + OutFile);
        }
    }
}
