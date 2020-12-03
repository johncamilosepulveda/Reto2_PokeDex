package model;

import java.io.Serializable;

public class TypeContainer implements Serializable {

    private int slot;
    private Type type;

    public TypeContainer(int slot, Type type) {
        this.slot = slot;
        this.type = type;
    }

    public TypeContainer() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
