/*
 * Copyright Txus Ballesteros 2015 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.txusballesteros.mara.presentation.main;

import android.os.Bundle;
import android.widget.Toast;

import com.txusballesteros.mara.R;
import com.txusballesteros.mara.presentation.BaseActivity;
import com.txusballesteros.mara.presentation.traits.FloatingButtonTrait;

public class MainActivity extends BaseActivity implements MainPresenter.View {
    private Mara_MainActivityComposer composer;
    private MainPresenter presenter;

    public MainActivity() {
        presenter = new MainPresenter(this);
        composer = new Mara_MainActivityComposer.Builder()
                                .setContext(this)
                                .setRootViewResourceId(R.id.rootView)
                                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureTraitsComposer();
        presenter.onViewCreated();
    }

    private void configureTraitsComposer() {
        composer.setOnFlaotingButtonClickListener(new FloatingButtonTrait.OnFlaotingButtonClickListener() {
            @Override
            public void onFloatingButtonClick() {
                Toast.makeText(MainActivity.this, "Hello World!!!", Toast.LENGTH_SHORT).show();
            }
        });
        composer.initialize();
    }

    @Override
    public void showLoading() {
        composer.showLoading();
    }

    @Override
    public void hideLoading() {
        composer.hideLoading();
    }
}