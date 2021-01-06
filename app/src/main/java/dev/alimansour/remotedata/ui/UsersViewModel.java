package dev.alimansour.remotedata.ui;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dev.alimansour.remotedata.data.APIClient;
import dev.alimansour.remotedata.data.APIService;
import dev.alimansour.remotedata.data.pojo.user.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * RemoteData Android Application developed by: Ali Mansour
 * Copyright © 2021 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- RemoteData IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public class UsersViewModel extends ViewModel {
    private final APIService service;
    private final MutableLiveData<List<UserResponse>> usersLiveData = new MutableLiveData<>();
    private final String TAG = UsersViewModel.class.getSimpleName();

    public UsersViewModel() {
        service = APIClient.getClient().create(APIService.class);
    }

    public LiveData<List<UserResponse>> getUsers() {
        Call<List<UserResponse>> call = service.getUsers();
        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(@NotNull Call<List<UserResponse>> call, @NotNull Response<List<UserResponse>> response) {
                usersLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<UserResponse>> call, @NotNull Throwable t) {
                Log.e(TAG, "Failed to retrieve users data\n" + t.getMessage());
            }
        });
        return usersLiveData;
    }
}
