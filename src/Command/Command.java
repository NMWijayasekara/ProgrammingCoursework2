package Command;

import Order.Order;

public abstract class Command {
    public void log() {
        System.out.print("Command Logged");
    };
    public abstract void execute();
    public void undo() {
        System.out.print("Undo Command");
    };
}