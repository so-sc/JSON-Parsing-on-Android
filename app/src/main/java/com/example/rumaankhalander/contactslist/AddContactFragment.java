package com.example.rumaankhalander.contactslist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class AddContactFragment extends DialogFragment {
    public static AddContactFragment newInstance() {
        Bundle args = new Bundle();
        AddContactFragment fragment = new AddContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog_Alert);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText nameEditText = view.findViewById(R.id.name);
        TextInputEditText numberEditText = view.findViewById(R.id.number);

        Button add = view.findViewById(R.id.add);
        Button cancel = view.findViewById(R.id.cancel);

        add.setOnClickListener((v) -> {
            final String name = nameEditText.getText().toString();
            final String number = numberEditText.getText().toString();

            /* TODO: handle invalid inputs */
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(number)) {
                ((MainActivity) getActivity()).addContact(name, number);
            }

            /* Dismiss this dialog */
            dismiss();
        });

        cancel.setOnClickListener((v) -> dismiss());

        /* Focus on the edit text and show the soft input keyboard */
        nameEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.diaog_add_contact, container, false);
    }
}
