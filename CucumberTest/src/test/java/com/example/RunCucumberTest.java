package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // フィーチャーファイルの場所
        glue = "com.example.steps", // ステップ定義の場所
        plugin = {"pretty", "html:target/cucumber-reports.html"}) // レポートの設定
public class RunCucumberTest {
}
