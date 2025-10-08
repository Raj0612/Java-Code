package DesignPatterns.Behavioral.ChainOfResponsibility.upgrad;

public class Client {
    public static void main(String[] args) {
        Handler audioFileHandler = new AudioFileHandler();
        Handler imageFileHandler = new ImageFileHandler();
        Handler textFileHandler = new TextFileHandler();
        imageFileHandler.setHandler(audioFileHandler);
        textFileHandler.setHandler(imageFileHandler);

        textFileHandler.process("Audio");
    }
}
