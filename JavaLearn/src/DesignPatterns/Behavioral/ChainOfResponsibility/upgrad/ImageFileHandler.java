package DesignPatterns.Behavioral.ChainOfResponsibility.upgrad;

public class ImageFileHandler implements Handler{
    private Handler nextHandler;

    @Override
    public void process(String fileType) {

        if("Image".equals(fileType)){
            System.out.println("Processing image file by: " + getHandlerName());
        }else if(nextHandler!=null){
            System.out.println(getHandlerName() + " forwarding request to: " + nextHandler.getHandlerName());
            nextHandler.process(fileType);
        }else{
            System.out.println("No matching handler found");
        }
    }

    @Override
    public void setHandler(Handler handler) {
        nextHandler = handler;
    }

    @Override
    public String getHandlerName() {
        return "ImageFileHandler";
    }
}
