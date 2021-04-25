package br.com.jmarcelodias.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceStat) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String nomeDigitado = bundle.getString("txtNomeDigitado");
            TextView txtNome = (TextView) rootView.findViewById(R.id.txtNameResult);
            txtNome.setText(nomeDigitado);
        }

        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewv = view.findViewById(R.id.txtNameResult);


        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FirstFragment firstFragment = new FirstFragment();

                fragmentTransaction.replace(R.id.nav_host_fragment, firstFragment, firstFragment.getTag());
                fragmentTransaction.commit();
                NavController navController = NavHostFragment.findNavController(SecondFragment.this);
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}