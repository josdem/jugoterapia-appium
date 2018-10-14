package com.jos.dem.appium.config;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

import com.jos.dem.appium.service.CategoryService;
import com.jos.dem.appium.service.impl.CategoryServiceImpl;

@Module
public class ServiceModule {

  @Provides
  @Singleton
  public CategoryService provideCategoryService(){
    return new CategoryServiceImpl();
  }

}
