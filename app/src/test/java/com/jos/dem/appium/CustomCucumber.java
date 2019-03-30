package com.jos.dem.appium;

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
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomCucumber extends ParentRunner<FeatureRunner> {
	private final JUnitReporter jUnitReporter;
	private final List<FeatureRunner> children = new ArrayList<FeatureRunner>();
	private final Runtime runtime;

	public CustomCucumber(Class clazz) throws InitializationError, IOException {
		super(clazz);
		ClassLoader classLoader = clazz.getClassLoader();
		Assertions.assertNoCucumberAnnotatedMethods(clazz);

		RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
		RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();
    runtimeOptions.getFilters().add("@RegressionTest");

		//Add tags to Runner class
		addRunnerTag(runtimeOptions);

		ResourceLoader resourceLoader = new MultiLoader(classLoader);
		runtime = createRuntime(resourceLoader, classLoader, runtimeOptions);

		final List<CucumberFeature> cucumberFeatures = runtimeOptions.cucumberFeatures(resourceLoader);

		// Add tags at runtime
		addFeatureTag(cucumberFeatures);

		jUnitReporter = new JUnitReporter(runtimeOptions.reporter(classLoader), runtimeOptions.formatter(classLoader), runtimeOptions.isStrict(), new JUnitOptions(runtimeOptions.getJunitOptions()));
		addChildren(cucumberFeatures);
	}

	/**
	 * Create the Runtime. Can be overridden to customize the runtime or backend.
	 *
	 * @param resourceLoader used to load resources
	 * @param classLoader    used to load classes
	 * @param runtimeOptions configuration
	 * @return a new runtime
	 * @throws InitializationError if a JUnit error occurred
	 * @throws IOException if a class or resource could not be loaded
	 */
	protected Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader,
			RuntimeOptions runtimeOptions) throws InitializationError, IOException {
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
		final String tagToAdd = System.getProperty("dynamic.runner.tag.add","");
		if(!tagToAdd.isEmpty()){
			runtimeOptions.getFilters().add(tagToAdd);
		}
	}

	private void addFeatureTag(List<CucumberFeature> cucumberFeatures){
		final String tagToAdd = System.getProperty("dynamic.feature.tag.add","");
		if(!tagToAdd.isEmpty()){
			for(CucumberFeature cucumberFeature : cucumberFeatures) {
				cucumberFeature.getGherkinFeature().getTags().add(new Tag(tagToAdd, 0));
			}
		}
	}
}
