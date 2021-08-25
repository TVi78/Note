package com.zadania.note;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private int noteIndex;
    private String name;

    public Note(int noteIndex, String name) {
        this.noteIndex = noteIndex;
        this.name = name;
    }

    protected Note(Parcel in) {
        noteIndex = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(noteIndex);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public String getName() {
        return name;
    }
}

