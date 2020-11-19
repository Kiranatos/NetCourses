package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов

Old variant: package com.javarush.test.level17.lesson10.home05;  */

public class Core7Lvl17Lesson10Task05 {
    char[] value;
    int count;
    
    public Core7Lvl17Lesson10Task05 append(CharSequence s) {
        if (s == null) { s = "null"; }
        if (s instanceof String) { return this.append((String) s); }
        if (s instanceof Core7Lvl17Lesson10Task05) {
            return this.appendThis((Core7Lvl17Lesson10Task05) s);
        }
        return this.append(s);
    }
    
    public synchronized Core7Lvl17Lesson10Task05 appendThis(Core7Lvl17Lesson10Task05 s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields = {
        new java.io.ObjectStreamField("value", char[].class),
        new java.io.ObjectStreamField("count", Integer.TYPE),
        new java.io.ObjectStreamField("shared", Boolean.TYPE),};

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
        fields.put("value", value);
        fields.put("count", count);
        fields.put("shared", false);
        s.writeFields();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        java.io.ObjectInputStream.GetField fields = s.readFields();
        value = (char[]) fields.get("value", null);
        count = fields.get("count", 0);
    }        
}