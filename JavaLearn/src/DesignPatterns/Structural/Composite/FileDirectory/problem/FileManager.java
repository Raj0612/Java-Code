package DesignPatterns.Structural.Composite.FileDirectory.problem;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<File> files;
    private List<Folder> folders;

    public FileManager(){
        files = new ArrayList<>();
        folders = new ArrayList<>();
    }

    public void addFile(File file){
        files.add(file);
    }

    public void addFolder(Folder folder){
        folders.add(folder);
    }

    public void printDetails(){
        for(File file: files){
            file.showDetails();
        }

        for(Folder folder: folders){
            folder.showDetails();
        }
    }
}
