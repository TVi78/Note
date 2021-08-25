package com.zadania.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class NoteOpenFragment extends Fragment {
    public static String ARG_NOTE = "note";
    private Note note;

    public static NoteOpenFragment newInstance(Note note) {
        NoteOpenFragment fragment = new NoteOpenFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_open, container, false);
        String[] noteName = getResources().getStringArray(R.array.note_name);
        String[] noteDescription = getResources().getStringArray(R.array.note_description);
        String[] noteData = getResources().getStringArray(R.array.note_data);
        TextView textView = view.findViewById(R.id.textView);
        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);
        textView.setText(this.note.getName());
        textView1.setText(noteName[this.note.getNoteIndex()]);
        textView2.setText(noteDescription[this.note.getNoteIndex()]);
        textView3.setText(noteData[this.note.getNoteIndex()]);
        return view;
    }
}
