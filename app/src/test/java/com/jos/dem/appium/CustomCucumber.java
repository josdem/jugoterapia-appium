/*
  Copyright 2019 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.appium;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import cucumber.api.CucumberOptions;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.junit.JUnitOptions;
import cucumber.runtime.junit.Assertions;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberTagStatement;
import gherkin.formatter.model.Tag;

import org.junit.runner.Description;
import org.junit.runners.ParentRunner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import com.jos.dem.appium.util.ConfigurationReader;

public class CustomCucumber extends ParentRunner<FeatureRunner> {
  private final Runtime runtime;
  private final JUnitReporter jUnitReporter;
  private final List<FeatureRunner> children = new ArrayList<>();

  public CustomCucumber(Class clazz) throws InitializationError, IOException {
    super(clazz);

    String testingStrategy = ConfigurationReader.getProperty("test.strategy");
    if(testingStrategy == null){
      throw new RuntimeException("Testing strategy needs to be defined");
    }

    ClassLoader classLoader = clazz.getClassLoader();
    Assertions.assertNoCucumberAnnotatedMethods(clazz);

    RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
    RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();
    runtimeOptions.getFilters().add(testingStrategy);

    addRunnerTag(runtimeOptions);

    ResourceLoader resourceLoader = new MultiLoader(classLoader);
    runtime = createRuntime(resourceLoader, classLoader, runtimeOptions);

    final List<CucumberFeature> cucumberFeatures = runtimeOptions.cucumberFeatures(resourceLoader);

    addFeatureTag(cucumberFeatures);

    jUnitReporter = new JUnitReporter(
        runtimeOptions.reporter(classLoader),
        runtimeOptions.formatter(classLoader),
        runtimeOptions.isStrict(),
        new JUnitOptions(runtimeOptions.getJunitOptions()));
    addChildren(cucumberFeatures);
	}

  private Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader,RuntimeOptions runtimeOptions) throws InitializationError, IOException {
    ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
    return new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
  }

  @Override
  public List<FeatureRunner> getChildren() {
    return children;
  }

  @Override
  protected Description describeChild(FeatureRunner child) {
		return child.getDescription();
	}

  @Override
  protected void runChild(FeatureRunner child, RunNotifier notifier) {
    child.run(notifier);
  }

  @Override
  public void run(RunNotifier notifier) {
    super.run(notifier);
    jUnitReporter.done();
    jUnitReporter.close();
    runtime.printSummary();
  }

  private void addChildren(List<CucumberFeature> cucumberFeatures) throws InitializationError {
    for (CucumberFeature cucumberFeature : cucumberFeatures) {
	    children.add(new FeatureRunner(cucumberFeature, runtime, jUnitReporter));
    }
  }

  private void addRunnerTag(RuntimeOptions runtimeOptions) {
    String tagToAdd = System.getProperty("dynamic.runner.tag.add","");
    if(!tagToAdd.isEmpty()){
      runtimeOptions.getFilters().add(tagToAdd);
    }
	}

  private void addFeatureTag(List<CucumberFeature> cucumberFeatures){
    String tagToAdd = System.getProperty("dynamic.feature.tag.add","");
    if(!tagToAdd.isEmpty()){
      for(CucumberFeature cucumberFeature : cucumberFeatures) {
        cucumberFeature.getGherkinFeature().getTags().add(new Tag(tagToAdd, 0));
      }
    }
  }
}
