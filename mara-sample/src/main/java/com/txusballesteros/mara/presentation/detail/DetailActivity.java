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
package com.txusballesteros.mara.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.txusballesteros.mara.R;
import com.txusballesteros.mara.presentation.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailPresenter.View {
    private DetailPresenter presenter;
    private Mara_DetailActivityComposer composer;

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, DetailActivity.class);
    }

    public DetailActivity() {
        composer = new Mara_DetailActivityComposer.Builder()
                            .setBuilder(new DetailTraitBuilder(this))
                            .build();
        presenter = new DetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        configureTraitsComposer();
        presenter.onViewCreated();
    }

    private void configureTraitsComposer() {
        composer.initialize();
        composer.enableHomeAsUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
