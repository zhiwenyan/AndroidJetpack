/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.steven.androidjetpack.room;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates data to pre-populate the database
 */
public class UserGenerator {

    private static final String[] NAMES = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final int[] AGES = new int[]{22, 23, 24, 25, 26};


    public static List<User> generateUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < NAMES.length; i++) {
            User user = new User();
            user.setUid(i + 1);
            user.setUserName(NAMES[i]);
            user.setAge(AGES[i]);
            users.add(user);
        }
        return users;
    }
}
