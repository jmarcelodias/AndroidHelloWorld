package br.com.jmarcelodias.helloworld;

import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = ((EditText) view.findViewById(R.id.txtName));
        editText.requestFocus();

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable txtName = editText.getText();
                if (txtName == null || txtName.toString().isEmpty()) {
                    Toast toast = Toast.makeText(getActivity(), "Por Favor Digite o Seu Nome!!!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("txtNomeDigitado", txtName.toString()); // use as per your need
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    SecondFragment secondFragment = new SecondFragment();
                    secondFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.nav_host_fragment, secondFragment);
                    fragmentTransaction.commit();
                    NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            }
        });
    }
}