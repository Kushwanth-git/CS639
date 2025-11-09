package com.example.aboutme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnHobbies = view.findViewById(R.id.btnHobbies);
        Button btnContact = view.findViewById(R.id.btnContact);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        NavController navController = Navigation.findNavController(view);

        btnHobbies.setOnClickListener(v -> navController.navigate(R.id.action_first_to_second));

        btnContact.setOnClickListener(v -> {
            Toast.makeText(getContext(), getString(R.string.going_to_contact), Toast.LENGTH_SHORT).show();
            navController.navigate(R.id.action_first_to_third);
        });

        fab.setOnClickListener(v -> Snackbar.make(view, getString(R.string.fab_message), Snackbar.LENGTH_LONG).show());
    }
}
