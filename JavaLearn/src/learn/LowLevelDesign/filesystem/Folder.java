package learn.LowLevelDesign.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    String name;
    List<File> files;
    List<Folder> folders;

    public Folder(String name){
        files = new ArrayList<>();
        folders = new ArrayList<>();
        this.name = name;
    }

    void addFile(File file){
        files.add(file);
    }

    void printAllFiles(){
        for(File file : files){
            System.out.println("File: " + file.name);
        }

        for(Folder folder : folders){
            folder.printAllFiles();
        }
    }

    int findTotalFileSize(){
        int size = 0;
        for(File file : files){
            size = size + file.size;
        }

        for(Folder folder: folders){
            size = size + folder.findTotalFileSize();
        }
        return size;
    }

    int countFiles(){
        int count = 0;
        for(File file : files){
            count = count + 1;
        }

        for(Folder folder: folders){
            count = count + folder.countFiles();
        }
        return count;
    }
}
