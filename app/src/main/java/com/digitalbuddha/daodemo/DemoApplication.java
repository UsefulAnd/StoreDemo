package com.digitalbuddha.daodemo;

import com.digitalbuddha.daodemo.di.AppComponent;
import com.digitalbuddha.daodemo.base.di.StoreModule;
import com.digitalbuddha.daodemo.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class DemoApplication extends android.app.Application {

    private AppComponent component;
    @Inject
    Picasso picasso; //Picasso, now with more Disk Caching!

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        component = DaggerAppComponent.builder()
                .storeModule(new StoreModule(this))
                .build();
        component.inject(this);

        Picasso.setSingletonInstance(picasso);
    }

    public AppComponent getApplicationComponent() {
        return component;
    }
}