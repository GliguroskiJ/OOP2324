package org.command;

public class CopyTextCommand implements TextEditorCommand{

    private StringBuilder builder;
    private String textToCopy;
    private String lastState;

    public CopyTextCommand(StringBuilder builder, String textToCopy) {
        this.builder = builder;
        this.textToCopy = textToCopy;
    }

    @Override
    public void append() {
        this.lastState=builder.toString();
        this.builder.append(textToCopy);
    }

    @Override
    public void undo() {
        this.builder.delete(0, builder.length());
        this.builder.append(lastState);
    }
}
