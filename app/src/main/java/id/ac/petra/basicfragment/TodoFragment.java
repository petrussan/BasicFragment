package id.ac.petra.basicfragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TodoFragment extends Fragment {
    private Todo mTodo;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mDoneCheckbox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTodo = new Todo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_todo,container,false);
        mTitleField = (EditText) v.findViewById(R.id.etTodo);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTodo.setmTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mDateButton = (Button) v.findViewById(R.id.taskdate);
        mDateButton.setText(mTodo.getmDate().toString());
        mDateButton.setEnabled(false);

        mDoneCheckbox = (CheckBox) v.findViewById(R.id.cbDone);
        mDoneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mTodo.setmDone(b);
            }
        });

        return v;

    }
}
