package DesignPatterns.Behavioral.Command.tvstereo;

public class Client {

    public static void main(String[] args) {
        TV tv = new TV();
        Stereo stereo = new Stereo();

        Command turnOnTVCommand = new TurnOnCommand(tv);
        Command turnOffTVCommand = new TurnOffCommand(tv);
        Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo);
        Command changeChannelTVCommand = new ChangeChannelCommand(tv);


        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOnTVCommand);
        remote.pressButton();

        remote.setCommand(adjustVolumeStereoCommand);
        remote.pressButton();

        remote.setCommand(changeChannelTVCommand);
        remote.pressButton();

        remote.setCommand(turnOffTVCommand);
        remote.pressButton();
    }
}
