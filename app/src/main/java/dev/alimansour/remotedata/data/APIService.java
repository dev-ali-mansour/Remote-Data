package dev.alimansour.remotedata.data;

import java.util.List;

import dev.alimansour.remotedata.data.pojo.user.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * RemoteData Android Application developed by: Ali Mansour
 * Copyright © 2021 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- RemoteData IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public interface APIService {

    @GET("/users")
    Call<List<UserResponse>> getUsers();
}
