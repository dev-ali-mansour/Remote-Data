package dev.alimansour.remotedata.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import dev.alimansour.remotedata.databinding.ActivityMainBinding;
import dev.alimansour.remotedata.ui.adapter.UserAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UsersViewModel viewModel;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        adapter = new UserAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        getAllUsers();

    }

    private void getAllUsers() {
        viewModel.getUsers().observe(this, users -> {
            if (users != null) {
                adapter.setDataSource(users);
                binding.recyclerView.setAdapter(adapter);
            }
        });
    }
}